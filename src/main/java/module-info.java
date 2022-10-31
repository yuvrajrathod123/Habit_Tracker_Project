module habitude.habitude1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens habitude.habitude1 to javafx.fxml;
    exports habitude.habitude1;
}