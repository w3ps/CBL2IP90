import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DynamicScaledImageGrid extends JFrame {

    public DynamicScaledImageGrid() {
        try {
            // Load the image (ensure the file path is correct)
            BufferedImage image = ImageIO.read(new File("tiles\\tile0.png"));

            // Create a 4x4 grid layout
            JPanel gridPanel = new JPanel(new GridLayout(4, 4));
            gridPanel.setBackground(Color.WHITE);

            // Add 16 custom panels that draw the scaled image
            for (int i = 0; i < 16; i++) {
                gridPanel.add(new SIP(image));
            }

            add(gridPanel);

            // Frame setup
            setTitle("Dynamic Scaled Image Grid");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
            setLocationRelativeTo(null);
            setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Custom JPanel that automatically draws and scales (TODO) the image
    private static class SIP extends JPanel {
        private final BufferedImage image;

        public SIP(BufferedImage image) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DynamicScaledImageGrid::new);
    }
}
