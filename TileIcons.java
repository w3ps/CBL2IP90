import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Implementation for the tile icons used in the maze grid.
 */
public class TileIcons {
    private BufferedImage[] images;
    private static final int PIC_AMOUNT = 3;

    /**
     * Constructor for the 'Tile' class.
     */
    public TileIcons() {
        images = new BufferedImage[PIC_AMOUNT];
        initialize();
    }

    /**
     * Initializes 'images', by adding all the images from the 'tiles' folder.
     */
    public void initialize() {
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("textures\\tiles\\" + (i + 1) + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a scaled panel corresponding to the tile, or null if the tile is
     * 'air'.
     */
    public JPanel getTileIcon(int tileVal) {
        if (tileVal == 0) {
            return new ScaledImagePanel(null);
        } else {
            return new ScaledImagePanel(images[tileVal - 1]);
        }
    }

    // Automatically scales and draws the image
    private static class ScaledImagePanel extends JPanel {
        private final BufferedImage image;

        public ScaledImagePanel(BufferedImage image) {
            this.image = image;
            setOpaque(false);
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
