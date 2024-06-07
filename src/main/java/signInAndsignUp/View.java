package signInAndsignUp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class View extends JFrame {

    public JPasswordField getConfirmPass_jTF() {
        return confirmPass_jTF;
    }

    public JTextField getPass_jTF() {
        return pass_jTF;
    }

    public JTextField getUserName_jTF() {
        return userName_jTF;
    }

    private JButton signIn;
    private JButton signUp;
    private JButton cancel;
    private JTextField userName_jTF;
    private JPasswordField pass_jTF;
    private JPasswordField confirmPass_jTF;

    public View() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Sign in & Sign up form");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null); //frame displays in the center of screen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        signIn = new JButton("Sign in");
        signUp = new JButton("Sign up");
        cancel = new JButton("Cancel");
        userName_jTF = new JTextField(10);
        pass_jTF = new JPasswordField(20);
        confirmPass_jTF = new JPasswordField(20);
        JPanel panel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        JLabel userName_jLB = new JLabel("Username");
        JLabel pass_jLB = new JLabel("Password");
        JLabel confirm_jLB = new JLabel("Confirm");
        
        panel.setPreferredSize(new Dimension(400, 200)); //need to set the size for the panel
        buttonsPanel.setPreferredSize(new Dimension(400, 100)); //need to set the size for the panel
        //GridBagLayout
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; //resized within its grid cell when there is additional space available (when drag to resize frame or sth)
        gbc.insets = new Insets(15, 8, 5, 8);
        gbc.weightx = 1; //allow to resize all components using the constraint when the frame size changes. If weightx = 0, all components have constant size
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userName_jLB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(pass_jLB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(confirm_jLB, gbc);
        
        gbc.gridwidth = 2; //takes 2 rows
        gbc.ipadx = 25; // Increase internal padding (width)
        gbc.ipady = 10; // Increase internal padding (height)
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(getUserName_jTF(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(getPass_jTF(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(getConfirmPass_jTF(), gbc);
        
        gbc.gridwidth = 1; // Reset gridwidth for buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(signIn, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(signUp, gbc);
        
        gbc.insets = new Insets(15, 20, 5, 8);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(cancel, gbc);
        
        this.add(panel);
        this.setVisible(true);
        

        //add action listener for button
        Controller ac = new Controller(this);
        signIn.addActionListener(ac);
        signUp.addActionListener(ac);
        cancel.addActionListener(ac);
        
    }
}

