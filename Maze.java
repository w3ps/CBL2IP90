import java.awt.*;
import javax.swing.*;

/**
 * Class for the structure and logic of the maze itself.
 */
public class Maze extends JPanel {

    private int tileSize;
    private int[][] grid; // Multidemensional array to display maze
    private TileIcons tileIcons;
    private GamePanel gp;
    private Levels lvls;

    /**
     * Constructor for the maze class.
     */
    public Maze(int lvlIndex, Levels lvls, GamePanel gp) {
        this.lvls = lvls;
        this.gp = gp;
        tileSize = this.lvls.getTileSizes()[lvlIndex];
        grid = this.lvls.getGrids().get(lvlIndex);
        tileIcons = new TileIcons();

        setLayout(new GridLayout(tileSize, tileSize));
        initializeUI();
    }

    /** Initializes the panel and grid for the maze. */
    public void initializeUI() {
        setBackground(Color.BLACK);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                add(tileIcons.getTileIcon(grid[i][j]));
            }
        }
    }

    /**
     * Checks if the given coordinates collide with a tile.
     */
    public boolean checkCollision(int x, int y, Player p) {
        int c = x / 64;
        int r = y / 64;
        int val;

        try {
            val = grid[r][c];
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            val = 1;
        }

        if (val == 0) {
            return false;
        } else if (val == 2) {
            gp.goalEvent();
            return true;
        } else if (val == 3) {
            p.restart();
        }
        return true;
    }
}