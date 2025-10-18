import javax.swing.*;

/**
 * Main class for the game 'Gravity Shift'.
 * 
 * @author Sven van Tongeren - 2244160
 * @author Juul Versteijnen - 2312298
 */
public class Main extends JFrame {
    private static final int TILE_SIZE = 5;
    private static final int SIZE = TILE_SIZE * 128;

    /**
     * Constructor for the main class (mainly the JFrame).
     */
    public Main() {
        setTitle("Gravity Shift");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SIZE, SIZE);
        setLocationRelativeTo(null);

        JLayeredPane gp = new GamePanel(TILE_SIZE);
        add(gp);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
