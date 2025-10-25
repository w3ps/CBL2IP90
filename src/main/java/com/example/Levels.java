package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/** Responsible for storing the levels and its attributes. */
public class Levels {
    private static final int LVL_AMT = 10; // Amount of playable levels
    private static int[] TILE_SIZES;
    private int[][] grid;
    private HashMap<Integer, int[][]> grids = new HashMap<>();
    private static File[] SOURCE_FLS;
    private Scanner sc;

    /** Constructor for the Levels class. */
    public Levels() {
        TILE_SIZES = new int[] { 7, 10, 10, 10, 9, 10, 10, 10, 10, 10, 0 };
        SOURCE_FLS = new File[LVL_AMT + 1];

        for (int i = 0; i < LVL_AMT; i++) {
            SOURCE_FLS[i] = new File("src\\main\\resources\\maze_templates\\level" + i + ".txt");
            initialize(i);
        }
    }

    /** Initializes the variables for Levels. */
    public void initialize(int i) {

        try {
            sc = new Scanner(SOURCE_FLS[i]);
        } catch (FileNotFoundException e) { // Only used for custom levels
            JOptionPane.showMessageDialog(null, "File not found: " + SOURCE_FLS[i]
                    + "\nCheck custom_level.txt in directory maze_templates for instructions.",
                    e.toString(), JOptionPane.ERROR_MESSAGE);
        }

        grid = new int[TILE_SIZES[i]][TILE_SIZES[i]];
        initializeGrid();
        grids.put(i, grid);
    }

    /** Initializes the grid for a specific level. */
    public void initializeGrid() {
        try {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid.length; k++) {
                    grid[j][k] = sc.nextInt();
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NoSuchElementException e) {
            // Only used for custom levels
            JOptionPane.showMessageDialog(null, "Given size and size of file do not match"
                    + "\nCheck custom_level.txt in directory maze_templates for instructions.",
                    e.toString(), JOptionPane.ERROR_MESSAGE);
        }

    }

    /** Adds the custom level to the array of levels. */
    public void addCustomLvl(int tileSize, String location) {
        TILE_SIZES[10] = tileSize;
        SOURCE_FLS[10] = new File(location);
        initialize(10);
    }

    public HashMap<Integer, int[][]> getGrids() {
        return grids;
    }

    public int[] getTileSizes() {
        return TILE_SIZES;
    }
}
