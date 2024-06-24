
package De2223_Tour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CTTour_View extends JFrame{
    JTextField ms;
    JTextField ngay;
    JTextField ten;
    JTextField gia;
    JTextField sn;
    JTextField sd;
    JComboBox cbb;
    JTable t1;
    JTable t2;
    JButton them;
    
    public CTTour_View(){
        ms = new JTextField("T001");
        ngay = new JTextField("13/6/2023");
        ten = new JTextField("Thắng cảnh");
        gia = new JTextField("2000000");
        sn = new JTextField("4");
        sd = new JTextField("3");
        
        cbb = new JComboBox(new DefaultComboBoxModel(DAO.getTenTinhTP()));
        t1 = new JTable(0, 2);
        t2 = new JTable(0, 1);
        them = new JButton("Thêm");
        
        CTTour_Ctl l = new CTTour_Ctl(this);
        ms.addActionListener(l);
        ngay.addActionListener(l);
        ten.addActionListener(l);
        gia.addActionListener(l);
        sn.addActionListener(l);
        sd.addActionListener(l);
        cbb.addActionListener(l);
        them.addActionListener(l);
    }
}
