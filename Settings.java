import java.awt.*;
import javax.swing.*;

/**
 * Stores the settings and handles the settings panel.
 */
public class Settings extends JPanel {
    private int level;
    private int volume;

    private JSpinner levelSpinner;
    private JSlider volumeSlider;
    private JButton backButton;
    private Controller controller;
    private Menu menu;
    private Storage storage;
    private Music music;

    /**
     * Constructor for the SettingsPanel class.
     */
    public Settings(Controller controller) {
        level = 1;
        volume = 50;
        this.controller = controller;
        music = new Music(this);

        initialize();
    }

    private void initialize() {
        setPreferredSize(new Dimension(640, 640));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        JLabel levelLabel = new JLabel("Level:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(levelLabel, gbc);

        levelSpinner = new JSpinner(new SpinnerNumberModel(level, 1, 10, 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(levelSpinner, gbc);

        JLabel volumeLabel = new JLabel("Volume:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(volumeLabel, gbc);

        volumeSlider = new JSlider(0, 100, volume);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(volumeSlider, gbc);

        backButton = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(backButton, gbc);

        levelSpinner.addChangeListener(e -> setLevel((int) levelSpinner.getValue()));
        volumeSlider.addChangeListener(e -> updateVolume());
        backButton.addActionListener(e -> backButtonPressed());
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Updates the volume for both settings and music.
     */
    public void updateVolume() {
        volume = volumeSlider.getValue();
        music.setVolume(volume);
    }

    /**
     * Removes settings panel and goes back to main menu.
     */
    public void backButtonPressed() {
        controller.removePanel(this);
        controller.addPanel(menu);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVolume() {
        volume = 70;
        return volume;
    }
}
