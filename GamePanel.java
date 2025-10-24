import java.awt.Dimension;
import javax.swing.JLayeredPane;

/**
 * Handles the JPanels related to the game itself, to maintain smooth flow.
 */
public class GamePanel extends JLayeredPane {
    private int size;
    private int tileSize;
    private int lvlIndex;
    private double time; // Time it takes to complete the level
    private Maze maze;
    private Player p;
    private Controller controller;
    private LevelSelection ls;
    private Levels lvls;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel(Controller controller, Menu menu) {
        this.controller = controller;
        this.ls = menu.getLevelSelection();
        lvls = controller.getLevels();
    }

    /** Starts the the maze corresponding to the given level. */
    public void play(int lvlIndex) {
        this.lvlIndex = lvlIndex;
        tileSize = lvls.getTileSizes()[this.lvlIndex];
        size = tileSize * 64;

        maze = new Maze(this.lvlIndex, lvls, this);
        maze.setBounds(0, 0, size, size);

        p = new Player(size, tileSize);
        p.setMaze(maze);
        p.setFocusable(true);
        p.setBounds(0, 0, 64, 64);

        add(maze, Integer.valueOf(0));
        add(p, Integer.valueOf(1));
        setPreferredSize(new Dimension(size, size));

        time = System.currentTimeMillis();
    }

    /**
     * Logic for GamePanel, whenever the goal is reached.
     */
    public void goalEvent() {
        time = System.currentTimeMillis() - time;
        ls.levelCompleted(lvlIndex, time / 1000d);

        remove(p);
        remove(maze);

        Goal goal = new Goal(this, controller);
        goal.setBounds(0, 0, size, size);
        add(goal);
    }

    /** Returns the current player instance. */
    public Player getPlayer() {
        return p;
    }

    public int getLevelIndex() {
        return this.lvlIndex;
    }
}
