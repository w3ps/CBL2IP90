import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Class for the movement and logic of the playable in-game character.
 * 
 * TODO
 */
public class Player extends JPanel implements KeyListener {
    private int x;
    private int y;
    private Image sprite;

    private Maze maze; 

    /**
     * Constructor for the player class.
     */
    Player() {
        this.x = 0;
        this.y = 0;

        this.maze = new Maze(5, 5, "maze_templates\\0maze.txt");

        setOpaque(false);

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite = (new ImageIcon(this.getClass().getResource("Sprite.png"))).getImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x, y, getWidth() / 5, getHeight() / 5, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                this.x -= 20;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                for (int i = (int) this.x / 100; i < 5; i++) {
                    System.out.println(i);
                    if (maze.checkCollision(i, (int) this.y / 100)) {
                        this.x = (i - 1) * 100;
                        System.out.println(this.x); 
                        break;
                    }
                }
            
                this.x += 20;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                this.y -= 20;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                this.y += 20;
                break;
            default:
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}