import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Handles the JPanels related to the game itself, to maintain smooth flow.
 */
public class GamePanel extends JLayeredPane {
    private int size; // TODO FINAL, 640
    private int tileSize = 10; // TODO REMOVE
    private double time; // Measures the time it takes to complete level
    private Maze maze;
    private Menu menu;
    private JPanel mazePanel;
    private Player p;
    private Controller controller;
    private LevelSelection ls;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(int tileSize, Controller controller) {
        this.controller = controller;
        this.menu = controller.getMenu();
        this.ls = menu.getLevelSelection();
        size = tileSize * 64; // TODO REMOVE

        maze = new Maze(this.tileSize, "maze_templates\\level1.txt"); // TODO FIX
        maze.setGamePanel(this);
        mazePanel = maze.makePanel();

        p = new Player(size, tileSize); // TODO FIX
        p.setMaze(maze);

        initialize();
    }

    /**
     * Initializes the GamePanel by creating the related objects and panels.
     */
    public void initialize() {
        mazePanel.setBounds(0, 0, size, size);

        p.setFocusable(true);
        p.setBounds(0, 0, 64, 64);

        add(mazePanel, Integer.valueOf(0));
        add(p, Integer.valueOf(1));
        setPreferredSize(new Dimension(size, size));

        time = System.currentTimeMillis();
    }

    /**
     * Logic for GamePanel, whenever the goal is reached.
     */
    public void goalEvent() {
        time = System.currentTimeMillis() - time;
        ls.levelCompleted(0, time / 1000); // TODO parameter level

        remove(p);
        remove(mazePanel);

        Goal goal = new Goal(size);
        goal.setBounds(0, 0, size, size);
        goal.setGamePanel(this);
        goal.setController(controller);
        add(goal);
    }
}
