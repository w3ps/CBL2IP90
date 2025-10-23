import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/** Responsible for storing the levels and its attributes. */
public class Levels {
    private static final int LVL_AMT = 10; // Amount of premade levels
    private static int[] TILE_SIZES;
    private int[][] grid;
    private HashMap<Integer, int[][]> grids = new HashMap<>();
    private static File[] SOURCE_FLS;
    private Scanner source;

    /** Constructor for the Levels class. */
    public Levels() {
        TILE_SIZES = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        SOURCE_FLS = new File[LVL_AMT];

        initialize();
    }

    /** Initializes the variables for Levels. */
    public void initialize() {
        for (int i = 0; i < LVL_AMT; i++) {
            SOURCE_FLS[i] = new File("maze_templates\\level" + i + ".txt");

            try {
                source = new Scanner(SOURCE_FLS[i]);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + SOURCE_FLS[i]);
                e.printStackTrace();
            }

            grid = new int[TILE_SIZES[i]][TILE_SIZES[i]];
            initializeGrid();
            grids.put(i, grid);
        }
    }

    /** Initializes the grid for a specific level. */
    public void initializeGrid() {
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid.length; k++) {
                grid[j][k] = source.nextInt();
            }
        }
    }

    public HashMap<Integer, int[][]> getGrids() {
        return grids;
    }

    public int[] getTileSizes() {
        return TILE_SIZES;
    }
}
