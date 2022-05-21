package twitter;

import database.Database;

import java.sql.*;

public class TwitterPosts {

    public TwitterPosts() {
    }

    Connection con = Database.getConnection();

    public Integer getNegativePost() throws SQLException {

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM twitter_posts where sentiment='negative' ")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getPositivePost() throws SQLException {

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM twitter_posts where sentiment='positive' ")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer getNeutralPost() throws SQLException {

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(" SELECT count(*) FROM twitter_posts where sentiment='neutral' ")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }




}

