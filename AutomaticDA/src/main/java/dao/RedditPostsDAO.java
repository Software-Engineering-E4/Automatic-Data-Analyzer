package dao;

import database.Database;
import stanford.NLP;
import tools.Tool;

import java.sql.*;
import java.util.List;

public class RedditPostsDAO {

    private RedditPostsDAO(){}

    public static void analyzePosts(){

        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM reddit_posts where neutral IS NULL");

            while (rs.next()) {
                String id = rs.getString("id");
                String selfText = rs.getString("selftext");
                String title = rs.getString("title");
                selfText = title.concat(". ").concat(selfText);

                List<Double> sentimentList = NLP.estimatingSentiment(selfText);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
                Tool.format(sentimentList);

                PreparedStatement statement = con.prepareStatement("UPDATE reddit_posts SET negative = ?, neutral = ?, positive = ? WHERE id = ?");
                statement.setDouble(1,sentimentList.get(0));
                statement.setDouble(2,sentimentList.get(1));
                statement.setDouble(3,sentimentList.get(2));
                statement.setString(4,id);
                System.out.println(statement);
                //statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}