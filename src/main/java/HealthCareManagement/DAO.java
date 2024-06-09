package healthCareManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    
    public static int insertNewPatient(String id, String name, Date date, String address, String phoneNum, int gender){
        int row = 0;
        try {
            Connection conn = ConnectionJDBC.getConnection();
            String query = "INSERT INTO BENHNHAN(MABN, TENBN, NGSINH, DCHI, DTHOAI, GIOITINH) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareCall(query);
            p.setString(1, id);
            p.setString(2, name);
            p.setDate(3, date);
            p.setString(4, address);
            p.setString(5, phoneNum);
            p.setInt(6, gender);
            
            row = p.executeUpdate();
            conn.commit();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Loi o day");
        }
        return row;
    }
}
