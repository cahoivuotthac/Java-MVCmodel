package De1819HK1;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TranDau_View {
    JComboBox tenG;
    JTextField ngay;
    JTextField place;
    JComboBox chuNha;
    JComboBox doiKhach;
    JTextField ts;
    JButton them, huy;
    
    public TranDau_View(){
        init();
    }
    public void init(){
        tenG = new JComboBox(new DefaultComboBoxModel(DAO.getTenGiai()));
        ngay = new JTextField("09/12/2018");
        place = new JTextField("Địa điểm");
        
        chuNha = new JComboBox<>(new String[]{"Chelsea"});
        chuNha.setModel(new DefaultComboBoxModel(DAO.getTenDN_DK(1)));
        
        doiKhach = new JComboBox<>(new String[]{"Liverpool"});
        doiKhach.setModel(new DefaultComboBoxModel(DAO.getTenDN_DK(0)));
        ts = new JTextField("2:0");
        them = new JButton("Thêm");
        huy = new JButton("Hủy");
        
        TranDau_Controller ac = new TranDau_Controller(this);
        tenG.addActionListener(ac);
        ngay.addActionListener(ac);
        place.addActionListener(ac);
        chuNha.addActionListener(ac);
        doiKhach.addActionListener(ac);
        ts.addActionListener(ac);
        them.addActionListener(ac);
        huy.addActionListener(ac);
    }
}
