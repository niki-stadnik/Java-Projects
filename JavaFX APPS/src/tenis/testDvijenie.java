package tenis;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class testDvijenie extends Application {
    Pane root = new Pane();
    final static int[] i = {50};

    @Override
    public void start(Stage primaryStage) {

        boolean x = false;


        //Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 1000, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(-5, 5);

        Line line = new Line(0, 25, 250, 25);

        Button btn = new Button();
        btn.setStyle("-fx-font: 24 arial;");
        btn.setMinWidth(100);
        btn.setMinHeight(100);
        btn.relocate(400, 400);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("wtf");
                i[0] = i[0] + 50;
                Line line2 = new Line(50, i[0], 250, 250);
                root.getChildren().add(line2);
                newBall();
            }
        });
        root.getChildren().add(btn);

        //newBall();

        //testche y = new testche();
        //y.vikane();
        testche.vikane();


        root.getChildren().add(ball);
        root.getChildren().add(line);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

        });

        primaryStage.setTitle("Animated Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                double dx = 1; //Step on x or velocity
                double dy = 0; //Step on y

                //move the ball
                ball.setLayoutX(ball.getLayoutX() + dx);
                ball.setLayoutY(ball.getLayoutY() + dy);
            }
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    void newBall() {
        i[0] = i[0] + 50;
        Line line2 = new Line(50, i[0], 250, 250);
        root.getChildren().add(line2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class testche {
    public static void vikane() {
        testDvijenie x = new testDvijenie();
        x.newBall();
        //testDvijenie.newBall();
    }
}