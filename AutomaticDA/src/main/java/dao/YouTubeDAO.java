package dao;

import database.Database;
import stanford.NLP;
import tools.Tool;
import java.sql.*;
import java.util.List;

public class YouTubeDAO {

    private YouTubeDAO(){}

    public static void analyzePosts(){
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM youtube_videos");

            while (rs.next()) {
                String id = rs.getString("id");
                String description = rs.getString("description");
                String title = rs.getString("title");
                String descriptionTranslated = rs.getString("description");
                String titleTranslated = rs.getString("title_translated");

                String toAnalyze = "";
                if( titleTranslated != null )
                    toAnalyze = toAnalyze.concat(titleTranslated);
                else
                    toAnalyze = toAnalyze.concat(title);

                if( descriptionTranslated != null )
                    toAnalyze = toAnalyze.concat(descriptionTranslated);
                else if( description != null)
                    toAnalyze = toAnalyze.concat(description);

                System.out.println(toAnalyze);

                List<Double> sentimentList = NLP.estimatingSentiment(toAnalyze);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
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

                PreparedStatement statement = con.prepareStatement("UPDATE youtube_videos SET sentiment = ? WHERE id = ?");
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

}