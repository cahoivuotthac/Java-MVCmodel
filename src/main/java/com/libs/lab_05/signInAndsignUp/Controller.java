package com.libs.lab_05.signInAndsignUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    private final View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //get text from JTextField
        String username = view.getUserName_jTF().getText();
        String pass = view.getPass_jTF().getText();

        if (s.equals("Sign in")) {

            if (DAO.signIn(username, pass)) {
                JOptionPane.showMessageDialog(view, "Đăng nhập thành công", "Message", JOptionPane.INFORMATION_MESSAGE); //JOptionPane.OK_OPTION has error icon, it's not suitable
            } else {
                JOptionPane.showMessageDialog(view, "Đăng nhập không thành công. Vui lòng nhập lại", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } else if (s.equals("Sign up")) {

            String confirmPass = view.getConfirmPass_jTF().getText();
            
            if (!pass.equals(confirmPass) || pass.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng nhập lại mật khẩu xác nhận", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if (DAO.signUp(username, pass) == 1) {
                    JOptionPane.showMessageDialog(view, "Bạn đã đăng ký tài khoản thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } 
    }

}
