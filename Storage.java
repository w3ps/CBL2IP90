import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** Stores and saves the users data. */
public class Storage {
    private Settings settings;
    private boolean[] completed;
    private String[] times; // Fastest time in which the player completed a level
    private int volume;

    /** Constructor for the Storage class. */
    public Storage() {
        completed = new boolean[10];
        times = new String[10];
        volume = 100;
                
        run();
    }

    public void run() { // TODO denk ik? Geen idee wat jij hier wil
        ArrayList<Integer> data = read();
        print(data);
        data.remove(0);
        write(data);
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

    public int getVolume() {
        return volume;
    }

    public void levelCompleted(int level) {
        completed[level - 1] = true; 
    }

}
    
