import De1920.Ncc_View;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String args[]) {
        // Ensure GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            Ncc_View phieuNhap_View = new Ncc_View();
        });
    }
}
