import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

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
    
    public BufferedImage getTileIcon(int r, int c) {
        return images[tiles[r][c]];
    }
}
