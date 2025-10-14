import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * TODO
 * TODO.
 */
public class TileIcons {
    private int[][] tiles;
    private BufferedImage[] images = new BufferedImage[7];

    /**
     * Constructor for the 'Tile' class.
     */
    public TileIcons(int [][] tiles) {
        this.tiles = tiles;
        initialize();
    }

    /**
     * Initializes 'images', by adding all the images from the 'tiles' folder.
     */
    public void initialize() {
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("tiles\\" + (i + 1) + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Returns the image corresponding to the tile, or null is the tile is 'air'.
     */
    public JPanel getTileIcon(int r, int c) {
        int tileValue = tiles[r][c];
        if (tileValue == 0) {
            return new ScaledImagePanel(null);
        } else {
            return new ScaledImagePanel(images[tileValue]);

        }
    }

    // Automatically scales and draws the image
    private static class ScaledImagePanel extends JPanel {
        private final BufferedImage image;

        public ScaledImagePanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}
