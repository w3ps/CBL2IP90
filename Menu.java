import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class for the main menu of the game.
 */
public class Menu extends JFrame {
    JPanel menuPanel;

    JButton startButton;
    JButton optionsButton;
    JButton exitButton;

    Dimension buttonSize = new Dimension(180, 60);

    /**
     * Constructor for the menu class.
     */
    public Menu() {
        setTitle("Gravity Shift - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100)); // top, left, bottom, right

        startButton = new JButton("Start Game");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(buttonSize);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        optionsButton = new JButton("Options");
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.setMaximumSize(buttonSize);

        exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setMaximumSize(buttonSize);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitGame();
            }
        });

        menuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        menuPanel.add(startButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        menuPanel.add(optionsButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        menuPanel.add(exitButton);

        add(menuPanel);

        setVisible(true);
    }

    private void startGame() {
        // Logic to start the game
        new Main();
    }

    private void openOptions() {
        // Logic to open options menu
    }

    private void exitGame() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Menu();

    }

}
