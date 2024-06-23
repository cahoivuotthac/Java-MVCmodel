/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1920;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class Model {

    public int getTongTien() {
        return tongTien;
    }

    public int tinhTongTien(int sl, int donGia){
        return tongTien += sl * donGia;
    }

    private int tongTien = 0;

    public Model() {
    }

}
