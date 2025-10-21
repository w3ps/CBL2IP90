import java.awt.*;
import javax.swing.*;

/**
 * Stores the settings and handles the settings panel.
 */
public class Settings extends JPanel {
    private int volume;
    private JSlider volumeSlider;
    private JButton bckBtn;
    private Controller controller;
    private Menu menu;
    private Storage storage;
    private Music music;

    /**
     * Constructor for the Settings class.
     */
    public Settings(Controller controller, Storage storage) {
        this.controller = controller;
    
        initializeUI();
    }

    private void initializeUI() {
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

        bckBtn = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(bckBtn, gbc);

        volumeSlider.addChangeListener(e -> updateVolume());
        bckBtn.addActionListener(e -> bckBtnPressed());
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
    
    /** Updates the volume for both settings and music. */
    public void updateVolume() {
        volume = volumeSlider.getValue();
        music.setVolume(volume);
    }

    /**
     * Removes settings panel and goes back to main menu.
     */
    public void bckBtnPressed() {
        controller.removePanel(this);
        controller.addPanel(menu);
    }

    public Controller getController() {
        return controller;
    }
}
