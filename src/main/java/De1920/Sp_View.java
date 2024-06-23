/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1920;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class Sp_View extends JFrame{

    /**
     * @return the dongia
     */
    public JTextField getDongia() {
        return dongia;
    }

    /**
     * @return the maNcc
     */
    public JTextField getMaNcc() {
        return maNcc;
    }

    /**
     * @return the tenNcc
     */
    public JLabel getTenNcc() {
        return tenNcc;
    }

    /**
     * @return the tenSp
     */
    public JTextField getTenSp() {
        return tenSp;
    }

    /**
     * @return the them
     */
    public JButton getThem() {
        return them;
    }
    
    private JTextField maNcc;
    private JTextField tenSp;
    private JTextField dongia;
    private JLabel tenNcc;
    private JButton them;
    private Model m;
    
    public Sp_View(){
        init();
    }
    
    private void init(){
        this.setTitle("Thông tin sản phẩm");
        this.setSize(400, 400); //width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        JLabel maNccLb = new JLabel("Mã nhà cung cấp");
        JLabel tenNccLb = new JLabel("Tên nhà cung cấp");
        JLabel tenSpLb = new JLabel("Tên sản phẩm");
        JLabel donGiaLb = new JLabel("Đơn giá");
        
        maNcc = new JTextField();
        //maNcc.setEditable(false);
        tenSp = new JTextField();
        dongia = new JTextField();
        tenNcc = new JLabel();
        getTenNcc().setVisible(false);
        them = new JButton("Thêm");
        
        //put components into layout
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 3, 0, 5);
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(maNccLb, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(tenNccLb, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(tenSpLb, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(donGiaLb, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(getMaNcc(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(getTenNcc(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(getTenSp(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(getDongia(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipady = 10;
        gbc.ipadx = 20;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel.add(getThem(), gbc);
        
        this.add(panel, BorderLayout.CENTER);
        
        Sp_Controller ac = new Sp_Controller(this);
        getThem().addActionListener(ac);
        getMaNcc().addActionListener(ac);
        getMaNcc().addKeyListener(ac);
        getTenSp().addActionListener(ac);
        getDongia().addActionListener(ac);
    }
    
}
