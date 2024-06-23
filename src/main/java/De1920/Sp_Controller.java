/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1920;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class Sp_Controller implements ActionListener, KeyListener {

    private Model m;
    private Sp_View v;
    private String maNcc;

    public Sp_Controller(Sp_View v) {
        this.v = v;
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            maNcc = v.getMaNcc().getText();
            String tenNcc = DAO.getTenNcc(maNcc);
            v.getTenNcc().setText(tenNcc);
            v.getTenNcc().setVisible(true);
            v.getMaNcc().setEditable(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.getThem()){
            maNcc = v.getMaNcc().getText();
            String tenSp = v.getTenSp().getText();
            String dongia = v.getDongia().getText();
            if (e.getActionCommand().equals("Thêm")) {
                DAO.insertSp(maNcc, tenSp, Integer.parseInt(dongia));
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
