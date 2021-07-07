package tenis;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class tenis extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 300, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(5, 5);

        Rectangle left = new Rectangle(10, 50, Color.CADETBLUE);
        left.relocate(5, 50);

        Rectangle right = new Rectangle(10, 50, Color.CADETBLUE);
        right.relocate(285, 50);

        root.getChildren().add(ball);
        root.getChildren().add(left);
        root.getChildren().add(right);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.UP) {
                right.setLayoutY(right.getLayoutY() - 30);
            } else if (key.getCode() == KeyCode.DOWN) {
                right.setLayoutY(right.getLayoutY() + 30);
            } else if (key.getCode() == KeyCode.W) {
                left.setLayoutY(left.getLayoutY() - 30);
            } else if (key.getCode() == KeyCode.S) {
                left.setLayoutY(left.getLayoutY() + 30);
            }
        });

        primaryStage.setTitle("Animated Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            double dx = 2; //Step on x or velocity
            double dy = 1; //Step on y

            @Override
            public void handle(ActionEvent t) {
                //move the ball
                ball.setLayoutX(ball.getLayoutX() + dx);
                ball.setLayoutY(ball.getLayoutY() + dy);

                Bounds bounds = root.getBoundsInLocal();

                //If the ball reaches the left or right border make the step negative
                if ((ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius() + 15)) && (ball.getLayoutY() > left.getLayoutY()) && (ball.getLayoutY() < left.getLayoutY() + 50)
                        || (ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius() - 15)) && (ball.getLayoutY() > right.getLayoutY()) && (ball.getLayoutY() < right.getLayoutY() + 50)) {

                    dx = -dx;
                }

                //If the ball reaches the bottom or top border make the step negative
                if ((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius()))
                        || (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))) {

                    dy = -dy;

                }
            }
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
