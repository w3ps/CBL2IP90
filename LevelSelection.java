import java.awt.*;
import javax.swing.*;

/**
 * Responsible for the level selection panel.
 */
public class LevelSelection extends JPanel {
    private Storage storage;
    private Controller controller;
    private boolean[] completed;
    private String[] times;

    /** Constructor for the LevelSelection class. */
    public LevelSelection(Storage storage) {
        this.storage = storage;
        completed = this.storage.getCompleted();
        times = this.storage.getTimes();
        controller = this.storage.getController();

        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 5, 20, 50));
        gridPanel.setOpaque(false);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Level " + i);
            button.setFont(new Font("Arial", Font.BOLD, 15));

            final int level = i;
            button.addActionListener(e -> btnPressed(level));

            String status = "Not completed";
            if (completed[i - 1]) {
                status = "Best: " + times[i - 1];
                button.setBackground(Color.GREEN);
            }

            JLabel infoLabel = new JLabel(status, SwingConstants.CENTER);
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setFont(new Font("Arial", Font.ITALIC, 15));
            infoLabel.setForeground(Color.BLACK);

            JPanel levelPanel = new JPanel();
            levelPanel.setLayout(new BorderLayout());
            levelPanel.setOpaque(false);
            levelPanel.add(button, BorderLayout.CENTER);
            levelPanel.add(infoLabel, BorderLayout.SOUTH);

            gridPanel.add(levelPanel);
        }

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 150));
        navPanel.setOpaque(false);

        JButton bckBtn = new JButton("Back");
        JButton nxtBtn = new JButton("Next Level");

        bckBtn.setFont(new Font("Arial", Font.BOLD, 15));
        nxtBtn.setFont(new Font("Arial", Font.BOLD, 15));

        bckBtn.addActionListener(e -> bckBtnPressed());
        nxtBtn.addActionListener(e -> nxtBtnPressed());

        navPanel.add(bckBtn);
        navPanel.add(nxtBtn);

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

    /** Hides level selection panel and displays menu. */
    public void bckBtnPressed() {
        controller.removePanel(this);
        controller.addPanel(controller.getMenu());
    }

    public void nxtBtnPressed() { // TODO
    }
}
