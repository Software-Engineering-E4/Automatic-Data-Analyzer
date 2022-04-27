package main;
import dao.RedditPostsDAO;
import database.Database;
import stanford.NLP;


public class Analyzer {

    public static void main(String[] args) {

        NLP.init();
        Database.createConnection();
        RedditPostsDAO.analyzePosts();
        Database.closeConnection();
    }
}
