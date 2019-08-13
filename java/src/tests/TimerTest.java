package tests;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimerTest extends Application {

    private BorderPane mainPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        HBox infoBox = new HBox(30);
        infoBox.setPadding(new Insets(5, 5, 5, 5));
        infoBox.setStyle("-fx-background-color: black");
        Text curLvlText = new Text("Levels.Level 1: Intro"); curLvlText.setFill(Color.WHITE);
        Text healthText = new Text("Current Health: 100"); healthText.setFill(Color.WHITE);
        Text timerText = new Text("Time Since Start: 0 seconds"); timerText.setFill(Color.WHITE);
        infoBox.getChildren().addAll(curLvlText, healthText, timerText);

        AnimationTimer timer = new AnimationTimer() {
            private long startTime;
            private long curTime = 0;

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
                long timeDiff = (System.currentTimeMillis() - startTime) / 1000;
                curTime += timeDiff;
                startTime += 1000 * timeDiff;
                timerText.setText("Time Since Start: " + curTime + " seconds");
            }
        };

        Button start = new Button("start"); start.setOnAction(event -> timer.start());
        Button stop = new Button("stop"); stop.setOnAction(event -> timer.stop());
        infoBox.getChildren().addAll(start, stop);

        mainPane.setBottom(infoBox);
        Scene scene = new Scene(mainPane, 600, 430);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { 
       Application.launch(args);
    }
}
