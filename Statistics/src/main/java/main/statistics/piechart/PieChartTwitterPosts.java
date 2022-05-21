package main.statistics.piechart;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import database.Database;
import twitter.TwitterPosts;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class PieChartTwitterPosts  {

    public static PieChart pieChartTwitterPosts() throws SQLException {

        TwitterPosts twitterPosts = new TwitterPosts();

        Integer negative = twitterPosts.getNegativePost();
        Integer positive = twitterPosts.getPositivePost();
        Integer neutral = twitterPosts.getNeutralPost();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negative),
                        new PieChart.Data("Neutral", neutral),
                        new PieChart.Data("Positive", positive));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Twitter Posts Statistics");

        return chart;
    }


}

