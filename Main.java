import javax.swing.*;

/**
 * Main class for the game 'Gravity Shift'.
 * 
 * @author Sven van Tongeren - 2244160
 * @author Juul Versteijnen - 2312298
 */
public class Main extends JFrame {
    private static final int SIZE = 640; // Size, expressed in pixels.

    /**
     * Constructor for the main class (mainly the JFrame).
     */
    public Main() {
        setTitle("Gravity Shift");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SIZE, SIZE);
        setLocationRelativeTo(null);
        new Controller(this);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Main m = new Main();
            m.setVisible(true);
        });
    }
}
