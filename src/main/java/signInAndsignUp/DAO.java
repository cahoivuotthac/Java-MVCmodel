package signInAndsignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    /*It's generally better to use local variables for Connection, Statement, and ResultSet within each method. 
    This approach ensures that resources are properly managed and closed after use.*/
    public static boolean signIn(String username, String pass) {
        try {
            Connection conn = ConnectionJDBC.getConnection();
            String query = "SELECT * FROM USER_TK WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            ResultSet rset = pstm.executeQuery();
            if (rset.next()) {
                if (username.equals(rset.getString(1))
                        && pass.equals(rset.getString(2))) {
                    conn.close();
                    return true;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int signUp(String username, String pass) {
        int row = 0;
        try {
            Connection conn = ConnectionJDBC.getConnection();
            String query = "INSERT INTO USER_TK(USERNAME, PASSWORD) VALUES(?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            row = pstm.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return row;
    }
}
