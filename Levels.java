import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/** Responsible for storing all the levels attributes. */
public class Levels {
    private static final int LVL_AMT = 10; // Amount of premade levels
    private int lvlIndex;
    private int tileSize;
    private static int[] TILE_SIZES;
    private int[][] grid;
    private HashMap<Integer, int[][]> grids = new HashMap<>();
    private static File[] SOURCE_FLS;
    private Scanner source;

    private Maze maze;

    /** Constructor for the Levels class. */
    public Levels() {
        TILE_SIZES = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        SOURCE_FLS = new File[LVL_AMT];
    }

    public void initialize() {
        for (int i = 0; i < LVL_AMT; i++) {
            tileSize = TILE_SIZES[i];
            SOURCE_FLS[i] = new File("maze_templates\\level" + i + ".txt");

            try {
                source = new Scanner(SOURCE_FLS[i]);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + SOURCE_FLS[i]);
                e.printStackTrace();
            }

            grid = initializeGrid();
        }
    }

    /**  */
    public int[][] initializeGrid() {
        grid = new int[tileSize][TILE_SIZES[i]];
        while (source.hasNextInt()) {
            for (int j = 0; j < TILE_SIZES[j]; j++) {
                for (int k = 0; k < TILE_SIZES[k]; k++) {
                    grid[j][k] = source.nextInt();
                }
            }
        }
    }
}
