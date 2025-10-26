package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import org.json.JSONObject;

/** Stores and saves the users data. */
public class Storage {
    private boolean[] completionList;
    private String[] times; // Fastest time in which the player completed a level
    private Controller controller;

    /** Constructor for the Storage class. */
    public Storage(Controller controller) {
        this.controller = controller;
        completionList = new boolean[10];
        times = new String[10];
    }

    /** Updates "data.json" to contain the right values. */
    public void update(JSONObject obj, String levelKey) { 
        try {
            Scanner scanner = new Scanner(new File("src\\main\\resources\\other\\data.json"));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject data = new JSONObject(sb.toString());
            Iterator<String> newKeys = obj.keys();
            while (newKeys.hasNext()) {
                String key = newKeys.next();
                if (!(levelKey.equals(""))) {
                    JSONObject level = data.getJSONObject(levelKey);
                    level.put(key, obj.get(key));
                    data.put(levelKey, level);
                } else {
                    data.put(key, obj.get(key));
                }         
            }
            try (FileWriter writer = new FileWriter("src\\main\\resources\\other\\data.json");) {
                writer.write(data.toString(4));
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /** Reads "data.json" and gives variables the stored values. */
    public JSONObject read(String key, String key2) {
        try {
            Scanner scanner = new Scanner(new File("src\\main\\resources\\other\\data.json"));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close(); 

            JSONObject data = new JSONObject(sb.toString());
            JSONObject obj = new JSONObject();
            if (data.has(key)) {
                if (key.equals("volume")) {
                    obj.put(key, data.getInt(key));
                    return obj;
                } else {
                    JSONObject level = data.getJSONObject(key);
                    if (level.has(key2) && key2.equals("completed")) {
                        obj.put(key2, level.getBoolean(key2));
                        return obj;
                    } else if (level.has(key2) && key2.equals("time")) {
                        obj.put(key2, level.getString(key2));
                        return obj;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;   
    }

    /** Gives "volume" the right value. */
    public void setVolume(int volume) {
        JSONObject obj = new JSONObject();
        obj.put("volume", volume);
        update(obj, "");
    }

    /** Gives "completed" of completed level the right value. */
    public void setLevelCompletion(int level, boolean completed) {
        JSONObject obj = new JSONObject();
        obj.put("completed", completed);
        update(obj, "level" + level);
    }

    /** Gives "time" of a certain level the right value. */
    public void setLevelTime(int level, String time) {
        JSONObject obj = new JSONObject();
        obj.put("time", time);
        update(obj, "level" + level);
    }

    /** Returns the value of volume. */
    public int getVolume() {
        JSONObject data = read("volume", "");
        int volume = data.getInt("volume");
        return volume;
    }

    /** Returns a list with the boolean value (of completion) of every level. */
    public boolean[] getCompleted() {
        for (int i = 1; i <= 10; i++) {
            JSONObject data = read("level" + i, "completed");
            boolean completed = data.getBoolean("completed");
            completionList[i - 1] = completed;
        }
        return completionList;
    }

    /** Returns a list with the best played times of every level. */
    public String[] getTimes() {
        for (int i = 1; i <= 10; i++) {
            JSONObject data = read("level" + i, "time");
            String time = data.getString("time");
            times[i - 1] = time;
        }
        return times;
    }

    public Controller getController() {
        return this.controller;
    }

    /**
     * Returns the number of the first uncompleted level, or 1 if all are completed.
     */
    public int getNextLevel() {
        completionList = getCompleted();
        for (int i = 0; i < 10; i++) {
            if (!completionList[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Storage(new Controller(new Main()));
    }
}
