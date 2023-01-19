import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Filters {
    private String filename;
    private BufferedImage pic;

    public Filters(String filename) {
        this.filename = filename;
        File img = new File(filename);
        try {
            pic = ImageIO.read(img);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage grayscale() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);
                Color gray = Luminance.toGray(color);
                int newrgb = gray.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage sepia() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.393 * red) + (0.769 * green) + (0.189 * blue));
                int tg = (int) ((0.349 * red) + (0.686 * green) + (0.168 * blue));
                int tb = (int) ((0.272 * red) + (0.534 * green) + (0.131 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color sepia = new Color(tr, tg, tb);
                int newrgb = sepia.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage ella() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.983 * red) + (0.235 * green) + (0.801 * blue));
                int tg = (int) ((0.349 * red) + (0.678 * green) + (0.325 * blue));
                int tb = (int) ((0.857 * red) + (0.444 * green) + (0.231 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color Ella = new Color(tr, tg, tb);
                int newrgb = Ella.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage brooke() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.135 * red) + (0.269 * green) + (0.932 * blue));
                int tg = (int) ((0.791 * red) + (0.329 * green) + (0.128 * blue));
                int tb = (int) ((0.112 * red) + (0.345 * green) + (0.119 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color Brooke = new Color(tr, tg, tb);
                int newrgb = Brooke.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage kevin() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.111 * red) + (0.023 * green) + (0.219 * blue));
                int tg = (int) ((0.791 * red) + (0.329 * green) + (0.128 * blue));
                int tb = (int) ((0.999 * red) + (0.999 * green) + (0.999 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color Kevin = new Color(tr, tg, tb);
                int newrgb = Kevin.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage high() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.135 * red) + (0.269 * green) + (0.211 * blue));
                int tg = (int) ((0.231 * red) + (0.183 * green) + (0.128 * blue));
                int tb = (int) ((0.112 * red) + (0.245 * green) + (0.119 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color High = new Color(tr, tg, tb);
                int newrgb = High.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public BufferedImage low() {
        for (int col = 0; col < pic.getWidth(); col++)
            for (int row = 0; row < pic.getHeight(); row++) {
                int rgb = pic.getRGB(col, row);
                Color color = new Color(rgb);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int tr = (int) ((0.988 * red) + (0.887 * green) + (0.899 * blue));
                int tg = (int) ((0.899 * red) + (0.879 * green) + (0.987 * blue));
                int tb = (int) ((0.999 * red) + (0.999 * green) + (0.999 * blue));

                if (tr > 255)
                    tr = 255;
                if (tg > 255)
                    tg = 255;
                if (tb > 255)
                    tb = 255;

                Color Low = new Color(tr, tg, tb);
                int newrgb = Low.getRGB();
                pic.setRGB(col, row, newrgb);
            }
        return pic;
    }

    public static void main(String[] args) {

    }
}
