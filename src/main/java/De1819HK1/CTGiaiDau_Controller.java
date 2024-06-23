package De1819HK1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CTGiaiDau_Controller implements ActionListener {

    private CTGiaiDau_View v;

    public CTGiaiDau_Controller(CTGiaiDau_View _v) {
        v = _v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == v.them) {
            String tenG = v.cbb.getSelectedItem().toString();
            HashMap<String, String> l = DAO.getMaVaTenDoi();

            DefaultTableModel m1 = new DefaultTableModel(new String[]{"Mã đội", "Tên đội"}, 0);
            //loop through hashmap
            for (Map.Entry<String, String> ety : l.entrySet()) {
                String ms = ety.getKey();
                String ten = ety.getValue();
                m1.addRow(new Object[]{ms, ten}); //ms col1, ten col2
            }
            v.t1.setModel(m1);

            DefaultTableModel m2 = new DefaultTableModel(new String[]{"Mã đội", "Tên đội"}, 0);
            //nhấn chọn row ở t1 để thêm row đó vào t2
            v.t1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) { //đảm bảo đã thực hiện thay đổi xong
                        int sltRow = v.t1.getSelectedRow();
                        if (sltRow > 0) {
                            String sltMs = v.t1.getValueAt(sltRow, 0).toString(); //r, c
                            String sltTen = v.t1.getValueAt(sltRow, 1).toString();
                            m2.addRow(new Object[]{sltMs, sltTen});
                        }
                    }
                }
            });
            v.t2.setModel(m2);

            //sau khi chọn đủ đội, nhấn nút thêm để thêm đội vào giải đấu
            for (int i = 0; i < v.t2.getRowCount(); i++) {
                String maD = v.t2.getValueAt(i, 0).toString();
                String maG = DAO.getMaG(tenG);
                DAO.insertCT_GD(maG, maD);
            }
        }

        //nhấn nút hủy, xóa toàn bộ dl trong tb t2
        if (e.getSource() == v.huy) {
            DefaultTableModel newM = (DefaultTableModel) v.t2.getModel();
            newM.setRowCount(0);
            v.t2.setModel(newM);
        }
    }
}
