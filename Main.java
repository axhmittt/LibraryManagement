import javax.swing.SwingUtilities;
import ui.LibraryApp;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryApp());
    }
}