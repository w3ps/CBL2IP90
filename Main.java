import javax.swing.*;

/**
 * Main class for the game 'Gravity Shift'.
 * 
 * @author Sven van Tongeren - 2244160
 * @author Juul Versteijnen - 2312298
 */
public class Main extends JFrame {

    /**
     * Constructor for the main class (mainly the JFrame).
     */
    public Main() {
        setTitle("Gravity Shift");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 560);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(960, 560);

        // Maze panel
        JPanel mazePanel = (new Maze(4, 4, "maze_templates\\0maze.txt")).makePanel(); // TO DO Adjust size as needed
        mazePanel.setBounds(0, 0, 960, 560);
        layeredPane.add(mazePanel, Integer.valueOf(0));

        // Player panel
        Player playerPanel = new Player();
        playerPanel.setBounds(0, 0, 960, 560);  
        layeredPane.add(playerPanel, Integer.valueOf(1));

        add(layeredPane);

        // TODO Make panels overlap.

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
