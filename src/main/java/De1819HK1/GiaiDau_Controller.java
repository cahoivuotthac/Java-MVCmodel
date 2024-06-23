/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1819HK1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class GiaiDau_Controller implements ActionListener{
    private GiaiDau_View v;
    
    public GiaiDau_Controller(GiaiDau_View _v){
        v = _v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String ms = v.ms.getText();
        String ten = v.ten.getText();
        String nbd = v.nbd.getText();
        String nkt = v.nkt.getText();
        
        if(e.getSource() == v.them){
            DAO.insertGiaiDau(ms, ten, nbd, nkt);
        }
    }
    
}
