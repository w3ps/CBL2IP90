import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
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
        // Load sprite once with a resilient loader (tries classpath and filesystem)
        sprite = loadSprite("textures/mario.png");
    }

    /**
     * Attempt to load an image from several likely locations.
     * Tries classpath (with and without leading slash), resource stream,
     * classloader,
     * then tries relative to working directory. Prints debug information to stderr.
     */
    private Image loadSprite(String resourcePath) {
        String userDir = System.getProperty("user.dir");
        String[] candidates = new String[] {
                "/" + resourcePath.replace("\\", "/"),
                resourcePath.replace("\\", "/"),
                "/" + (new File(resourcePath)).getName(),
                (new File(userDir, resourcePath)).getPath()
        };

        for (String cand : candidates) {
            try {
                URL url = this.getClass().getResource(cand);
                if (url != null) {
                    return ImageIO.read(url);
                }
                URL url2 = Thread.currentThread().getContextClassLoader().getResource(
                        cand.startsWith("/") ? cand.substring(1) : cand);
                if (url2 != null) {
                    System.err.println("Loaded sprite via classloader: " + url2);
                    return ImageIO.read(url2);
                }
            } catch (IOException ex) {
                System.err.println("Error reading image from " + cand + ": " + ex.getMessage());
            }
        }

        // 2) Try resource stream
        for (String cand : new String[] { "/" + resourcePath, resourcePath }) {
            try (java.io.InputStream is = this.getClass().getResourceAsStream(cand)) {
                if (is != null) {
                    System.err.println("Loaded sprite via getResourceAsStream: " + cand);
                    return ImageIO.read(is);
                }
            } catch (IOException ex) {
                System.err.println("Error reading image stream " + cand + ": " + ex.getMessage());
            }
        }

        // 3) Try filesystem locations
        File f1 = new File(resourcePath);
        File f2 = new File(userDir, resourcePath);
        File[] filesToTry = new File[] { f1, f2 };
        for (File f : filesToTry) {
            try {
                if (f.exists()) {
                    return ImageIO.read(f);
                } else {
                    System.err.println("File not found: " + f.getAbsolutePath());
                }
            } catch (IOException ex) {
                System.err.println("Error reading image file "
                        + f.getAbsolutePath() + ": " + ex.getMessage());
            }
        }

        // 4) Not found — print helpful diagnostics
        System.err.println("Sprite not found. Working dir: " + userDir + ", checked candidates: "
                + java.util.Arrays.toString(candidates));
        return null;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (sprite != null) {
            g2d.drawImage(sprite, 0, 0, this);
        } else {
            // placeholder so it's obvious something went wrong
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, 32, 32);
            g2d.setColor(Color.WHITE);
            g2d.drawString("no-img", 2, 16);
        }
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
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

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