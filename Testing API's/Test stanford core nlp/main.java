import java.sql.*;
import java.util.List;

public class main
{

    public static void main(String[] args) throws SQLException {

        List<Double> sentimentList;
        NLP.init();

        Connection con = DriverManager.getConnection("jdbc:postgresql://ec2-52-48-159-67.eu-west-1.compute.amazonaws.com:5432/d43v2v49titgh7", "vddrzaqxcrcxlo", "0243d369b2198691aff71b4fcdbe81f10384a5b0b2e5de4fd83fcac951e29116");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(" SELECT * FROM reddit_posts LIMIT 5");

        while( rs.next() ){
            String id = rs.getString("id");
            String title = rs.getString("title");
            String selfText = rs.getString("selftext");

            sentimentList = NLP.estimatingSentiment(selfText);  // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment

            System.out.println( "ID: " + id + " TITLE: " + title + "\n" + selfText);
            System.out.println( "\nNegative sentiment percentage: " + sentimentList.get(0) + " Neutral sentiment percentage: " + sentimentList.get(1) + " Positive sentiment percentage: " + sentimentList.get(2) );

            System.out.println("\n***************************************************************************************************\n");
        }

        con.close();
    }
}
