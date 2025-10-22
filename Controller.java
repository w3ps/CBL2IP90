import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Controls the main GUI.
 */
public class Controller {
    private int tileSize;
    private Main main;
    private Menu menu;
    private Music music;
    private Settings settings;
    private Storage storage;

    /**
     * Creates and implements the control class.
     */
    public Controller(Main main) {
        this.main = main;
        tileSize = main.getTileSize();
        storage = new Storage(this);
        music = new Music(storage.getVolume());
        settings = new Settings(this);
        menu = new Menu(this);
        addPanel(menu);
    }

    /**
     * Adds a panel to the main frame and updates it.
     */
    public void addPanel(JPanel p) {
        main.add(p);
        main.update();
    }

    /**
     * Adds a layered pane to the main frame and updates it.
     */
    public void addLPane(JLayeredPane p) {
        main.add(p);
        main.update();
    }

    /**
     * Removes a panel from the main frame and updates it.
     */
    public void removePanel(JPanel p) {
        main.remove(p);
        main.update();
    }

    /**
     * Removes a layered pane from the main frame and updates it.
     */
    public void removeLPane(JLayeredPane p) {
        main.remove(p);
        main.update();
    }

    public int getTileSize() {
        return tileSize;
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

    public Storage getStorage() {
        return storage;
    }
}
