package tests;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartTest extends Application {

    private BorderPane mainPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        VBox start = new VBox(15);
        start.setPadding(new Insets(30, 0, 0, 0));
        start.setAlignment(Pos.TOP_CENTER);
        Background ocean = new Background(new BackgroundImage(
                new Image("img/ocean.gif"), null, null, null, null));
        start.setBackground(ocean);
        Media sound = new Media(getClass().getResource("/img/oceansound.mp3").toExternalForm());
        MediaPlayer soundPlayer = new MediaPlayer(sound);
        soundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        soundPlayer.setVolume(0.25);
        soundPlayer.play();

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
            // start/initialize gPane
        });

        back.setOnAction(e -> mainPane.setCenter(start));

        mainPane.setCenter(start);
        Scene scene = new Scene(mainPane, 600, 430);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { 
       Application.launch(args);
    }
}
