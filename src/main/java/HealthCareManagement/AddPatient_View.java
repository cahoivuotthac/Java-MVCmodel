package healthCareManagement;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPatient_View extends JFrame{

    /**
     * @return the addButton
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * @return the address
     */
    public JTextField getAddress() {
        return address;
    }

    /**
     * @return the date
     */
    public JDateChooser getDate() {
        return date;
    }

    /**
     * @return the gender
     */
    public JComboBox getGender() {
        return gender;
    }

    /**
     * @return the id
     */
    public JTextField getId() {
        return id;
    }

    /**
     * @return the name
     */
    public JTextField _getName() {
        return name;
    }

    /**
     * @return the phoneNum
     */
    public JTextField getPhoneNum() {
        return phoneNum;
    }
    private JTextField id;
    private JTextField name;
    private JDateChooser date;
    private JTextField address;
    private JTextField phoneNum;
    private JComboBox<String> gender;
    private JButton addButton;
    
    public AddPatient_View(){
        init();
        addListener();
    }
    
    private void init(){
        id = new JTextField(4);
        name = new JTextField(20);
        date = new JDateChooser();
        
        getDate().setDateFormatString("MMM dd, yyyy"); //March 1, 2004
        
        address = new JTextField(50);
        phoneNum = new JTextField(10);
        String[] genderList = {"Nam", "Nữ"};
        gender = new JComboBox<>(new DefaultComboBoxModel(genderList));
        addButton = new JButton("Thêm");
        
        this.setTitle("Thông tin bệnh nhân");
        this.setSize(400, 400); //width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        JLabel id_LB = new JLabel("Mã bệnh nhân");
        JLabel name_LB = new JLabel("Tên bệnh nhân");
        JLabel date_LB = new JLabel("Ngày sinh");
        JLabel address_LB = new JLabel("Địa chỉ");
        JLabel phoneNum_LB = new JLabel("Điện thoại");
        JLabel gender_LB = new JLabel("Giới tính");
        
        //put components into layout
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(12, 8, 0, 12);
        gbc.ipady = 15;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(id_LB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(name_LB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(date_LB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(address_LB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(phoneNum_LB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(gender_LB, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(id, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(name, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(date, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(address, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(phoneNum, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(gender, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipady = 20;
        gbc.ipadx = 30;
        gbc.insets = new Insets(15, 25, 5, 150);
        panel.add(getAddButton(), gbc);
        
        this.add(panel, BorderLayout.CENTER);
    }
    
    private void addListener(){
        AddPatient_Controller ac = new AddPatient_Controller(this);
        
        id.addActionListener(ac);
        name.addActionListener(ac);
        //date.addActionListener(ac);
        address.addActionListener(ac);
        phoneNum.addActionListener(ac);
        gender.addActionListener(ac);
        addButton.addActionListener(ac);
    }
}
    
