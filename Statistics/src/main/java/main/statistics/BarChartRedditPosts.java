package main.statistics;

import database.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import reddit.RedditPosts;

import java.util.Arrays;

public class BarChartRedditPosts extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
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


        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "2019", "2020", "2021", "2022")));
        xAxis.setLabel("category");


        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("score");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Comparison between posts over the years");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Negative");
        series1.getData().add(new XYChart.Data<>("2019", negative2019));
        series1.getData().add(new XYChart.Data<>("2020", negative2020));
        series1.getData().add(new XYChart.Data<>("2021", negative2021));
        series1.getData().add(new XYChart.Data<>("2022", negative2022));


        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Neutral");
        series2.getData().add(new XYChart.Data<>("2019", neutral2019));
        series2.getData().add(new XYChart.Data<>("2020", neutral2020));
        series2.getData().add(new XYChart.Data<>("2021", neutral2021));
        series2.getData().add(new XYChart.Data<>("2022", neutral2022));



        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Positive");
        series3.getData().add(new XYChart.Data<>("2019", positive2019));
        series3.getData().add(new XYChart.Data<>("2020", positive2020));
        series3.getData().add(new XYChart.Data<>("2021", positive2021));
        series3.getData().add(new XYChart.Data<>("2022", positive2022));



        barChart.getData().addAll(series1, series2, series3);

        Group root = new Group(barChart);

        Scene scene = new Scene(root ,600, 300);

        primaryStage.setTitle("Barchart Reddit");

        primaryStage.setScene(scene);

        primaryStage.show();

    }
    public static void main(String args[]){
        launch(args);
    }
}
