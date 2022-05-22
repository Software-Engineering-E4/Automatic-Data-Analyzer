import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RedditPostsDAO {

    public String getSelftext() throws SQLException {
        String text = " ";
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT selftext FROM reddit_posts LIMIT 50")) {
            while(rs.next()){
                text += rs.getString("selftext");
            }
        }
        return text;
    }

}
