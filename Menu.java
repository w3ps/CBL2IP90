import java.awt.*;
import javax.swing.*;

/**
 * Class for the main menu of the game.
 */
public class Menu extends JPanel {
    private int tileSize;
    private JButton startBtn;
    private JButton optionsBtn;
    private JButton exitBtn;
    private Controller controller;
    private static final Dimension BTN_SIZE = new Dimension(180, 60);

    /**
     * Constructor for the menu class.
     */
    public Menu(Controller controller) {
        setPreferredSize(new Dimension(640, 640));

        this.controller = controller;
        tileSize = controller.getTileSize();
        startBtn = new JButton("Start Game");
        optionsBtn = new JButton("Options");
        exitBtn = new JButton("Exit");

        initialize();
    }

    /**
     * Initializes the Menu panel.
     */
    public void initialize() {
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
                30, 100, 30, 100));

        startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        startBtn.setMaximumSize(BTN_SIZE);
        startBtn.addActionListener(e -> startBtnPressed());

        optionsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsBtn.setMaximumSize(BTN_SIZE);
        optionsBtn.addActionListener(e -> optionsBtnPressed());

        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(BTN_SIZE);
        exitBtn.addActionListener(e -> exitBtnPressed());

        add(Box.createRigidArea(new Dimension(0, 30)));
        add(startBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(optionsBtn);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(exitBtn);
    }

    /**
     * Launches the game and hides the main menu.
     */
    public void startBtnPressed() { // TODO
        controller.addLPane(new GamePanel(tileSize));
        setVisible(false);
    }

    /**
     * Opens the options menu and hides the main menu.
     */
    public void optionsBtnPressed() { // TODO
        setVisible(false);
    }

    public void exitBtnPressed() {
        System.exit(0);
    }
}
