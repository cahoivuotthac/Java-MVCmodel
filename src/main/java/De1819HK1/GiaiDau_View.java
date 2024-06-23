/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1819HK1;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class GiaiDau_View {
    JTextField ms;
    JTextField ten;
    JTextField nbd;
    JTextField nkt;
    JButton them;
    public GiaiDau_View(){
        init();
    }
    public void init(){
        ms = new JTextField();
        ten = new JTextField();
        nbd = new JTextField();
        nkt = new JTextField();
        them = new JButton("Thêm");
        
        GiaiDau_Controller ac = new GiaiDau_Controller(this);
        ms.addActionListener(ac);
        ten.addActionListener(ac);
        nbd.addActionListener(ac);
        nkt.addActionListener(ac);
        them.addActionListener(ac);
        
    }
}
