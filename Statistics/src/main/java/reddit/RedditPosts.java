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

    public Double findNeutralPostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.neutru) from (\n"
                    + "select avg(neutral) as neutru\n"
                     + "from reddit_posts\n"
                    + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                    + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findPositivePostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.positiv) from (\n"
                     + "select avg(positive) as positiv\n"
                     + "from reddit_posts\n"
                     + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                     + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findNegativePostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.negativ) from (\n"
                     + "select avg(negative) as negativ\n"
                     + "from reddit_posts\n"
                     + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                     + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

}
