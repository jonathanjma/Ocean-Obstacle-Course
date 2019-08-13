package tests;

import Objects.LineObj;
import Objects.MovingObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MoveObTest extends Application {

    private BorderPane mainPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        Pane gPane = new Pane();

        //MovingObject ob = new MovingObject(200, 100, 300, 250,"img/clownfish2.png",true);
        MovingObject ob = new MovingObject(470, 220, 150, 150, "img/trop1.png", true);
        LineObj obP = new LineObj(ob.getPath());
        gPane.getChildren().addAll(ob, obP);
        ob.startMove();

        gPane.setOnKeyPressed(e -> {
            /*if (e.getCode() == KeyCode.S) {
                ob.startMove();
            }
            if (e.getCode() == KeyCode.E) {
                ob.stopMove();
            }*/
            if (e.getCode() == KeyCode.LEFT) {
                ob.setX(ob.getX() + 10);
                ob.draw();
                obP.setX(ob.getX() + 10);
                obP.draw();
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                ob.setX(ob.getX() - 10);
                ob.draw();
                obP.setX(ob.getX() - 10);
                obP.draw();
            }
        });

        mainPane.setCenter(gPane);
        Scene scene = new Scene(mainPane, 600, 430);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        gPane.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
