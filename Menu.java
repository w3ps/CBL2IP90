import java.awt.*;
import javax.swing.*;

/**
 * Class for the main menu of the game.
 */
public class Menu extends JPanel {
    private int tileSize;
    private JButton startBtn;
    private JButton settingsBtn;
    private JButton exitBtn;
    private Controller controller;
    private Settings settings;
    private static final Dimension BTN_SIZE = new Dimension(180, 60);

    /**
     * Constructor for the menu class.
     */
    public Menu(Controller controller) {
        setPreferredSize(new Dimension(640, 640));

        this.controller = controller;
        tileSize = controller.getTileSize();
        settings = controller.getSettings();
        settings.setMenu(this);

        startBtn = new JButton("Start Game");
        settingsBtn = new JButton("Options");
        exitBtn = new JButton("Exit");

        initialize();
    }

    /**
     * Initializes the Menu panel.
     */
    public void initialize() {
        // setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
                30, 100, 30, 100));

        startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        startBtn.setMaximumSize(BTN_SIZE);
        startBtn.addActionListener(e -> startBtnPressed());

        settingsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsBtn.setMaximumSize(BTN_SIZE);
        settingsBtn.addActionListener(e -> optionsBtnPressed());

        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(BTN_SIZE);
        exitBtn.addActionListener(e -> exitBtnPressed());

        add(Box.createRigidArea(new Dimension(0, 30)));
        add(startBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(settingsBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(exitBtn);
    }

    /**
     * Launches the game and hides the main menu.
     */
    public void startBtnPressed() { // TODO
        GamePanel gp = new GamePanel(tileSize);
        gp.setController(controller);
        controller.addLPane(gp);
        controller.hidePanel(this);
    }

    /**
     * Opens the options menu and hides the main menu.
     */
    public void optionsBtnPressed() { // TODO
        controller.removePanel(this);
        controller.addPanel(settings);
    }

    public void exitBtnPressed() {
        System.exit(0);
    }
}
