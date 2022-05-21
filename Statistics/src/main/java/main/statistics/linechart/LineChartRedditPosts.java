package main.statistics.linechart;

import database.Database;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import reddit.RedditPosts;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class LineChartRedditPosts extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        Database.createConnection();
        RedditPosts redditPosts = new RedditPosts();

        Double[] neutral = new Double[9];
        Double[] negative = new Double[9];
        Double[] positive = new Double[9];
        List<String> months = Arrays.asList("01", "04", "05", "08", "09", "12");

        int i = 0;
        int year;
        for (year = 2020; year <= 2022; year++) {
            neutral[i] = redditPosts.findNeutralPostByMonthAndYear(months.get(0), months.get(1), year);
            negative[i] = redditPosts.findNegativePostByMonthAndYear(months.get(0), months.get(1), year);
            positive[i] = redditPosts.findPositivePostByMonthAndYear(months.get(0), months.get(1), year);

            neutral[i + 1] = redditPosts.findNeutralPostByMonthAndYear(months.get(2), months.get(3), year);
            negative[i + 1] = redditPosts.findNegativePostByMonthAndYear(months.get(2), months.get(3), year);
            positive[i + 1] = redditPosts.findPositivePostByMonthAndYear(months.get(2), months.get(3), year);

            neutral[i + 2] = redditPosts.findNeutralPostByMonthAndYear(months.get(4), months.get(5), year);
            negative[i + 2] = redditPosts.findNegativePostByMonthAndYear(months.get(4), months.get(5), year);
            positive[i + 2] = redditPosts.findPositivePostByMonthAndYear(months.get(4), months.get(5), year);
            i += 3;

        }


        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month-Year");
        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Sentiment Monitoring, 2020-2022");


        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Negative");
        series1.getData().add(new XYChart.Data("Jan-Apr 2020", negative[0]));
        series1.getData().add(new XYChart.Data("May-Aug 2020", negative[1]));
        series1.getData().add(new XYChart.Data("Sept-Dec 2020", negative[2]));
        series1.getData().add(new XYChart.Data("Jan-Apr 2021", negative[3]));
        series1.getData().add(new XYChart.Data("May-Aug 2021", negative[4]));
        series1.getData().add(new XYChart.Data("Sept-Dec 2021", negative[5]));
        series1.getData().add(new XYChart.Data("Jan-Apr 2022", negative[6]));
        series1.getData().add(new XYChart.Data("May-Aug 2022", negative[7]));


        var series2 = new Series();
        series2.setName("Neutral");

        series2.getData().add(new XYChart.Data("Jan-Apr 2020", neutral[0]));
        series2.getData().add(new XYChart.Data("May-Aug 2020", neutral[1]));
        series2.getData().add(new XYChart.Data("Sept-Dec 2020", neutral[2]));
        series2.getData().add(new XYChart.Data("Jan-Apr 2021", neutral[3]));
        series2.getData().add(new XYChart.Data("May-Aug 2021", neutral[4]));
        series2.getData().add(new XYChart.Data("Sept-Dec 2021", neutral[5]));
        series2.getData().add(new XYChart.Data("Jan-Apr 2022", neutral[6]));
        series2.getData().add(new XYChart.Data("May-Aug 2022", neutral[7]));


        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Positive");
        series3.getData().add(new XYChart.Data("Jan-Apr 2020", positive[0]));
        series3.getData().add(new XYChart.Data("May-Aug 2020", positive[1]));
        series3.getData().add(new XYChart.Data("Sept-Dec 2020", positive[2]));
        series3.getData().add(new XYChart.Data("Jan-Apr 2021", positive[3]));
        series3.getData().add(new XYChart.Data("May-Aug 2021", positive[4]));
        series3.getData().add(new XYChart.Data("Sept-Dec 2021", positive[5]));
        series3.getData().add(new XYChart.Data("Jan-Apr 2022", positive[6]));
        series3.getData().add(new XYChart.Data("May-Aug 2022", positive[7]));


        Scene scene = new Scene(lineChart, 1100, 800);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();
        WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);
        File file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\LineChartRedditPost.png");

        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
