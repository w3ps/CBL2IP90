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
    private JButton[] buttons;
    private JLabel[] infoLabels;

    /** Constructor for the LevelSelection class. */
    public LevelSelection(Storage storage) {
        this.storage = storage;
        completed = this.storage.getCompleted();
        times = this.storage.getTimes();
        controller = this.storage.getController();
        buttons = new JButton[10];
        infoLabels = new JLabel[10];

        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 5, 20, 50));
        gridPanel.setOpaque(false);

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton("Level " + (i + 1));
            button.setFont(new Font("Arial", Font.BOLD, 15));

            final int level = i + 1;
            button.addActionListener(e -> btnPressed(level));

            String status = "Not completed";
            if (completed[i]) {
                status = "Best: " + times[i];
                button.setBackground(Color.GREEN);
            }

            JLabel infoLabel = new JLabel(status, SwingConstants.CENTER);
            infoLabel.setFont(new Font("Arial", Font.ITALIC, 15));
            infoLabel.setForeground(Color.BLACK);

            buttons[i] = button;
            infoLabels[i] = infoLabel;

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

    public void nxtBtnPressed() { // TODO implement
    }

    /** Marks a level as completed for LevelSelection, as well as the storage. */
    public void levelCompleted(int lvlIndex, double time) {

        if (completed[lvlIndex]) { // If level has been completed, update lowest time
            if (time < Double.valueOf(times[lvlIndex])) {
                times[lvlIndex] = String.valueOf(time);
            }
        } else { // Display new time
            completed[lvlIndex] = true;
            times[lvlIndex] = String.valueOf(time);
        }

        updateButtons(lvlIndex);
        storage.updateCompleted(lvlIndex, times[lvlIndex]);
    }

    /** Marks a given level green, and updates the text beneath it. */
    public void updateButtons(int lvlIndex) {
        infoLabels[lvlIndex].setText("Best: " + times[lvlIndex]);
        buttons[lvlIndex].setBackground(Color.GREEN);
    }

}
