import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 * Class for the structure and logic of the maze itself.
 */
public class Maze {

    private int xSize;
    private int ySize;
    private Scanner source;
    private File file;
    private int[][] tiles; // Multidemensional array to display maze
    private TileIcons tileIcons;
    private JPanel mazePanel;
    private GamePanel gp;

    /**
     * Constructor for the maze class.
     */
    public Maze(int xSize, int ySize, String file) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.file = new File(file);

        try {
            source = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + this.file);
            e.printStackTrace();
        }

        tiles = initialize();
        tileIcons = new TileIcons(tiles);
    }

    /**
     * Initializes grid from input by file.
     */
    private int[][] initialize() {
        int[][] grid = new int[xSize][ySize];
        while (source.hasNextInt()) {
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {
                    grid[i][j] = source.nextInt();
                }
            }
        }
        return grid;
    }

    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Turns 'tiles' into a panel with a corresponding gridlayout.
     */
    public JPanel makePanel() {
        mazePanel = new JPanel(new GridLayout(xSize, ySize));
        mazePanel.setBackground(Color.BLACK);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                mazePanel.add(tileIcons.getTileIcon(i, j));
            }
        }
        return mazePanel;
    }

    /**
     * Checks if the given coordinates collide with a tile.
     */
    public boolean checkCollision(int x, int y) {
        int tileX = x / 128;
        int tileY = y / 128;
        int val;
        try {
            val = tiles[tileY][tileX];
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            val = 1;
        }
        if (val == 0) {
            return false;
        } else if (val == 7) { // TODO: 7 = Number of goal tile. Evt change in future.
            gp.goalEvent();
            return true;
        }
        return true;
    }
}