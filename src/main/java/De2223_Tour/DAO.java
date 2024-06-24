package De2223_Tour;

import static healthCareManagement.ConnectionJDBC.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAO {

    public static void insertTour(String ten, String ngay, String sn, String sd, String gia) {
        try {
            Connection c = getConnection();
            String q = "INSERT INTO TOUR(TenTour, NgayKhoiHanh, SoNgay, SoDem, Gia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1, ten);
            p.setString(2, ngay);
            p.setString(3, sn);
            p.setString(4, sd);
            p.setString(5, gia);

            int r = p.executeUpdate();
            if (r == 1) {
                c.commit();
            }
            c.close();
            p.close();
        } catch (SQLException e) {
        }
    }

    public static String[] getTenTinhTP() {
        List<String> l = new ArrayList<>();

        try {
            Connection c = getConnection();
            String q = "SELECT TENTTP FROM TINHTP";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(q);
            while (r.next()) {
                l.add(r.getString(1));
            }

            c.close();
            s.close();
            r.close();
        } catch (SQLException e) {
        }
        return l.toArray(String[]::new);
    }

    public static int getMa(char type, String ten) {
        int ms = 0;
        try {
            Connection c = getConnection();
            String q = null;
            PreparedStatement p;
            if (type == 't') {
                q = "SELECT MATTP FROM TINHTP WHERE TENTTP = ?";
            } else if (type == 'd') {
                q = "SELECT MADDL FROM DIEMDL WHERE TENDDL = ?";
            }
            p = c.prepareStatement(q);
            p.setString(1, ten);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ms = r.getInt(1);
            }
        } catch (SQLException e) {
        }
        return ms;
    }

    public static void insertDiemDL(String tenTp, String tendl, String dtr) {
        try {
            Connection c = getConnection();
            String q = "INSERT INTO DIEMDL(TENDDL, MATTP, DACTRUNG) VALUES(?, ?, ?)";
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1, tenTp);
            p.setString(2, tendl);
            p.setString(3, dtr);

            int r = p.executeUpdate();
            if (r == 1) {
                c.commit();
            }
            c.close();
            p.close();
        } catch (SQLException e) {
        }
    }

    public static String[] getThongTinTour(String ms) {
        List<String> l = new ArrayList<>();
        try {
            Connection c = getConnection();
            String q = "SELECT TENTOUR, NGAYKHOIHANH, SONGAY, SODEM, GIA FROM TOUR"
                    + " WHERE MATOUR = ?";
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1, ms);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                l.add(r.getString(1));
                l.add(r.getString(2));
                l.add(r.getString(3));
                l.add(r.getString(4));
                l.add(r.getString(5));
            }
        } catch (SQLException e) {
        }
        return l.toArray(String[]::new);
    }

    public static HashMap<String, String> getTable1(int ms) {
        HashMap<String, String> h = new HashMap<>();

        try {
            Connection c = getConnection();
            String q = "SELECT TENDDL, DACTRUNG FROM DIEMDL WHERE MATTP = ?";
            PreparedStatement p = c.prepareStatement(q);
            p.setInt(1, ms);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                h.put(r.getString(1), r.getString(2));
            }
            c.close();
            p.close();
            r.close();
        } catch (SQLException e) {
        }
        return h;
    }
    
    public static void insertChiTiet(int mt, int mdl){
        try {
            Connection c = getConnection();
            String q = "INSERT INTO CHITIET(MATOUR, MADDL) VALUES(?, ?)";
            PreparedStatement p = c.prepareStatement(q);
            p.setInt(1, mt);
            p.setInt(2, mdl);
            int r = p.executeUpdate();
            if(r == 1){
                c.commit();
            }
            c.close();
            p.close();
        } catch (SQLException e) {
        }
    }
}
