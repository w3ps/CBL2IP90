import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;
import org.json.JSONArray;

/** Stores and saves the users data. */
public class Storage {
    private boolean[] completed;
    private String[] times; // Fastest time in which the player completed a level
    private int volume;
    private Controller controller;

    /** Constructor for the Storage class. */
    public Storage(Controller controller) {
        this.controller = controller;
        completed = new boolean[10];
        volume = 0;
        times = new String[10];

        run();
    }

    public void run() { // TODO denk ik? Geen idee wat jij hier wil. Werkt trwns niet
        ArrayList<Data> array = new ArrayList<Data>();
        array.add(new Data(0, 0, 0));

        JSONArray jsonArray

        
        
        
        //ArrayList<Integer> data = read();
        //print(data);
        // data.remove(0);
        //data.add(setVolume(volume));
        //write(data);
    }

    private static ArrayList<Integer> read() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            Scanner fileIn = new Scanner(new File("other\\data.json"));
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
            PrintWriter fileOut = new PrintWriter("other\\data.json");
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

    public int getVolume() {
        return volume;
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

    public static void main(String[] args) {
        // Quick test runner: constructs Storage with a null Controller (safe)
        // The constructor calls run() which will read and print data from
        // other\data.json
        System.out.println("Running Storage test (no Controller provided)");
        new Storage(null);
    }
}
