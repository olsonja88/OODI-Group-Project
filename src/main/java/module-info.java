module App {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.metrostate to javafx.fxml;
    exports edu.metrostate;
    exports edu.metrostate.ui;
    exports edu.metrostate.ui.landingpage;
    opens edu.metrostate.ui to javafx.fxml;
}
