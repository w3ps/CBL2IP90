import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private Settings settings;
    private int volume;

    public Storage(Settings settings) {
        this
        run();
    }

    public void run() {
        ArrayList<Integer> data = readData();
        print(data);

        data.remove(0);
        data.add(updateVolume());

        writeData(data);
    }


    private static ArrayList<Integer> readData() {
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

    private static void writeData(ArrayList<Integer> list) {
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

    private static void print(ArrayList<Integer> list) {
        if (list.size() > 0) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
        
    }

    public int updateVolume() {
        volume = settings.getVolume();
        return volume;
    }

    public static void main(String[] args) {
        new Storage();
    }

}
    
