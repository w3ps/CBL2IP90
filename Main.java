import java.awt.Dimension;
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
        setSize(500, 500);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(getPreferredSize());

        JPanel mazePanel = (new Maze(5, 5, "maze_templates\\0maze.txt")).makePanel();
        mazePanel.setBounds(0, 0, 500, 500);
        layeredPane.add(mazePanel, 0, 0);

        Player playerPanel = new Player();
        playerPanel.setBounds(0, 0, 500, 500);
        // layeredPane.add(playerPanel, 1, 0);

        // ^^ TODO ff debuggen en dan zorgen dat character op een panel komt
        // die even groot is als de character zelf, zodat ie makkelijk verplaats kan worden

        add(layeredPane);
        setVisible(true);
    }

    public Dimension getFrameSize() {
        return super.getSize();
    }

    public static void main(String[] args) {
        new Main();
    }
}
