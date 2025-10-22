import java.awt.*;
import javax.swing.*;

/**
 * Implementation for the event in which the goal is reached.
 */
public class Goal extends JPanel {
    private JPanel textPanel;
    private JLabel goalLabel; // Congratulations text
    private JPanel btnPanel; // Panel for buttons
    private JButton mmBtn; // Main Menu button
    private JButton nxtBtn; // Next Level button
    private GamePanel gp;
    private Controller controller;

    /**
     * Constructor for the Goal class.
     */
    public Goal(int size) {
        setPreferredSize(new Dimension(size, size));

        textPanel = new JPanel();
        goalLabel = new JLabel("You won, good job!");
        btnPanel = new JPanel(new GridLayout(1, 2));
        mmBtn = new JButton("Main Menu");
        nxtBtn = new JButton("Next Level");

        initialize();
    }

    /**
     * Initializes the Goal menu.
     */
    public void initialize() {
        textPanel.add(goalLabel);
        mmBtn.addActionListener(e -> mmButtonPressed());
        nxtBtn.addActionListener(e -> nxtButtonPressed());

        btnPanel.add(mmBtn, BorderLayout.WEST);
        btnPanel.add(nxtBtn, BorderLayout.EAST);

        add(textPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Shows main menu and hides the gamepanel.
     */
    public void mmButtonPressed() {
        controller.addPanel(controller.getMenu());;
        controller.removeLPane(gp);;
    }

    public void nxtButtonPressed() {
        // TODO
    }
}
