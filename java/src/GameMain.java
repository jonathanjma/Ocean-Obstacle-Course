import java.util.ArrayList;

import Levels.Level;
import Levels.LevelOne;
import Levels.LevelFour;
import Levels.LevelThree;
import Levels.LevelTwo;
import Objects.LineObj;
import Objects.MovingObject;
import Objects.Player;
import Objects.RectangleObj;
import Objects.SimpleObject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * The Main Game Class
 * @author Jonathan Ma
 * @version 1.0
 */

public class GameMain extends Application {

    private BorderPane mainPane = new BorderPane();
    private Pane gPane = new Pane();
    private HBox infoBox;

    private Player p;
    private Level lvl;
    private AnimationTimer timer;
    private MediaPlayer gSoundPlayer;

    private int curLvl;
    private int lastLvl = 4;
    private int fails;

    private int curTime = 0;
    private int lvlTime;
    private Text healthText;
    private Text curLvlText;
    private int moveDist = 10;
    private int stX;

    /**
     * Application start method, entry point
     */
    @Override
    public void start(Stage primaryStage) {

        startScreen();

        /*gPane.setOnMouseClicked(e -> {
            System.out.println("x: " + (int) e.getSceneX() + ", y: " + (int) e.getSceneY());
        });*/

        gPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT && p.getX() > lvl.getLeftLimit()) {
                for (int i = 0; i < gPane.getChildren().size(); i++) {
                    SimpleObject s = (SimpleObject) gPane.getChildren().get(i);
                    if (s != p) {
                        s.setX(s.getX() + moveDist);
                        s.draw();
                        lvl.setLeftLimit(lvl.getLeftLimit() + moveDist);
                    }
                }
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                for (int i = 0; i < gPane.getChildren().size(); i++) {
                    SimpleObject s = (SimpleObject) gPane.getChildren().get(i);
                    if (s != p) {
                        s.setX(s.getX() - moveDist);
                        s.draw();
                        lvl.setLeftLimit(lvl.getLeftLimit() - moveDist);
                    }
                }
                if (p.getX() < stX) {
                    p.setX(p.getX() + 3);
                    p.draw();
                }
            }
            else if (e.getCode() == KeyCode.UP && p.getY() > 0) {
                p.setY(p.getY() - moveDist);
                p.draw();
            }
            else if (e.getCode() == KeyCode.DOWN && p.getY() < 360) {
                p.setY(p.getY() + moveDist);
                p.draw();
            }

