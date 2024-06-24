/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De2223_Tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class Tour_Ctl implements ActionListener{
    private Tour_View v;
    public Tour_Ctl(Tour_View _v){
        v = _v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == v.them){
            String ten = v.ten.getText();
            String ngay = v.ngay.getText();
            String sn = v.sn.getText();
            String sd = v.sd.getText();
            String gia = v.gia.getText();
            
            DAO.insertTour(ten, ngay, sn, sd, gia);
        }
    }
}
