package TicTacToeAPP;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Unexpected
 */
public class TicTacToeAPP extends Application {

    char player = 'X';
  //  masiiiv
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                btn.setStyle("-fx-font: 24 arial;");
                btn.setMinWidth(100);
                btn.setMinHeight(100);

                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        if (btn.getText().isEmpty()) {                //isEmpty za vseki string vry6ta true ili fals
                            btn.setText(String.valueOf(player));
                            // btn.setText(player + " ");            //po dyrvena opciq za pravene na tova otdolo
                            btn.setText(String.valueOf(player));
                            if (player == 'X') {    // ako sravnqvame primitivni tipove ( takiva zapo4va6ti s malki bukvi kato 'char' pi6em == a ako sravnqvame 'String' trqbva da se polzva .equals !!!
                                player = '0';
                            } else {
                                player = 'X';
                            }
                            // slagame promenlivite v masiv koito proverqvame!!!
                        }
                    }
                });

                root.add(btn, j, i);
            }
        }

        Scene scene = new Scene(root, 300, 250);
//check columns for victory
 /*       for (int i = 0; i < 3; i++) {
            boolean columnIsFull = true;
            for (int j = 0; j < 3; j++) {
                if (btn.getText().equals(player)) {
                    columnIsFull = false;
                }
            }
            if (columnIsFull) {
                System.out.println(player + " wins!");
                return;
            }
        }*/
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}