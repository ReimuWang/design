package design20;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import design19.view.View;

public class Img {

    int number;

    BufferedImage image;

    Img(int number) {
        try {
            this.image = ImageIO.read(View.class.getClassLoader().getResource("design20/img/" + number + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}