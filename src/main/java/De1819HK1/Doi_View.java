/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1819HK1;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class Doi_View {
    JTextField ms;
    JTextField ten;
    JTextField nuoc;
    JButton them;
    public Doi_View(){
        init();
    }
    public void init(){
        ms = new JTextField();
        ten = new JTextField();
        nuoc = new JTextField();
        them = new JButton("Thêm");
        
        Doi_Controller ac = new Doi_Controller(this);
        ms.addActionListener(ac);
        ten.addActionListener(ac);
        nuoc.addActionListener(ac);
        them.addActionListener(ac);
        
    }
}
