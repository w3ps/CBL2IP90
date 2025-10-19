import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Handles the JPanels related to the game itself, to maintain smooth flow.
 */
public class GamePanel extends JLayeredPane {
    private Maze maze;
    private JPanel mazePanel;
    private Player p;
    private int size;
    private int tileSize;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(int tileSize) {
        this.tileSize = tileSize;
        size = tileSize * 128;

        maze = new Maze(this.tileSize, this.tileSize, "maze_templates\\0maze.txt");
        maze.setGamePanel(this);
        mazePanel = maze.makePanel();

        p = new Player(size, tileSize);
        p.setMaze(maze);

        initialize();
    }

    /**
     * Initializes the GamePanel by creating the related objects and panels.
     */
    public void initialize() {
        mazePanel.setBounds(0, 0, size, size);

        p.setFocusable(true);
        p.setBounds(0, 0, 128, 128);

        add(mazePanel, Integer.valueOf(0));
        add(p, Integer.valueOf(1));
        setPreferredSize(new Dimension(size, size));
    }

    /**
     * Logic for GamePanel, whenever the goal is reached.
     */
    public void goalEvent() {
        remove(p);
        remove(mazePanel);

        Goal goalPanel = new Goal(size);
        goalPanel.setBounds(0, 0, size, size);
        add(goalPanel);
    }
}
