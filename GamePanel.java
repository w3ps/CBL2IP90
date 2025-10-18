import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Handles the JPanels related to the game itself, to maintain smooth flow.
 */
public class GamePanel extends JLayeredPane {
    private Maze maze;
    private Player p;
    private int size;
    private int tileSize;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(int tileSize) {
        size = tileSize * 128;
        this.tileSize = tileSize;
        
        maze = new Maze(this.tileSize, this.tileSize, "maze_templates\\0maze.txt");
        p = new Player(size);

        initialize();
    }

    /**
     * Initializes the GamePanel by creating the related objects and panels.
     */
    public void initialize() {
        JPanel mazePanel = maze.makePanel();
        mazePanel.setBounds(0, 0, size, size);

        p.setFocusable(true);
        p.setBounds(0, 0, 128, 128);

        add(mazePanel, Integer.valueOf(0));
        add(p, Integer.valueOf(1));
        setPreferredSize(new Dimension(size, size));
    }
}
