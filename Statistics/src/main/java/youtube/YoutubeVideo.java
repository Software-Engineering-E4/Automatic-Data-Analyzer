package youtube;


import database.Database;
import java.sql.*;

public class YoutubeVideo {

    public YoutubeVideo(){}
    Connection con = Database.getConnection();
    public Integer getNegativePost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM youtube_videos where sentiment='negative' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getPositivePost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM youtube_videos where sentiment='positive' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getNeutralPost() throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM youtube_videos where sentiment='neutral' ")){
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Double findNeutralPostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.neutru) from (\n"
                     + "select count(*) as neutru\n"
                     + "from youtube_videos\n"
                     + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                     + "and sentiment = 'neutral'\n"
                     + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findPositivePostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.positiv) from (\n"
                     + "select count(*) as positiv\n"
                     + "from youtube_videos\n"
                     + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                     + "and sentiment = 'positive'\n"
                     + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findNegativePostByMonthAndYear(String month1, String month2,int year)throws SQLException{

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(t.negativ) from (\n"
                     + "select count(*) as negativ\n"
                     + "from youtube_videos\n"
                     + "where DATE_FORMAT(created_utc, '%m') BETWEEN '" + month1 + "' and '" + month2 + "' and DATE_FORMAT(created_utc, '%Y') = " + year +"\n"
                     + "and sentiment = 'negative'\n"
                     + "group by DATE_FORMAT(created_utc, '%m %Y')\n"
                     +"ORDER BY DATE_FORMAT(created_utc, '%Y %m') ASC ) t")){
            return rs.next() ? rs.getDouble(1) : null;
        }
    }



}

