import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Class for the movement and logic of the playable in-game character.
 */
public class Player extends JPanel implements KeyListener, Movement {
    private int size;
    private Image sprite;

    /**
     * Constructor for the player class.
     */
    Player(int SIZE) {
        this.size = SIZE;
        addKeyListener(this);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite = (new ImageIcon(this.getClass().getResource("Sprite.png"))).getImage();
        // sprite = sprite.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, 0, 0, this);
        // g2d.drawImage(sprite, x, y, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                moveL();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                moveR();
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                moveU();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                moveD();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void moveR() {
        
        
        setLocation(getX() + size / 5, getY());
        repaint();
        // System.out.println(this.getX() + ", " + getY());
    }

    @Override
    public void moveL() {
        setLocation(getX() - size / 5, getY());
        repaint();
    }

    @Override
    public void moveU() {
        setLocation(getX(), getY() - size / 5);
        repaint();
    }

    @Override
    public void moveD() {
        setLocation(getX(), getY() + size / 5);
        repaint();
    }
}