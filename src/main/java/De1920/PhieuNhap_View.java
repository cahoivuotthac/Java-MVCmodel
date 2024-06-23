/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1920;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableCellEditor;

public class PhieuNhap_View extends JFrame {

    JDateChooser ngayNhap;
    JTextField ghiChu;
    JComboBox tenNcc;
    JTable ds;
    JTable dsN;
    JButton tao;
    
    public PhieuNhap_View() {
        init();
    }

    public void init() {
        this.setTitle("Phiếu nhập hàng");
        this.setSize(600, 500); //width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        ngayNhap = new JDateChooser();
        ghiChu = new JTextField();
        tenNcc = new JComboBox();
        tao = new JButton("Tạo phiếu nhập");
        //comboBox: hiện thị ds tenNcc
        List<String> m = DAO.dsTenNcc();
        tenNcc.setModel(new DefaultComboBoxModel(m.toArray(String[]::new)));
        //table
        ds = new JTable(0, 1); //r, c
        dsN = new JTable(0, 2);
        
        JLabel ngayLb = new JLabel("Ngày lập");
        JLabel noteLb = new JLabel("Ghi chú");
        JLabel nccLb = new JLabel("Nhà cung cấp");
        JLabel spLb = new JLabel("Danh sách sản phẩm");
        JLabel spNLb = new JLabel("Danh sách sản phẩm nhập");
        
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
        panel.add(ngayLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(noteLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nccLb, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(spLb, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(ds, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(ngayNhap, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(ghiChu, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(tenNcc, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(spNLb, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(dsN, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipady = 10;
        gbc.ipadx = 20;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel.add(tao, gbc);

        this.add(panel, BorderLayout.CENTER);
        
        this.setVisible(true);
        // cho phép chỉnh sửa cột chắt lượng
        TableCellEditor editor = new DefaultCellEditor(new JTextField());
        dsN.getColumnModel().getColumn(1).setCellEditor(editor);
        
        PhieuNhap_Controller ac = new PhieuNhap_Controller(this);
        tenNcc.addActionListener(ac);
        tao.addActionListener(ac);
        
        
    }
}
