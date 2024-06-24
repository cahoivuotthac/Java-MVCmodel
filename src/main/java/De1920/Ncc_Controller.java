/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De1920;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ncc_Controller implements ActionListener {

    private final Ncc_View v;

    public Ncc_Controller(Ncc_View v) {
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.them) {
            String ncc = v.ncc.getText();
            String dc = v.dc.getText();
            String sdt = v.sdt.getText();
            String email = v.email.getText();
            
            DAO.insertNhaCungCap(ncc, dc, sdt, email);
        }
    }

}
