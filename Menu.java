import java.awt.*;
import javax.swing.*;

/**
 * Responsible for the main menu.
 */
public class Menu extends JPanel {
    private JButton startBtn;
    private JButton lvlBtn;
    private JButton settingsBtn;
    private JButton exitBtn;
    private Controller controller;
    private Settings settings;
    private Storage storage;
    private LevelSelection ls;
    private GamePanel gp;
    private static final Dimension BTN_SIZE = new Dimension(180, 60);

    /**
     * Constructor for the menu class.
     */
    public Menu(Controller controller) {
        setPreferredSize(new Dimension(640, 640));

        this.controller = controller;
        storage = controller.getStorage();
        settings = controller.getSettings();
        settings.setMenu(this);
        ls = new LevelSelection(storage);
        gp = new GamePanel(controller, this);

        startBtn = new JButton("Start Game");
        lvlBtn = new JButton("Level Selection");
        settingsBtn = new JButton("Settings");
        exitBtn = new JButton("Exit");

        initialize();
    }

    /**
     * Initializes the Menu panel.
     */
    public void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
                30, 100, 30, 100));

        startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        startBtn.setMaximumSize(BTN_SIZE);
        startBtn.addActionListener(e -> startBtnPressed());

        lvlBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        lvlBtn.setMaximumSize(BTN_SIZE);
        lvlBtn.addActionListener(e -> lvlBtnPressed());

        settingsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsBtn.setMaximumSize(BTN_SIZE);
        settingsBtn.addActionListener(e -> sttngsBtnPressed());

        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(BTN_SIZE);
        exitBtn.addActionListener(e -> exitBtnPressed());

        add(Box.createRigidArea(new Dimension(0, 30)));
        add(startBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(lvlBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(settingsBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(exitBtn);
    }

    /** Starts the next level and hides the menu panel. */
    public void startBtnPressed() {
        playLevel(storage.getNextLevel());
        controller.removePanel(this);
    }

    /** Starts the level. */
    public void playLevel(int lvlIndex) {
        gp.play(lvlIndex);
        controller.addLPane(gp);
    }

    /**
     * Opens the settings menu and hides the main menu.
     */
    public void sttngsBtnPressed() {
        controller.removePanel(this);
        controller.addPanel(settings);
    }

    /** Displays the level selection and hides the menu. */
    public void lvlBtnPressed() {
        controller.removePanel(this);
        controller.addPanel(ls);
    }

    /** Closes the application TODO: and saves the users data. */
    public void exitBtnPressed() {
        // new Storage(); TODO
        System.exit(0);
    }

    public LevelSelection getLevelSelection() {
        return ls;
    }

    public GamePanel getGamePanel() {
        return gp;
    }

}
