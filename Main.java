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
        setSize(960, 540);
        setLocationRelativeTo(null);

        add(new Player());
        add((new Maze(4, 4, "maze_templates\\0maze.txt")).makePanel());
        // TODO Make panels overlap.

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
