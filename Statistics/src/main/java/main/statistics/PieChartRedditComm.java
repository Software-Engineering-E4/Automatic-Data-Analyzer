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


import java.sql.SQLException;

public class PieChartRedditComm extends Application {

    @Override public void start(Stage stage) throws SQLException {

        Database.createConnection();

        RedditComm redditComm = new RedditComm();

        Integer negativeComm = redditComm.getNegativeComm();
        Integer positiveComm = redditComm.getPositiveComm();
        Integer neutralComm = redditComm.getNeutralComm();


        Scene scene = new Scene(new Group());
        stage.setTitle("Reddit Comments");
        stage.setWidth(500);
        stage.setHeight(500);


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Negative", negativeComm),
                        new PieChart.Data("Neutral", neutralComm),
                        new PieChart.Data("Positive", positiveComm));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Reddit Comments Statistics");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}