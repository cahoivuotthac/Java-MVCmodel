package De2223_Tour;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DiemDL_View extends JFrame{
    JComboBox cbb;
    JTextField ten;
    JTextField dtr;
    JButton them;
    
    public DiemDL_View(){
        ten = new JTextField("Kinh thành Huế");
        dtr = new JTextField("Di tích");
        cbb = new JComboBox(new DefaultComboBoxModel(DAO.getTenTinhTP()));
        them = new JButton("Thêm");
        
        DiemDL_Ctl l = new DiemDL_Ctl(this);
        ten.addActionListener(l);
        dtr.addActionListener(l);
        cbb.addActionListener(l);
        them.addActionListener(l);
    }
}
