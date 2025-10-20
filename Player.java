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
    private int step;
    private int x;
    private int y;
    private Image sprite;
    private Maze maze;

    /**
     * Constructor for the player class.
     */
    Player(int size, int tileSize) {
        step = size / tileSize;
        x = 0;
        y = 0;

        addKeyListener(this);
        setOpaque(false);
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite = (new ImageIcon(this.getClass().getResource("textures\\Sprite.png"))).getImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, 0, 0, this);
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
            case KeyEvent.VK_R:
                restart();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Moves the player right to the next wall.
     */
    public void moveR() {
        while (!maze.checkCollision(x + step, y)) {
            x += step;
        }
        setLocation(x, y);
        repaint();
    }

    /**
     * Moves the player left to the next wall.
     */
    public void moveL() {
        while (!maze.checkCollision(x - step, y)) {
            x -= step;
        }
        setLocation(x, y);
        repaint();
    }

    /**
     * Moves the player up to the next wall.
     */
    public void moveU() {
        while (!maze.checkCollision(x, y - step)) {
            y -= step;
        }
        setLocation(x, y);
        repaint();
    }

    /**
     * Moves the player down to the next wall.
     */
    public void moveD() {
        while (!maze.checkCollision(x, y + step)) {
            y += step;
        }
        setLocation(x, y);
        repaint();
    }

    /**
     * Moves the player back to the start.
     */
    public void restart() {
        x = 0;
        y = 0;
        setLocation(x, y);
        repaint();
    }
}