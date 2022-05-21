package main.statistics;

import javafx.stage.Stage;
import main.statistics.piechart.PieChartRedditPosts;
import main.statistics.piechart.PieChartYoutube;

import java.sql.SQLException;


public class Main  {

    public static void main(String[] args) throws SQLException {
        PieChartYoutube.main(args);
        PieChartRedditPosts.main(args);


    }
}
