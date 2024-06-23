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

public class Ncc_View extends JFrame {

    public JTextField getDc() {
        return dc;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getNcc() {
        return ncc;
    }

    public JTextField getSdt() {
        return sdt;
    }

    public JButton getThem() {
        return them;
    }
    private JTextField ncc;
    private JTextField dc;
    private JTextField sdt;
    private JTextField email;
    private JButton them;

    public Ncc_View() {
        init();
    }

    private void init() {

        this.setTitle("Thông tin Nhà cung cấp");
        this.setSize(400, 400); //width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel tenLb = new JLabel("Tên nhà cung cấp");
        JLabel dcLb = new JLabel("Địa chỉ");
        JLabel dtLb = new JLabel("Điện thoại");
        JLabel emailLb = new JLabel("Email");

        ncc = new JTextField();
        dc = new JTextField();
        sdt = new JTextField();
        email = new JTextField();
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
        panel.add(tenLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(dcLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(dtLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(emailLb, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(ncc, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(dc, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(sdt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(email, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipady = 10;
        gbc.ipadx = 20;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel.add(them, gbc);

        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
        Ncc_Controller ac = new Ncc_Controller(this);

        getThem().addActionListener(ac);
        getNcc().addActionListener(ac);
        getDc().addActionListener(ac);
        getSdt().addActionListener(ac);
        getEmail().addActionListener(ac);
    }
}
