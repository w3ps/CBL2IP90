import javax.swing.*;

/**
 * Main class for the game 'Gravity Shift'.
 * 
 * @author Sven van Tongeren - 2244160
 * @author Juul Versteijnen - 2312298
 */
public class Main {

    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(960, 540);
        f.setResizable(false);
        f.setTitle("Gravity shift");
                
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
