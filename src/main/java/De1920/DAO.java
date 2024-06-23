package De1920;

import static healthCareManagement.ConnectionJDBC.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static void insertNhaCungCap(String ncc, String dc, String sdt, String email) {
        try {
            Connection conn = getConnection();
            String query = "INSERT INTO NHACC(TENNCC, DIACHI, DTHOAI, EMAIL) VALUES (?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, ncc);
            p.setString(2, dc);
            p.setString(3, sdt);
            p.setString(4, email);

            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getTenNcc(String maNcc) {
        String tenNcc = "";
        try {
            Connection conn = getConnection();
            String query = "SELECT TENNCC FROM NHACC WHERE MANCC = ?";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, maNcc);
            ResultSet rset = p.executeQuery();

            while (rset.next()) {
                tenNcc = rset.getString(1);
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNcc;
    }

    public static void insertSp(String maNcc, String tenSp, double donGia) { //2 cases
        int c = 0;
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String checkSp = "SELECT COUNT(*) FROM SANPHAM WHERE TENSP = ?";
            PreparedStatement p = conn.prepareStatement(checkSp);
            p.setString(1, tenSp);
            ResultSet rset = p.executeQuery();
            while (rset.next()) {
                c = rset.getInt(1);
            }
            conn.setAutoCommit(false);
            PreparedStatement p1 = null;
            if (c == 0) {
                //Trường hợp nhập mới sp, SOLUONG = 0
                String query2 = "INSERT INTO SANPHAM(TENSP, SOLUONG, DONGIA, MANCC) VALUES(?, 0, ?, ?)";
                p1 = conn.prepareStatement(query2);
                p1.setString(1, tenSp);
                p1.setDouble(2, donGia);
                p1.setString(3, maNcc);
            }
//            else {
//                sl++;
//                //Trường hợp ko nhập mới
//                String query1 = "UPDATE SANPHAM SET SOLUONG = ? WHERE TENSP = ?";
//                p1 = conn.prepareStatement(query1);
//                p1.setInt(1, sl);
//                p1.setString(2, tenSp);
//            }

            int r = p1.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
            p1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String[] dsTenNcc() {
        List<String> l = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT TENNCC FROM NHACC";
            Statement s = conn.createStatement();
            ResultSet rset = s.executeQuery(query);
            while (rset.next()) {
                l.add(rset.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l.toArray(String[]::new);
    }

    public static List<String> dsSp(String tenNcc) {
        List<String> l = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT MANCC FROM NHACC WHERE TENNCC = ?";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, tenNcc);
            ResultSet rset = p.executeQuery();
            String maNcc = null;
            while (rset.next()) {
                maNcc = rset.getString(1);
            }
            String query1 = "SELECT TENSP FROM SANPHAM WHERE MANCC = ?";
            PreparedStatement p1 = conn.prepareStatement(query1);
            p1.setString(1, maNcc);
            ResultSet rset1 = p1.executeQuery();
            while (rset1.next()) {
                l.add(rset1.getString(1));
            }

            conn.close();
            p.close();
            p1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public static int chitietNhap(int maPn, String tenSp, int sl) {
        int dongia = 0;
        int maSp = 0;

        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String q1 = "SELECT MASP, DONGIA FROM SANPHAM WHERE TENSP = ?";
            PreparedStatement p1 = conn.prepareStatement(q1);
            p1.setString(1, tenSp);
            ResultSet rset = p1.executeQuery();
            while (rset.next()) {
                maSp = rset.getInt(1);
                dongia = rset.getInt(2);
            }

            String q = "INSERT INTO CT_NHAP(MAPN, MASP, SL) VALUES (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(q);
            p.setInt(1, maPn);
            p.setInt(2, maSp);
            p.setInt(3, sl);
            int r = p.executeUpdate();

            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
            p1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dongia;
    }

    public static void insertPhieuNhap(Date ngay, String ghichu) {
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String q = "INSERT INTO PHIEUNHAP(NGAYLAP, GHICHU, TONGTIEN) VALUES (?, ?, 0)";
            PreparedStatement p = conn.prepareStatement(q);
            p.setDate(1, ngay);
            p.setString(2, ghichu);
            int r = p.executeUpdate();
            if (r == 1) {
                conn.commit();
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updatePhieuNhap(int tongTien, int maPn) {
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String q = "UPDATE PHIEUNHAP SET TONGTIEN = ? WHERE MAPN = ?";
            PreparedStatement p = conn.prepareStatement(q);
            p.setInt(1, tongTien);
            p.setInt(2, maPn);
            int r = p.executeUpdate();
            if (r > 0) {
                conn.commit();
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int getMaPn(Date ngay, String ghichu) {
        int maPn = 0;
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String q = "SELECT MAPN FROM PHIEUNHAP WHERE NGAYLAP = ? AND GHICHU = ?";
            PreparedStatement p = conn.prepareStatement(q);
            p.setDate(1, ngay);
            p.setString(2, ghichu);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                maPn = rs.getInt(1);
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maPn;
    }
}