package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://ip-database.ccrihfbatmnt.eu-central-1.rds.amazonaws.com:3306/ipdatabase";
    private static final String USER = "admin";
    private static final String PASSWORD = "6kT4Yi1S7AtqErWTxZyD";
    private static Connection connection = null;

    private Database(){}

    public static void createConnection(){
        try{
            if( connection != null )
                throw new SQLException("Connection already created!");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
