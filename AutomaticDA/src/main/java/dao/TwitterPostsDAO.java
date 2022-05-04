package dao;

import database.Database;
import stanford.NLP;
import tools.Tool;
import java.sql.*;
import java.util.List;

public class TwitterPostsDAO {

    private TwitterPostsDAO(){}

    public static void analyzePosts(){
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM twitter_posts WHERE sentiment is NULL");

            while (rs.next()) {
                String id = rs.getString("id");
                String text = rs.getString("text");

                List<Double> sentimentList = NLP.estimatingSentiment(text);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
                Tool.format(sentimentList);

                String predominantSentiment = "negative";
                double predominant = sentimentList.get(0);

                if( sentimentList.get(0) < sentimentList.get(1) ){
                    predominant = sentimentList.get(1);
                    predominantSentiment = "neutral";
                }
                if( predominant < sentimentList.get(2) ){
                    predominantSentiment = "positive";
                }

                PreparedStatement statement = con.prepareStatement("UPDATE twitter_posts SET sentiment = ? WHERE id = ?");
                statement.setString(1,predominantSentiment);
                statement.setString(2,id);
                System.out.println(statement);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}