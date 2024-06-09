package healthCareManagement;


import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    static String jdbcUrl;
    static String username;
    static String password;
    
    public static java.sql.Connection getConnection() {
        jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        username = "LAB05_QLKB";
        password = "password";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
        return null; // or throw an exception here
    }
}
