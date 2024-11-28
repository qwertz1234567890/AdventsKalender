module htl.steyr.kalender {
    requires javafx.controls;
    requires javafx.fxml;


    opens htl.steyr.kalender to javafx.fxml;
    exports htl.steyr.kalender;
}