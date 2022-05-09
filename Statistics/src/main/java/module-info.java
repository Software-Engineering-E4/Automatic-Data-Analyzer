module main.statistics {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;


    opens main.statistics to javafx.fxml;
    exports main.statistics;
}