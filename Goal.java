import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Implementation for the event in which the goal is reached.
 */
public class Goal extends JPanel {
    private JPanel textPanel;
    private JLabel goalLabel; // Congratulations text
    private JPanel btnPanel; // Panel for buttons
    private JButton mmButton; // Main Menu button
    private JButton nxtButton; // Next Level button

    /**
     * Constructor for the Goal class.
     */
    public Goal(int size) {
        setPreferredSize(new Dimension(size, size));

        textPanel = new JPanel();
        goalLabel = new JLabel("You won, good job!");
        textPanel.add(goalLabel);

        btnPanel = new JPanel(new GridLayout(1, 2));
        mmButton = new JButton();
        mmButton.setText("Main Menu");
        nxtButton = new JButton();
        nxtButton.setText("Next Level");

        btnPanel.add(mmButton, BorderLayout.WEST);
        btnPanel.add(nxtButton, BorderLayout.EAST);

        add(textPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
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
