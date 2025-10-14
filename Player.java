import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Class for the movement and logic of the playable in-game character.
 * 
 * TODO
 */
public class Player extends JPanel implements ActionListener {
    private int x;
    private int y;
    private double vel; // Velocity
    private Timer timer;

    private Image sprite;

    /**
     * Constructor for the player class.
     */
    Player() {
        this.x = 0;
        this.y = 0;
        this.vel = 0;

        timer = new Timer(7, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite = (new ImageIcon(this.getClass().getResource("Sprite.png"))).getImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
