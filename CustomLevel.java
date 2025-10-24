import java.awt.*;
import javax.swing.*;

/** The panel for allowing the user to construct a custom level. */
public class CustomLevel extends JPanel {
    private int tileSize = 10;
    private String location = "maze_templates/level0.txt";
    private Levels lvls;
    private Controller controller;
    private Menu menu;

    /** Constructor for the CustomLevel class. */
    public CustomLevel(Controller controller, Levels lvls) {
        this.controller = controller;
        this.lvls = lvls;
        this.menu = controller.getMenu();

        setPreferredSize(new Dimension(640, 640));
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel sizeLabel = new JLabel("Size of axis, in tiles:");
        sizeLabel.setFont(new Font("Arial", Font.BOLD, 15));

        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 16, 1));
        sizeSpinner.setPreferredSize(new Dimension(300, 20));
        sizeSpinner.setFont(new Font("Arial", Font.PLAIN, 15));
        sizeSpinner.addChangeListener(e -> tileSize = (int) sizeSpinner.getValue());

        centerPanel.add(sizeLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(sizeSpinner, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel locationLabel = new JLabel("File location:");
        locationLabel.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(locationLabel, gbc);

        gbc.gridx = 1;
        JTextField locationField = new JTextField("maze_templates/level0.txt");
        locationField.setPreferredSize(new Dimension(300, 20));
        locationField.setFont(new Font("Arial", Font.PLAIN, 15));
        locationField.addActionListener(e -> location = locationField.getText());
        centerPanel.add(locationField, gbc);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.addActionListener(e -> bckBtnPressed());
        bottomPanel.add(backButton);

        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.BOLD, 15));
        createButton.addActionListener(e -> createBtnPressed());
        bottomPanel.add(createButton);

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /** Displays the custom level, loaded from the users input. */
    public void createBtnPressed() { // TODO: fix custom level marking as complete.
        lvls.addCustomLvl(tileSize, location);
        controller.removePanel(this);
        menu.playLevel(10);
        SwingUtilities.invokeLater(() -> menu.getGamePanel().getPlayer().requestFocusInWindow());
    }
    
    public void bckBtnPressed() { // TODO
        
    }
}
