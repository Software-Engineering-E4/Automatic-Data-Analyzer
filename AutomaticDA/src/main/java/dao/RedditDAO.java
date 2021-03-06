package dao;

import database.Database;
import stanford.NLP;
import tools.Tool;

import java.sql.*;
import java.util.List;

public class RedditDAO {

    private RedditDAO(){}

    public static void analyzeComments(){

        try{
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM reddit_comments where sentiment IS NULL");

            while( rs.next() ){
                String id = rs.getString("id");
                String selfText = rs.getString("selftext");

                List<Double> sentimentList = NLP.estimatingSentiment(selfText);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
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

                PreparedStatement statement = con.prepareStatement("UPDATE reddit_comments SET sentiment = ? WHERE id = ?");
                statement.setString(1,predominantSentiment);
                statement.setString(2,id);
                System.out.println(statement);
                statement.executeUpdate();
                statement.close();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void analyzePosts(){

        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM reddit_posts where neutral IS NULL");

            while (rs.next()) {
                String id = rs.getString("id");
                String selfText = rs.getString("selftext");
                String title = rs.getString("title");

                System.out.println(id);

                if( selfText == null )
                    selfText = title;
                else
                    selfText = title.concat(". ").concat(selfText);

                List<Double> sentimentList = NLP.estimatingSentiment(selfText);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
                Tool.format(sentimentList);

                PreparedStatement statement = con.prepareStatement("UPDATE reddit_posts SET negative = ?, neutral = ?, positive = ? WHERE id = ?");
                statement.setDouble(1,sentimentList.get(0));
                statement.setDouble(2,sentimentList.get(1));
                statement.setDouble(3,sentimentList.get(2));
                statement.setString(4,id);
                System.out.println(statement);
                statement.executeUpdate();
                statement.close();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}