package De1920;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PhieuNhap_Controller implements ActionListener {

    private Model m = new Model();
    private final PhieuNhap_View v;

    public PhieuNhap_Controller(PhieuNhap_View v) {
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == v.tenNcc) {
            
            String nccCbb = v.tenNcc.getSelectedItem().toString(); //Object converts to String
            
            //hiển thị ds sản phẩm của NCC chọn từ comboBox vào table ds sp
            List<String> l = DAO.dsSp(nccCbb);
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Sản phẩm"}, 0);
            for (String i : l) {
                model.addRow(new Object[]{i});
            }
            v.ds.setModel(model);

            //nhấn chọn sản phẩm trong table ds sp để thêm vào table danh sách nhập
            DefaultTableModel modelChon = new DefaultTableModel(new Object[]{"Sản phẩm", "Số lượng"}, 0);
            v.ds.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        int selectedRow = v.ds.getSelectedRow();
                        if (selectedRow >= 0) {
                            String selectedProduct = v.ds.getValueAt(selectedRow, 0).toString(); //0: the first col

                            // Hiển thị dialog để nhập số lượng
                            String inputValue = JOptionPane.showInputDialog("Nhập số lượng:");
                            if (inputValue != null && !inputValue.isEmpty()) {
                                int sl = Integer.parseInt(inputValue);
                                modelChon.addRow(new Object[]{selectedProduct, sl});
                            }
                        }
                    }
                }
            });
            v.dsN.setModel(modelChon);
        }

        //nhấn button tạo để insert chi tiết pn và phiếu nhập
        if (e.getSource() == v.tao) {
            java.sql.Date dateSql = new java.sql.Date(v.ngayNhap.getDate().getTime());
            String ghiChu = v.ghiChu.getText();
            DAO.insertPhieuNhap(dateSql, ghiChu);
            int maPn = DAO.getMaPn(dateSql, ghiChu);
            System.out.println(maPn);

            for (int i = 0; i < v.dsN.getRowCount(); i++) {

                String tenSp = v.dsN.getValueAt(i, 0).toString();
                int sl = Integer.parseInt(v.dsN.getValueAt(i, 1).toString());
                int donGia = DAO.chitietNhap(maPn, tenSp, sl);
                m.tinhTongTien(sl, donGia);
            }
            DAO.updatePhieuNhap(m.getTongTien(), maPn);
        }
    }
}
