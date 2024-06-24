package De2223_Tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CTTour_Ctl implements ActionListener, KeyListener {

    private final CTTour_View v;
    int ms;

    public CTTour_Ctl(CTTour_View _v) {
        v = _v;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ms = Integer.parseInt(v.ms.getText());
            String[] l = DAO.getThongTinTour(ms);
            v.ten.setText(l[0]);
            v.ngay.setText(l[1]);
            v.sn.setText(l[2]);
            v.sd.setText(l[3]);
            v.gia.setText(l[4]);

            v.ten.setEditable(false);
            v.ngay.setEditable(false);
            v.gia.setEditable(false);
            v.sn.setEditable(false);
            v.sd.setEditable(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.them) {
            String tp = v.cbb.getSelectedItem().toString();

            DefaultTableModel m1 = new DefaultTableModel(new String[]{"Tên điểm du lịch", "Đặc trưng"}, 0);
            HashMap<String, String> h = DAO.getTable1(DAO.getMa('t', tp));
            for (Map.Entry<String, String> et : h.entrySet()) {
                m1.addRow(new Object[]{et.getKey(), et.getValue()});
            }
            v.t1.setModel(m1);
            
            DefaultTableModel m2 = new DefaultTableModel(new String[]{"Tên điểm du lịch"}, 0);
            v.t1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) {
                        int sltR = v.t1.getSelectedRow();
                        
                        String ten = v.t1.getValueAt(sltR, 0).toString();
                        m2.addRow(new Object[]{ten});
                        DAO.insertChiTiet(ms, DAO.getMa('d', ten));
                    }
                }
            });
            v.t2.setModel(m2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

}
