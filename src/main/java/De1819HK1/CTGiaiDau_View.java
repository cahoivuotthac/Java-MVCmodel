/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1819HK1;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class CTGiaiDau_View {
    JComboBox cbb;
    JTable t1;
    JTable t2;
    JButton them;
    JButton huy;
    
    public CTGiaiDau_View(){
        init();
    }
    
    public void init(){
        cbb = new JComboBox();
        cbb.setModel(new DefaultComboBoxModel(DAO.getTenGiai()));
        
        t1 = new JTable(0, 2); //r, c
        t2 = new JTable(0, 2);
        them = new JButton("Thêm");
        huy = new JButton("Hủy");
        
        CTGiaiDau_Controller ac = new CTGiaiDau_Controller(this);
        cbb.addActionListener(ac);
        them.addActionListener(ac);
        huy.addActionListener(ac);
    }
}
