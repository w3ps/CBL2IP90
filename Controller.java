import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Controls the main GUI.
 */
public class Controller {
    private int tileSize;
    private Main main;
    private Menu menu;
    private Settings settings;

    /**
     * Creates and implements the control class.
     */
    public Controller(Main main) {
        this.main = main;
        tileSize = main.getTileSize();
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

    /**
     * Hides the given panel p from the frame.
     */
    public void hidePanel(JPanel p) {
        p.setVisible(false);
        main.update();
    }

    /**
     * Shows the main menu and updates the frame.
     */
    public void showMenu() {
        menu.setVisible(true);
        main.update();
    }

    public int getTileSize() {
        return tileSize;
    }

    public Settings getSettings() {
        return settings;
    }
}
