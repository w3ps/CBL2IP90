import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Handles the JPanels related to the game itself, to maintain smooth flow.
 */
public class GamePanel {
    private Maze maze;
    private Player p;
    private int tileSize;
    private JLayeredPane layeredPane;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(int tileSize) {
        this.tileSize = tileSize;
        maze = new Maze(this.tileSize, this.tileSize, "maze_templates\\0maze.txt");
    }

    public JPanel makePanel() {
        // TODO
        return null;
    }
}