            if (lvl.checkIntersectReg()) {
                doDamage(5);
            }
            checkLvlOver();
        });

        infoBox = new HBox(50);
        infoBox.setPadding(new Insets(5, 5, 5, 5));
        infoBox.setStyle("-fx-background-color: black");
        curLvlText = new Text(); curLvlText.setFill(Color.WHITE);
        healthText = new Text(); healthText.setFill(Color.WHITE);
        Text timerText = new Text("Time Since Start: 0 seconds"); timerText.setFill(Color.WHITE);
        infoBox.getChildren().addAll(curLvlText, healthText, timerText);

        timer = new AnimationTimer() {
            private long startTime;

            @Override
            public void start() {
                startTime = System.currentTimeMillis();
                super.start();
            }

            @Override
            public void stop() {
                super.stop();
                curTime = 0;
            }

            @Override
            public void handle(long now) {
                long newTime = System.currentTimeMillis();
                if (startTime + 1000 <= newTime) {
                    long timeDiff = (newTime - startTime) / 1000;
                    curTime += timeDiff;
                    startTime += 1000 * timeDiff;
                    timerText.setText("Time Since Start: " + curTime + " seconds");

                    //p.setX(p.getX() - moveDist/2); p.draw();
                    if (lvl.checkIntersectMov()) {
                        doDamage(5);
                    }
                    checkLvlOver();
                }
            }
        };

        Scene scene = new Scene(mainPane, 600, 430); //600x430
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Shows the main menu
     */
    public void startScreen() {
        VBox start = new VBox(15);
        start.setPadding(new Insets(30, 0, 0, 0));
        start.setAlignment(Pos.TOP_CENTER);

        Background ocean = new Background(new BackgroundImage(
                           new Image("img/ocean.gif"), null, null, null, null));
        start.setBackground(ocean);

        Media startSound = new Media(getClass().getResource("/img/oceansound.mp3").toExternalForm());
        MediaPlayer stSoundPlayer = new MediaPlayer(startSound);
        stSoundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        stSoundPlayer.setVolume(0.4);
        stSoundPlayer.play();

        Text welcome = new Text("Ocean Obstacle Course");
        welcome.setFont(Font.font(Font.getDefault() + "", FontWeight.SEMI_BOLD, 50));
        Text by = new Text("A Game by Jonathan Ma");
        by.setFont(Font.font(Font.getDefault() + "", FontWeight.THIN, FontPosture.ITALIC, 30));
        Text ph1 = new Text();
        Button how2Play = new Button("How To Play", new ImageView("img/qmark.png"));
        how2Play.setFont(Font.font(15));
        Button play = new Button("Start", new ImageView("img/play.png"));
        play.setFont(Font.font(15));

        start.getChildren().addAll(welcome, by, ph1, how2Play, play);

        Button back = new Button("Back to Main Menu", new ImageView("img/left.gif"));
        how2Play.setOnAction(e -> {
            VBox instructions = new VBox(15);
            instructions.setPadding(new Insets(30, 0, 20, 0));
            instructions.setAlignment(Pos.TOP_CENTER);
            instructions.setBackground(ocean);

            Text goalT = new Text("Goal");
            goalT.setFont(Font.font(Font.getDefault() + "", FontWeight.SEMI_BOLD, 30));
            Text goal1 = new Text("To Successfully Navigate The Obstacle Course"); goal1.setFont(Font.font(15));
            Text goal2 = new Text("Remember To Watch Your Health!"); goal2.setFont(Font.font(15));
            Text ph2 = new Text();
            Text controlT = new Text("Controls"); controlT.setFill(Color.WHITE);
            controlT.setFont(Font.font(Font.getDefault() + "", FontWeight.SEMI_BOLD, 30));
            Text controlH = new Text("Left/Right Arrow Keys to move horizontally");
            controlH.setFont(Font.font(15)); controlH.setFill(Color.WHITE);
            Text controlV = new Text("Up/Down Arrow Keys to move vertically");
            controlV.setFont(Font.font(15)); controlV.setFill(Color.WHITE);

            instructions.getChildren().addAll(goalT, goal1, goal2, ph2, controlT, controlH, controlV, back);
            mainPane.setCenter(instructions);
        });

        play.setOnAction(e -> {
            stSoundPlayer.stop();
            Media gameSound = new Media(getClass().getResource("/img/gamesound.mp3").toExternalForm());
            gSoundPlayer = new MediaPlayer(gameSound);
            gSoundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            gSoundPlayer.play();

            curLvl = 1;
            nextLevel();
            mainPane.setCenter(gPane);
            mainPane.setBottom(infoBox);
            
            Stop[] stops = {new Stop(0, Color.rgb(126, 192, 238)),
                            new Stop(1, Color.rgb(0, 64, 128))};
            LinearGradient background = new LinearGradient(0, 0, 0, 400,
                 false, CycleMethod.NO_CYCLE, stops);
                 
            gPane.setBackground(new Background(new BackgroundFill(background, null, null)));
            gPane.requestFocus();
            timer.start();
        });

        back.setOnAction(e -> mainPane.setCenter(start));

        mainPane.setCenter(start);
    }

    /**
     * Checks if the level is over- if the player's health is 0, x coordinate is less than 0,
     * or the level is completed
     */
    public void checkLvlOver() {
        if (p.getHealth() == 0 || p.getX() + p.getW() < 0 || lvl.checkCompleted()) {
            moveDist = 0;
            lvlTime = curTime; timer.stop();
            if (p.getHealth() == 0) levelEndScreen(1);
            if (p.getX() + p.getW() < 0) levelEndScreen(2);
            if (lvl.checkCompleted()) levelEndScreen(0);
            curLvl++;
            gPane.getChildren().clear();
            if (curLvl <= lastLvl) nextLevel();
        }
    }

    /**
     * Shows the level end screen
     * @param endReason how the level ended, 0- successful, 1- ran out of health, 2- overtaken by current
     */
    public void levelEndScreen(int endReason) {
        VBox lvlEnd = new VBox(15);
        lvlEnd.setAlignment(Pos.CENTER);

        Text endResult = new Text();
        ImageView endResultImg = new ImageView();
        if (endReason == 0) {
            endResult.setText("You Completed Level " + curLvl + "!");
            endResult.setFill(Color.GREEN);
            endResultImg.setImage(new Image("img/happyclownfish.jpg"));
        }
        if (endReason == 1 || endReason == 2) {
            if (endReason == 1) {
                endResult.setText("Level Failed \nYou Ran Out of Health");
            } else {
                endResult.setText("Level Failed \nThe Current Overtook You");
            }
            fails++;
            endResult.setTextAlignment(TextAlignment.CENTER);
            endResult.setFill(Color.RED);
            endResultImg.setImage(new Image("img/deadclownfish.png"));
        }
        endResult.setFont(Font.font(Font.getDefault() + "", FontWeight.BOLD, 30));

        Text timeSpent = new Text("Time Spent: " + lvlTime + " seconds"); timeSpent.setFont(Font.font(15));
        Text healthLost = new Text("Health Lost: " + (200 - p.getHealth())); healthLost.setFont(Font.font(15));

        Button nextAction = new Button();
        if (curLvl < lastLvl) {
            nextAction.setText("Next Level");
            nextAction.setGraphic(new ImageView("img/right.gif"));
        }
        else {nextAction.setText("Main Menu");}
        nextAction.setOnAction(e -> {
            if (curLvl <= lastLvl) {
                mainPane.setCenter(gPane);
                mainPane.setBottom(infoBox);
                gPane.requestFocus();
                timer.start();
            } else {
                gSoundPlayer.stop();
                startScreen();
            }
        });

        lvlEnd.getChildren().addAll(endResultImg, endResult, timeSpent, healthLost, nextAction);

        mainPane.setCenter(lvlEnd);
        mainPane.setBottom(null);
    }

    /**
     * Initializes next level
     */
    public void nextLevel() {
        if (curLvl == 1) {
            stX = 170;
            lvl = new LevelOne(1, "Finding the Reef", stX);
            p = lvl.addPlayer(stX, 80, "img/clownfish.png", 200);
        } else if (curLvl == 2) {
            stX = 50;
            lvl = new LevelTwo(2, "The Coral Reef", stX);
            p = lvl.addPlayer(stX, 60, "img/clownfish.png", 200);
        } else if (curLvl == 3) {
            stX = 50;
            lvl = new LevelThree(3, "The Open Ocean", stX);
            p = lvl.addPlayer(stX, 120, "img/seal.png", 200);
        } else if (curLvl == 4) {
            stX = 30;
            lvl = new LevelFour(4, "The Minefield", stX);
            p = lvl.addPlayer(stX, 200, "img/anglerfish.png", 200);
        }
        updateInfo();
        moveDist = 10;
        addLvlOb(lvl.addOb());
        gPane.getChildren().add(p); gPane.getChildren().add(new RectangleObj(p.getNode().getBoundsInLocal()));
    }

    /**
     * Adds all obstacles from a level to the screen
     * @param obList the level's obstacles
     */
    public void addLvlOb(ArrayList<SimpleObject> obList) {
        for (int i = 0; i < obList.size(); i++) {
            SimpleObject s = obList.get(i);
            gPane.getChildren().add(s);
            //System.out.println(s.getX() + s.getW());
            if (s instanceof MovingObject) {
                //gPane.getChildren().add(new LineObj(((MovingObject) s).getPath()));
                ((MovingObject) s).startMove();
            }
        }
    }

    /**
     * Removes all obstacles from a level from the screen
     * @param obList the level's obstacles
     */
    public void remLvlOb(ArrayList<SimpleObject> obList) {
        for (int i = 0; i < obList.size(); i++) {
            SimpleObject s = obList.get(i);
            gPane.getChildren().removeAll(s);
        }
    }

    /**
     * Does damage to the player
     * @param damage the amount of damage to do
     */
    public void doDamage(int damage) {
        if (p.getHealth() > 0) {
            p.setHealth(p.getHealth() - damage);
            updateInfo();
        }
    }

    /**
     * Updates the current level and player health text
     */
    public void updateInfo() {
        healthText.setText("Current Health: " + p.getHealth());
        curLvlText.setText("Level " + lvl.getLvl() + ": " + lvl.getLvlName());
    }

    /**
     * Starts the application
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
