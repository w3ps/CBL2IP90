import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 * Class for the structure and logic of the maze.
 *
 * TODO
 */
public class Maze {

    private int xSize;
    private int ySize;
    private Scanner source;
    private File file;
    private int[][] tiles; // Multidemensional array to display maze, 0 -> air, 1 -> wall, etc. TODO
    private TileIcons tileIcons;
    private int bSize;

    private JPanel mazePanel;

    private Player player;

    /**
     * Constructor for the maze class.
     */
    Maze(int xSize, int ySize, String file) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.file = new File(file);
        bSize = 20;

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
     * 
     * @return Multidemsional array corresponding to the grid
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

    /**
     * Constructs and returns string representation of the grid (without spaces).
     * For testing purposes.
     */
    public String printMaze() {
        String mazeString = "";
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                mazeString += tiles[i][j];
            }
            mazeString += "\n";
        }
        return mazeString;
    }

    /**
     * Turns 'tiles' into a panel with a corresponding gridlayout.
     */
    public JPanel makePanel() {
        JPanel icon;
        mazePanel = new JPanel(new GridLayout(xSize, ySize));
        mazePanel.setBackground(Color.BLACK);
        mazePanel.setBorder(BorderFactory.createEmptyBorder(bSize, bSize, bSize,
                bSize));
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                icon = tileIcons.getTileIcon(i, j);

                if (icon == null) {
                }
                mazePanel.add(tileIcons.getTileIcon(i, j));
            }
        }
        return mazePanel;
    }

    public static void main(String[] args) {
        Maze m1 = new Maze(4, 4, "0maze.txt");
        JPanel p = m1.makePanel();

        JFrame f = new JFrame();
        f.setTitle("Maze Test");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.add(p);

        f.setVisible(true);
    }
}