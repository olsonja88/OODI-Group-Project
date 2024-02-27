module App {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.metrostate to javafx.fxml;
    exports edu.metrostate;
    exports edu.metrostate.ui;
    opens edu.metrostate.ui to javafx.fxml;
}
