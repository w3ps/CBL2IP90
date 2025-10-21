import javax.swing.*;
import java.awt.*;

/**
 * Responsible for the level selection panel.
 */
public class LevelSelection extends JPanel {

    /** Constructor for the LevelSelection class. */
    public LevelSelection() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // === Center panel for level buttons ===
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 5, 20, 150)); // More spacing between buttons
        gridPanel.setOpaque(false);

        for (int i = 1; i <= 10; i++) {
            JButton btn = new JButton("Level " + i);
            btn.setFont(new Font("Arial", Font.BOLD, 15));

            final int btnNumber = i;
            btn.addActionListener(e -> btnPressed(btnNumber));            
            gridPanel.add(btn);
        }

        // === Bottom panel for navigation buttons ===
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 150));
        navPanel.setOpaque(false);

        JButton backButton = new JButton("Back");
        JButton nextButton = new JButton("Next Level");

        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        nextButton.setFont(new Font("Arial", Font.BOLD, 15));

        navPanel.add(backButton);
        navPanel.add(nextButton);

        add(gridPanel, BorderLayout.CENTER);
        add(navPanel, BorderLayout.SOUTH);
    }

    /**
     * Maps the number of the button to that specific level.
     */
    public void btnPressed(int btnNumber) {
        switch (btnNumber) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Level Selection Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(new LevelSelection());
        frame.setVisible(true);
    }
}
