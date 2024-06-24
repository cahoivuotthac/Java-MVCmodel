package De2223_Tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiemDL_Ctl implements ActionListener{
    private final DiemDL_View v;
    public DiemDL_Ctl(DiemDL_View _v){
        v = _v;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == v.them){
            String ten = v.cbb.getSelectedItem().toString();
            String tendl = v.ten.getText();
            String dtr = v.dtr.getText();
            
            DAO.insertDiemDL(ten, tendl, dtr);
        }
    }
}
