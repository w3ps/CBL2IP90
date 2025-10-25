package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/** Stores and saves the users data. */
public class Storage {
    private boolean[] completed;
    private String[] times; // Fastest time in which the player completed a level
    private Controller controller;
    private int volume;

    /** Constructor for the Storage class. */
    public Storage(Controller controller) {
        this.controller = controller;
        completed = new boolean[10];
        times = new String[10];

        // run();
    }

    public void run() { // TODO denk ik? Geen idee wat jij hier wil. Werkt trwns niet
        JSONArray data = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("volume", 10);
        data.put(obj);
        System.out.print(obj);
    }

    private static ArrayList<Integer> read() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            Scanner fileIn = new Scanner(new File("other\\data.txt"));
            while (fileIn.hasNext()) {
                list.add(fileIn.nextInt());
            }
            fileIn.close();
        } catch (IOException e) {
            System.out.println("No list exists.");
        }
        return list;
    }

    private static void write(ArrayList<Integer> list) {
        try {
            PrintWriter fileOut = new PrintWriter("other\\data.txt");
            for (Integer i : list) {
                fileOut.println(i);
            }
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Could not write to file.");
        }
    }

    /** Testing purposes only. TODO. */
    private static void print(ArrayList<Integer> list) {
        if (list.size() > 0) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }

    }

    public boolean[] getCompleted() {
        return completed;
    }

    public String[] getTimes() {
        return times;
    }

    public Controller getController() {
        return this.controller;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns the number of the first uncompleted level, or 1 if all are completed.
     */
    public int getNextLevel() {
        for (int i = 0; i < 10; i++) {
            if (!completed[i]) {
                return i;
            }
        }
        return 0;
    }

    /** Updates the completed levels and the times, for the storage. */
    public void updateCompleted(int lvlIndex, String timeString) {
        completed[lvlIndex] = true;
        times[lvlIndex] = timeString;
    }

}
