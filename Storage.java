import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private Settings settings;
    int volume;

    public Storage(Settings settings) {
        this.settings = settings;
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = readData();

        data.add(volume);

        writeData(data);
    }

    private static ArrayList<Integer> readData() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new File("data.txt"));
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
            PrintWriter fileOut = new PrintWriter("data.txt");
            for (Integer i : list) {
                fileOut.println(i);
            }
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Could not write to file.");
        }
    }

    public void addVolume() {
        volume = settings.getVolume();
    }

}
