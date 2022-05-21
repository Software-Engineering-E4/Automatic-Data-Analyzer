module main.statistics {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;


    opens main.statistics to javafx.fxml;
    exports main.statistics;
    exports main.statistics.piechart;
    opens main.statistics.piechart to javafx.fxml;
    exports main.statistics.barchart;
    opens main.statistics.barchart to javafx.fxml;
    exports main.statistics.linechart;
    opens main.statistics.linechart to javafx.fxml;
}