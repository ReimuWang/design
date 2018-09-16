package design20;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException {
        Main.createImg("19210818");
    }

    private static void createImg(String str) throws IOException {
        int length = str.length();
        BufferedImage bufferedImage = new BufferedImage(ImgFactory.WIDTH * length, ImgFactory.HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < length; i++) {
            int tempNum = Integer.parseInt(str.substring(i, i + 1));
            BufferedImage tempImg = ImgFactory.getInstance().getNumImg(tempNum);
            for (int y = 0; y < tempImg.getHeight(); y++)
                for (int x = 0; x < tempImg.getWidth(); x++)
                    bufferedImage.setRGB(x + i * ImgFactory.WIDTH, y, tempImg.getRGB(x, y));
        }
        ImageIO.write(bufferedImage, "jpg", new File("D:\\img.jpg"));
    }
}