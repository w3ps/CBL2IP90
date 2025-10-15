import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Class for the movement and logic of the playable in-game character.
 * 
 * TODO
 */
public class Player extends JPanel implements ActionListener, KeyListener {
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

        setOpaque(false);

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer(7, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite = (new ImageIcon(this.getClass().getResource("Sprite.png"))).getImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x, y, getWidth() / 4, getHeight() / 4, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent l) {
        int key = l.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            if (x > 0) {
                x -= 960 / 4;
            }
        } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            if (x < getWidth() - sprite.getWidth(this)) {
                x += 960 / 4;
            }
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            if (y > 0) {
                y -= 560 / 4;
            }
        } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            if (y < getHeight() - sprite.getHeight(this)) {
                y += 560 / 4;
            }
        }
        repaint();

    }
}
