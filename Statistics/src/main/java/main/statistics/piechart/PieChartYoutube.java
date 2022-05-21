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
import youtube.YoutubeVideo;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class PieChartYoutube {

    public static PieChart pieChartYoutube() throws SQLException {

        YoutubeVideo youtubeVideo = new YoutubeVideo();

        Integer negative = youtubeVideo.getNegativePost();
        Integer positive = youtubeVideo.getPositivePost();
        Integer neutral = youtubeVideo.getNeutralPost();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negative),
                        new PieChart.Data("Neutral", neutral),
                        new PieChart.Data("Positive", positive));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("YouTube Videos Statistics");

        return chart;
    }

}
