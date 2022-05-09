package main.statistics;

import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import reddit.RedditPosts;

import java.sql.SQLException;

public class LineChartRedditPosts  extends Application{
    @Override public void start(Stage stage) throws SQLException {
        Database.createConnection();
        RedditPosts redditPosts = new RedditPosts();

        Double positive2019 = redditPosts.findPositivePostByYear(2019);
        Double positive2020 = redditPosts.findPositivePostByYear(2020);
        Double positive2021 = redditPosts.findPositivePostByYear(2020);
        Double positive2022 = redditPosts.findPositivePostByYear(2021);

        Double negative2019 = redditPosts.findNegativePostByYear(2019);
        Double negative2020 = redditPosts.findNegativePostByYear(2020);
        Double negative2021 = redditPosts.findNegativePostByYear(2021);
        Double negative2022 = redditPosts.findNegativePostByYear(2022);

        Double neutral2019 = redditPosts.findNeutralPostByYear(2019);
        Double neutral2020 = redditPosts.findNeutralPostByYear(2020);
        Double neutral2021 = redditPosts.findNeutralPostByYear(2021);
        Double neutral2022 = redditPosts.findNeutralPostByYear(2022);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        final LineChart<String,Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Sentiment Monitoring, 2019-2022");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Neutral");

        series1.getData().add(new XYChart.Data("2019", neutral2019));
        series1.getData().add(new XYChart.Data("2020", neutral2020));
        series1.getData().add(new XYChart.Data("2021", neutral2021));
        series1.getData().add(new XYChart.Data("2022", neutral2022));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Positive");
        series2.getData().add(new XYChart.Data("2019", positive2019));
        series2.getData().add(new XYChart.Data("2020", positive2020));
        series2.getData().add(new XYChart.Data("2021", positive2021));
        series2.getData().add(new XYChart.Data("2022", positive2022));


        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Negative");
        series3.getData().add(new XYChart.Data("2019", negative2019));
        series3.getData().add(new XYChart.Data("2020", negative2020));
        series3.getData().add(new XYChart.Data("2021", negative2021));
        series3.getData().add(new XYChart.Data("2022", negative2022));


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
