
package De2223_Tour;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tour_View extends JFrame{
    JTextField ten;
    JTextField ngay;
    JTextField sn;
    JTextField sd;
    JTextField gia;
    JButton them;
    
    public Tour_View(){
        ten = new JTextField("Thắng cảnh");
        ngay = new JTextField("Ngày khởi hành");
        sn = new JTextField("4");
        sd = new JTextField("3");
        gia = new JTextField("2000000");
        them = new JButton("Thêm");
        
        Tour_Ctl l = new Tour_Ctl(this);
        ten.addActionListener(l);
        ngay.addActionListener(l);
        sn.addActionListener(l);
        sd.addActionListener(l);
        gia.addActionListener(l);
        them.addActionListener(l);
    }
}
