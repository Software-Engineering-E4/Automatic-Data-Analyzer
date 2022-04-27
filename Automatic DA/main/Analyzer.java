package main;
import dao.RedditPostsDAO;
import dao.TwitterPostsDAO;
import dao.YouTubePostsDAO;
import database.Database;
import stanford.NLP;


public class Analyzer {

    public static void main(String[] args) {

        NLP.init();
        Database.createConnection();
        RedditPostsDAO.analyzePosts();
        YouTubePostsDAO.analyzePosts();
        TwitterPostsDAO.analyzePosts();
        Database.closeConnection();
    }
}
