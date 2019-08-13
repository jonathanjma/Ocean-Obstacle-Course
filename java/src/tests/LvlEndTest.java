package tests;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LvlEndTest extends Application {

    private BorderPane mainPane = new BorderPane();    

    @Override
    public void start(Stage primaryStage) {
        int endReason = 2; int curLvl = 1;

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
            endResult.setTextAlignment(TextAlignment.CENTER);
            endResult.setFill(Color.RED);
            endResultImg.setImage(new Image("img/deadclownfish.png"));
        }
        endResult.setFont(Font.font(Font.getDefault() + "", FontWeight.BOLD, 30));

        Button nextLvl = new Button("Next Level");
        //nextLvl.setOnAction(e -> mainPane.setCenter());
        
        lvlEnd.getChildren().addAll(endResultImg, endResult, nextLvl);
        
        mainPane.setCenter(lvlEnd);
        Scene scene = new Scene(mainPane, 600, 430);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { 
       Application.launch(args);
    }
}
