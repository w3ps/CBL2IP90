import java.awt.Dimension;
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

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(SIZE, SIZE));

        JPanel mazePanel = (new Maze(TILE_SIZE, TILE_SIZE,
            "maze_templates\\0maze.txt")).makePanel();
        mazePanel.setBounds(0, 0, SIZE, SIZE);
        layeredPane.add(mazePanel, Integer.valueOf(0));

        Player playerPanel = new Player(SIZE);
        playerPanel.setFocusable(true);
        playerPanel.setBounds(0, 0, 128, 128);
        layeredPane.add(playerPanel, Integer.valueOf(1));

        add(layeredPane);
        pack();
        setVisible(true);
        playerPanel.requestFocusInWindow();
    }

    public Dimension getFrameSize() {
        return super.getSize();
    }

    public static void main(String[] args) {
        new Main();
    }
}
