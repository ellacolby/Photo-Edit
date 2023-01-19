import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Warp {

    private String filename;
    private BufferedImage pic;

    public Warp(String filename) {
        this.filename = filename;
        File img = new File(filename);
        try {
            pic = ImageIO.read(img);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns a Picture where each pixel is mirrored horizontally
    // does not modify input Picture
    // Lecture Using Data Types pp 28-31
    public BufferedImage flipH() {
        // create new Picture object - don't modify source
        int width = pic.getWidth();
        int height = pic.getHeight();
        Picture target = new Picture(width, height);

        // transpose EACH pixel around the horizontal axis
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the pixel
                int rgb = pic.getRGB(col, row);
                // now set the pixel at the position flipped around horizontal
                pic.setRGB(col, height - row - 1, rgb);
            }
        }

        // all done
        return pic;
    }


    // returns a Picture where each pixel is mirrored vertically
    // does not modify input Picture
    public BufferedImage flipV() {
        // create new Picture object - don't modify source
        int width = pic.getWidth();
        int height = pic.getHeight();
        Picture target = new Picture(width, height);

        // transpose EACH pixel around the horizontal axis
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the pixel
                int rgb = pic.getRGB(col, row);
                // now set the pixel at the position flipped around horizontal
                pic.setRGB(width - col - 1, row, rgb);
            }
        }
        // all done
        return pic;
    }

    public BufferedImage flipHalf() {
        // create new Picture object - don't modify source
        int width = pic.getWidth();
        int height = pic.getHeight();
        Picture target = new Picture(width, height);

        // transpose EACH pixel around the horizontal axis
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the pixel
                int rgb = pic.getRGB(col, row);
                // now set the pixel at the position flipped around horizontal
                pic.setRGB(width - col - 1, height - row - 1, rgb);
            }
        }
        // all done
        return pic;
    }

    public BufferedImage flipSome() {
        // create new Picture object - don't modify source
        int width = pic.getWidth();
        int height = pic.getHeight();
        Picture target = new Picture(width, height);

        // transpose EACH pixel around the horizontal axis
        for (int col = 0; col < width / 2; col++) {
            for (int row = 0; row < height / 2; row++) {
                // get the pixel
                int rgb = pic.getRGB(col, row);
                // now set the pixel at the position flipped around horizontal
                pic.setRGB(width - col - 1, height - row - 1, rgb);
            }
        }
        // all done
        return pic;
    }

    public static void main(String[] args) {
    }
}
