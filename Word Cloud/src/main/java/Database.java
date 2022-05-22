import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://ip-database.ccrihfbatmnt.eu-central-1.rds.amazonaws.com:3306/ipdatabase";
    private static final String USER = "admin";
    private static final String PASSWORD = "6kT4Yi1S7AtqErWTxZyD";
    private static Connection connection = null;

    private Database() {}

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
