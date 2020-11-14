package waterworld.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageLoader {

    private BufferedImage image;
    private Dimension imageSize;
    private final String fileAndFileLocation;

    public ImageLoader(String fileAndFileLocation) {
        this.fileAndFileLocation = fileAndFileLocation;
        loadImageAndImageSizeFromFile();
        getSizeFromLoadedImage();
    }

    private void loadImageAndImageSizeFromFile() {
        try {
            loadImageFromFile();
        } catch (Exception error) {
            System.out.println("ImageLoader has trouble to load the image" + error.getMessage());
        }
    }

    private void loadImageFromFile() throws Exception {
        this.image = ImageIO.read(getClass().getResourceAsStream(this.fileAndFileLocation));
    }

    private void getSizeFromLoadedImage() {
        this.imageSize = new Dimension(this.image.getWidth(), this.image.getHeight());
    }

    public final BufferedImage getImage() {
        return this.image;
    }

    public final Dimension getImageSize() {
        return this.imageSize;
    }
}
