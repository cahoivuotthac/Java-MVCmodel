
package De1819HK1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranDau_Controller implements ActionListener{
    private TranDau_View v;
    public TranDau_Controller(TranDau_View _v){
        v = _v;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        //lưu các dữ liệu vừa thêm trên giao diện xuống CSDL
        if(e.getSource() == v.them){
            String tenG = v.tenG.getSelectedItem().toString();
            String ngay = v.ngay.getText();
            String place = v.place.getText();
            String chuNha = v.chuNha.getSelectedItem().toString();
            String doiKhach = v.doiKhach.getSelectedItem().toString();
            String ts = v.ts.getText();
            
            String maG = DAO.getId('g', tenG, null, null);
            String maDN = DAO.getId('n', tenG, chuNha, null);
            String maDK = DAO.getId('k', tenG, null, doiKhach);
            
            DAO.insertTranDau(ngay, place, maG, maDN, maDK, ts);
        }
        
        //nhán hủy sẽ xóa các thông tin vừa thêm trên giao diện
        if(e.getSource() == v.huy){
            clearFields();
        }
    }
    
    private void clearFields(){
        v.tenG.setSelectedIndex(-1); //không có mục nào được chọn trong combo box
        v.ngay.setText("");
        v.place.setText("");
        v.ts.setText("");
        v.chuNha.setSelectedIndex(-1);
        v.doiKhach.setSelectedIndex(-1);
    }
}
