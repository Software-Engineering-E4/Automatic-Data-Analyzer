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

public class PieChartRedditPosts extends Application  {

    @Override
    public void start(Stage stage) throws SQLException {
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
        WritableImage image = chart.snapshot(new SnapshotParameters(), null);
        File file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\PieChartRedditPost.png");

        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)  {
       launch(args);

    }
}