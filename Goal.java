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

    public void mmButtonPressed() {
        new Menu();
    }

    public void nxtButtonPressed() {
        // TODO
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("GoalDemo");
        f.setSize(640, 640);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new Goal(640));
        f.pack();
        f.setVisible(true);
    }
}
