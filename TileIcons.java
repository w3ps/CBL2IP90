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
    private BufferedImage[] images = new BufferedImage[2];

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
                images[i] = ImageIO.read(new File("tiles\\tile" + i + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public JPanel getTileIcon(int r, int c) {
        return new ScaledImagePanel(images[tiles[r][c]]);
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
                // Get panel dimensions
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                // Draw the image scaled to fit the panel
                g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
            }
        }
    }
}
