package htl.steyr.kalender;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdventCalendar extends Application {

    private static final int DAYS_IN_ADVENT = 24;
    private static final int BUTTON_SIZE = 100;

    @Override
    public void start(Stage primaryStage) {
        // Create the root layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Set the initial background style
        root.setStyle("-fx-background-image: url('bg.png'); " +
                "-fx-background-size: stretch; " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-position: center;");

        // Create a title
        Button title = new Button("🎄 Advent Calendar 🎄");
        title.setStyle("-fx-background-color: transparent; -fx-text-fill: white; " +
                "-fx-font-size: 24px; -fx-font-weight: bold; -fx-cursor: default;");
        title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BeautifulFont.ttf"), 36));
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        // Create a grid layout for the calendar
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add buttons for each day
        for (int day = 1; day <= DAYS_IN_ADVENT; day++) {
            Button dayButton = new Button(String.valueOf(day));
            dayButton.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
            dayButton.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #ffcccc, #ff6666);" +
                            "-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10;" +
                            "-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;" +
                            "-fx-background-radius: 10;"
            );

            // Add action to open a new window with the image
            int currentDay = day; // Needed for lambda expression
            dayButton.setOnAction(event -> openImageInNewWindow(currentDay));

            // Add the button to the grid
            int row = (day - 1) / 6; // 6 buttons per row
            int col = (day - 1) % 6; // Calculate column
            gridPane.add(dayButton, col, row);
        }

        // Center the grid in the layout
        root.setCenter(gridPane);

        // Set up the scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Advent Calendar with New Window Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to open an image in a new window
    private void openImageInNewWindow(int day) {
        // Construct the image file name
        String imageUrl = "bg (" + day + ").png";

        // Create a new stage
        Stage imageStage = new Stage();
        imageStage.setTitle("Day " + day);

        // Create an ImageView to display the image
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(600); // Adjust size as needed
        imageView.setFitHeight(600); // Adjust size as needed

        // Create a layout for the new stage
        StackPane imagePane = new StackPane(imageView);
        imagePane.setStyle("-fx-background-color: black;"); // Optional: dark background
        Scene scene = new Scene(imagePane, 600, 600);

        // Set up the new stage
        imageStage.setScene(scene);
        imageStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
