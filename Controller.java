import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Controls the main GUI.
 */
public class Controller {
    private Main main;
    private int tileSize;

    /**
     * Creates and implements the control class.
     */
    public Controller(Main main) {
        this.main = main;
        tileSize = main.getTileSize();
        run();
    }

    public void run() {
        addPanel(new Menu(this));
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

    public void hide() {
        main.setVisible(false);
    }

    public void show() {
        main.setVisible(true);
    }

    public int getTileSize() {
        return tileSize;
    }
}
