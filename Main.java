import javax.swing.*;

/**
 * Main class for the game 'Gravity Shift'.
 * 
 * @author Sven van Tongeren - 2244160
 * @author Juul Versteijnen - 2312298
 */
public class Main extends JFrame {
    private static final int TILE_SIZE = 10; // Size of the maze, expressed in tiles.
    private static final int SIZE = TILE_SIZE * 128; // Size, expressed in pixels.

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

    public int getTileSize() {
        return TILE_SIZE;
    }

    /**
     * Updates the frame. Restores the frame to its original size if eiter of its
     * dimensions is 0.
     */
    public void update() {
        pack();

        if (getWidth() == 136 || getHeight() == 39) { // Returns to original size if frame is folded
            setSize(SIZE, SIZE);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Main m = new Main();
            m.setVisible(true);
        });
    }
}
