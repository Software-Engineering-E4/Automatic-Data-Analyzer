package reddit;

import database.Database;
import java.sql.*;

public class RedditComm {

    public RedditComm(){}
    Connection con = Database.getConnection();
    public Integer getNegativeComm() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM reddit_comments where sentiment='negative' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getPositiveComm() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM reddit_comments where sentiment='positive' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getNeutralComm() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM reddit_comments where sentiment='neutral' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }



}
