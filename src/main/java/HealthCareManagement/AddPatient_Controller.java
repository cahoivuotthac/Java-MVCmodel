package healthCareManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AddPatient_Controller implements ActionListener {

    private AddPatient_View view;
    private Model model;

    public AddPatient_Controller(AddPatient_View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = view.getId().getText();
        String name = view._getName().getText();
        String address = view.getAddress().getText();
        String phoneNum = view.getPhoneNum().getText();
        String gender = view.getGender().getSelectedItem().toString();

        //Date datatype in java is different from Data in sql
        java.sql.Date dateSql = new java.sql.Date(view.getDate().getDate().getTime());
//        java.util.Date date = view.getDate().getDate();
//        java.sql.Date dateSql = new java.sql.Date(date.getTime());

        int checkInsert = 0;

        if (gender.equals("Nam")) {
            checkInsert = DAO.insertNewPatient(id, name, dateSql, address, phoneNum, 0);
        } else {
            checkInsert = DAO.insertNewPatient(id, name, dateSql, address, phoneNum, 1);
        }
        if (checkInsert == 1) {
            JOptionPane.showMessageDialog(view,
                    "Thêm bệnh nhân thành công",
                    "Confirm message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view,
                    "Thêm bệnh nhân không thành công",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
