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
import reddit.RedditPosts;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class PieChartRedditPosts   {

    public static PieChart pieChartRedditPosts() throws SQLException {


        RedditPosts redditPosts = new RedditPosts();

        Double negativePosts = redditPosts.getNegativePost();
        Double positivePosts = redditPosts.getPositivePost();
        Double neutralPosts = redditPosts.getNeutralPost();


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negativePosts),
                        new PieChart.Data("Neutral", neutralPosts),
                        new PieChart.Data("Positive", positivePosts));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Reddit Posts Statistics");


    return chart;
    }

}