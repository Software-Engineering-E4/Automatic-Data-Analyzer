package reddit;

import database.Database;
import java.sql.*;

public class RedditPosts {

    public RedditPosts(){}
    Connection con = Database.getConnection();
    public Double getNegativePost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT avg(negative) FROM reddit_posts ")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double getPositivePost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT avg(positive) FROM reddit_posts ")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double getNeutralPost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT avg(neutral) FROM reddit_posts  ")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findPositivePostByYear(int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT avg(positive) FROM reddit_posts where DATE_FORMAT(created_utc,'%Y') = " + year)){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }
    public Double findNegativePostByYear(int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT avg(negative) FROM reddit_posts where DATE_FORMAT(created_utc,'%Y') = " + year)){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }
    public Double findNeutralPostByYear(int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT avg(neutral) FROM reddit_posts where DATE_FORMAT(created_utc,'%Y') = " + year)){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

}
