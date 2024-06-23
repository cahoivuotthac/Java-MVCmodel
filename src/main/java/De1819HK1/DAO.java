package De1819HK1;

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

    public static void insertDoi(String ms, String ten, String nuoc) {
        try {
            Connection conn = getConnection();
            String q = "INSERT INTO DOIBONG(MAD, TENDOI, QUOCGIA) VALUES (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(q);
            p.setString(1, ms);
            p.setString(2, ten);
            p.setString(3, nuoc);

            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
        }
    }

    public static void insertGiaiDau(String ms, String ten, String nbd, String nkt) {
        try {
            Connection conn = getConnection();
            String q = "INSERT INTO GIAIDAU(MAG, TENGIAI, NGAYBATDAU, NGAYKETTHUC) VALUES (?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(q);
            p.setString(1, ms);
            p.setString(2, ten);
            p.setString(3, nbd);
            p.setString(4, nkt);

            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();

        } catch (SQLException e) {
        }
    }

    public static String[] getTenGiai() {
        List<String> l = new ArrayList<>();

        try {
            Connection conn = getConnection();
            String q = "SELECT TENGIAI FROM GIAIDAU";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(q);

            while (r.next()) {
                l.add(r.getString(1));
            }
            conn.close();
            s.close();
            r.close();
        } catch (SQLException e) {
        }
        return l.toArray(String[]::new);
    }

    public static HashMap<String, String> getMaVaTenDoi() {
        HashMap<String, String> l = new HashMap<>();

        try {
            Connection conn = getConnection();
            String q = "SELECT MAD, TENDOI FROM DOIBONG";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(q);
            while (rs.next()) {
                l.put(rs.getString(1), rs.getString(2));
            }
            conn.close();
            rs.close();
            s.close();
        } catch (SQLException e) {
        }
        return l;
    }

    public static String getMaG(String tenG) {
        String maG = "";
        try {
            Connection conn = getConnection();
            String q = "SELECT MAG FROM GIAIDAU WHERE TENGIAI = ?";
            PreparedStatement p = conn.prepareStatement(q);
            p.setString(1, tenG);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                maG = r.getString(1);
            }
            conn.close();
            r.close();
            p.close();
        } catch (SQLException e) {
        }
        return maG;
    }

    public static void insertCT_GD(String MaG, String MaD) {
        try {
            Connection conn = getConnection();
            String q = "INSERT INTO CT_GD(MAG, MAD) VALUES(?, ?)";
            PreparedStatement p = conn.prepareStatement(q);
            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
        }
    }

    public static String[] getTenDN_DK(int type) {
        List<String> l = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            String q = null;

            if (type == 1) {
                q = "SELECT TENDOI FROM DOIBONG DB, TRANDAU TD WHERE TD.MADN = DB.MAD";
            } else if (type == 0) {
                q = "SELECT TENDOI FROM DOIBONG DB, TRANDAU TD WHERE TD.MADK = DB.MAD";
            }

            ResultSet r = s.executeQuery(q);
            while (r.next()) {
                l.add(r.getString(1));
            }
            conn.close();
            s.close();
            r.close();
        } catch (SQLException e) {
        }
        return l.toArray(String[]::new);
    }

    public static void insertTranDau(String ngay, String place, String maG, String mdn, String mdk, String ts) {
        try {
            Connection conn = getConnection();
            String q = "INSERT INTO TRANDAU(NGAYDA, DIADIEM, MAG, MADN, MADK, TISO) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(q);
            p.setString(1, ngay);
            p.setString(2, place);
            p.setString(3, maG);
            p.setString(4, mdn);
            p.setString(5, mdk);
            p.setString(6, ts);

            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
        }
    }

    public static String getId(char type, String tenG, String cn, String dk) {
        String id = null;
        try {
            Connection conn = getConnection();
            PreparedStatement p = null;
            String q = null;
            String param = null;

            if (type == 'g') {
                q = "SELECT MAG FROM GIAIDAU WHERE TENGIAI = ?";
                p = conn.prepareStatement(q);
                param = tenG;

            } else if (type == 'n') {
                q = "SELECT MAD FROM DOIBONG WHERE MADN = ?";
                p = conn.prepareStatement(q);
                param = cn;

            } else if (type == 'k') {
                q = "SELECT MAD FROM DOIBONG WHERE MADK = ?";
                p = conn.prepareStatement(q);
                param = dk;
            }
            
            p.setString(1, param);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                id = r.getString(1);
            }
            conn.close();
            p.close();
            r.close();
        } catch (SQLException e) {
        }
        return id;
    }
}
