package main.statistics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import database.Database;
import reddit.RedditComm;
import reddit.RedditPosts;


import java.sql.SQLException;

public class PieChartRedditPosts extends Application {

    @Override public void start(Stage stage) throws SQLException {
        Database.createConnection();

        RedditPosts redditPosts = new RedditPosts();

        Double negativePosts = redditPosts.getNegativePost();
        Double positivePosts = redditPosts.getPositivePost();
        Double neutralPosts = redditPosts.getNeutralPost();

        Scene scene = new Scene(new Group());
        stage.setTitle("Reddit Posts");
        stage.setWidth(500);
        stage.setHeight(500);


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negativePosts),
                        new PieChart.Data("Neutral", neutralPosts),
                        new PieChart.Data("Positive", positivePosts));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Reddit Posts Statistics");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}