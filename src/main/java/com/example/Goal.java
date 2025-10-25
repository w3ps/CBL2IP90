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
    private Menu menu;

    /**
     * Constructor for the Goal class.
     */
    public Goal(GamePanel gp, Controller controller) {
        setPreferredSize(new Dimension(640, 640));

        this.gp = gp;
        this.controller = controller;
        this.menu = controller.getMenu();

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

    /** Shows main menu, removes the gamepanel and the goal menu. */
    public void mmButtonPressed() {
        gp.remove(this);
        controller.removeLPane(gp);
        controller.addPanel(menu);
    }

    /** Starts the next level and removes the goal panel. */
    public void nxtButtonPressed() {
        gp.remove(this);
        controller.removeLPane(gp);
        menu.startBtnPressed();
        SwingUtilities.invokeLater(() -> gp.getPlayer().requestFocusInWindow());
    }
}
