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
            ResultSet rs = stmt.executeQuery(" SELECT * FROM reddit_posts LIMIT 5");

            while (rs.next()) {
                String id = rs.getString("id");
                String selfText = rs.getString("selftext");

                List<Double> sentimentList = NLP.estimatingSentiment(selfText);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
                Tool.format(sentimentList);

                PreparedStatement statement = con.prepareStatement("UPDATE reddit_posts SET negative = ?, neutral = ?, positive = ? WHERE id = ?");
                statement.setDouble(1,sentimentList.get(0));
                statement.setDouble(2,sentimentList.get(1));
                statement.setDouble(3,sentimentList.get(2));
                statement.setString(4,id);
                System.out.println(statement);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
