import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

class FilePathfinder {
    public static ArrayList<File> findFiles(String ext){
        File root = new File("./src");
        ArrayList<File> expand = new ArrayList<File>();
        expand.addAll(Arrays.asList(root.listFiles()));

        ArrayList<File> result = new ArrayList<File>();

        for (File file: expand) {
            String name = file.getName();
            if (!file.isDirectory() && ext.equals(FilePathfinder.getExt(name))) {
                result.add(file);
            }
        }

        return result;
    }

    public static String getExt(String filename) {
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            return null;
        }

        return filename.substring(index + 1);
    }
}

class Transformer {
    // Задание 4.1
    public static void transformFiles(String inExt, String outExt) throws Exception{
        ArrayList<File> files = FilePathfinder.findFiles(inExt);

        for (File  file : files) {
            String path = file.getPath();
            BufferedImage img = ImageIO.read(new File(path));
            draw(img);
            int index = path.lastIndexOf(".");
            String pathWithoutExt = path.substring(0, index);
            ImageIO.write(img, outExt, new File(pathWithoutExt + "." + outExt));
            file.delete();
        }
    }

    // Задание 4.2
    public static void draw(BufferedImage img){
        Graphics2D g = img.createGraphics();
        int w = img.getWidth() / 2, h = img.getHeight() / 2;
        int wRect = (img.getWidth()-w)/2, hRect = (img.getHeight()-h)/2;

        g.setColor(Color.BLACK);
        g.drawRect(wRect, hRect, w, h);

        Font customFont = new Font("Serif", Font.PLAIN, 14);
        FontMetrics customFm = g.getFontMetrics(customFont);

        g.drawString("Hello,", wRect, hRect + customFm.getAscent());
        g.drawString("World!", wRect, hRect + customFm.getAscent() * 2);

        g.dispose();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Transformer.transformFiles("jpg", "png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}