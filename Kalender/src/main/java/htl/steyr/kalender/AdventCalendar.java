package htl.steyr.kalender;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdventCalendar extends Application {

    private static final int DAYS_IN_ADVENT = 24;

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for the calendar layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between tiles
        gridPane.setVgap(10); // Vertical gap between tiles

        // Add buttons for each day
        for (int day = 1; day <= DAYS_IN_ADVENT; day++) {
            Button dayButton = new Button(String.valueOf(day));
            dayButton.setPrefSize(80, 80); // Set size of each button

            // Add action to each button
            dayButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Advent Calendar");
                alert.setHeaderText("Day " + dayButton.getText());
                alert.setContentText("Surprise! 🎁");
                alert.showAndWait();
            });

            // Add the button to the grid
            int row = (day - 1) / 4; // 4 buttons per row
            int col = (day - 1) % 4; // Calculate column
            gridPane.add(dayButton, col, row);
        }

        // Create a scene and display the stage
        StackPane root = new StackPane(gridPane);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Advent Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
