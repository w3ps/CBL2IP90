package com.example;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Controls the main GUI.
 */
public class Controller {
    private Main main;
    private Menu menu;
    private Music music;
    private Settings settings;
    private Storage storage;
    private Levels lvls;

    /**
     * Creates and implements the control class.
     */
    public Controller(Main main) {
        lvls = new Levels();
        this.main = main;
        storage = new Storage(this);
        music = new Music(0); //TODO: goed verbinden.
        settings = new Settings(this);
        menu = new Menu(this);
        addPanel(menu);
    }

    /**
     * Adds a panel to the main frame and updates it.
     */
    public void addPanel(JPanel p) {
        main.add(p);
        update();
    }

    /**
     * Adds a layered pane to the main frame and updates it.
     */
    public void addLPane(JLayeredPane p) {
        main.add(p);
        update();
    }

    /**
     * Removes a panel from the main frame and updates it.
     */
    public void removePanel(JPanel p) {
        main.remove(p);
        update();
    }

    /**
     * Removes a layered pane from the main frame and updates it.
     */
    public void removeLPane(JLayeredPane p) {
        main.remove(p);
        update();
    }

    /**
     * Updates the frame. Restores the frame to its original size if eiter of its
     * dimensions is 0.
     */
    public void update() {
        main.pack();

        if (main.getWidth() == 136 || main.getHeight() == 39) { 
            main.setSize(640, 640);
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Music getMusic() {
        return music;
    }

    public Levels getLevels() {
        return lvls;
    }
    
    public Storage getStorage() {
        return storage;
    }
}
