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

public class PieChartTwitterPosts extends Application {

    @Override
    public void start(Stage stage) throws SQLException {

        Database.createConnection();

        TwitterPosts twitterPosts = new TwitterPosts();

        Integer negative = twitterPosts.getNegativePost();
        Integer positive = twitterPosts.getPositivePost();
        Integer neutral = twitterPosts.getNeutralPost();


        Scene scene = new Scene(new Group());
        stage.setTitle("Twitter Posts");
        stage.setWidth(500);
        stage.setHeight(500);


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negative),
                        new PieChart.Data("Neutral", neutral),
                        new PieChart.Data("Positive", positive));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Twitter Posts Statistics");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
        WritableImage image = chart.snapshot(new SnapshotParameters(), null);
        File file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\PieChartTwitter.png");

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

