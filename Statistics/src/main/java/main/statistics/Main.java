package main.statistics;

import database.Database;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import main.statistics.barchart.BarChartRedditPosts;
import main.statistics.barchart.BarChartYoutube;
import main.statistics.linechart.LineChartRedditPosts;
import main.statistics.linechart.LineChartYoutube;
import main.statistics.piechart.PieChartRedditPosts;
import main.statistics.piechart.PieChartTwitterPosts;
import main.statistics.piechart.PieChartYoutube;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Database.createConnection();

        Group rootBarYoutube = new Group(BarChartYoutube.barChartYoutube());
        Scene sceneBarYoutube = new Scene(rootBarYoutube, 800, 600);
        stage.setScene(sceneBarYoutube);
        stage.show();

        WritableImage image = rootBarYoutube.snapshot(new SnapshotParameters(), null);
        File file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\BarChartYoutubeVideos.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();


        Group rootBarRedditPosts = new Group(BarChartRedditPosts.barChartRedditPosts());
        Scene sceneBarRedditPosts = new Scene(rootBarRedditPosts, 800, 600);
        stage.setScene(sceneBarRedditPosts);
        stage.show();

        image = rootBarRedditPosts.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\BarChartRedditPosts.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();

        Group rootLineRedditPosts = new Group(LineChartRedditPosts.lineChartRedditPosts());
        Scene sceneLineRedditPosts = new Scene(rootLineRedditPosts, 1100, 800);
        stage.setScene(sceneLineRedditPosts);
        stage.show();

        image = rootLineRedditPosts.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\LineChartRedditPosts.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();


        Group rootLineYoutube = new Group(LineChartYoutube.lineChartYoutube());
        Scene sceneLineYoutube = new Scene(rootLineYoutube, 1100, 800);
        stage.setScene(sceneLineYoutube);
        stage.show();

        image = rootLineYoutube.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\LineChartYoutube.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();

        Group rootPieRedditPosts = new Group(PieChartRedditPosts.pieChartRedditPosts());
        Scene scenePieRedditPosts = new Scene(rootPieRedditPosts, 500, 500);
        stage.setScene(scenePieRedditPosts);
        stage.show();

        image = rootPieRedditPosts.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\PieChartRedditPosts.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();


        Group rootPieTwitterPosts = new Group(PieChartTwitterPosts.pieChartTwitterPosts());
        Scene scenePieTwitterPosts = new Scene(rootPieTwitterPosts, 500, 500);
        stage.setScene(scenePieTwitterPosts);
        stage.show();

        image = rootPieTwitterPosts.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\PieChartTwitterPosts.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();


        Group rootPieYoutube = new Group(PieChartYoutube.pieChartYoutube());
        Scene scenePieYoutube = new Scene(rootPieYoutube, 500, 500);
        stage.setScene(scenePieYoutube);
        stage.show();

        image = rootPieYoutube.snapshot(new SnapshotParameters(), null);
        file = new File("C:\\Users\\Barna\\Desktop\\ip\\Statistics\\Statistics\\src\\main\\resources\\PieChartYoutubeVideos.png");
        if (file.delete()) {
            System.out.println("Deleted");
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();


        Database.closeConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
