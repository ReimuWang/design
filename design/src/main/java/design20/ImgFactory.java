package design20;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImgFactory {

    private Map<Integer, Img> pool = new HashMap<Integer, Img>();

    private static ImgFactory SINGLETON;

    public static final int WIDTH = 88;

    public static final int HEIGHT = 151;

    private ImgFactory() {}

    public static ImgFactory getInstance() {
        if (null == ImgFactory.SINGLETON) ImgFactory.SINGLETON = new ImgFactory();
        return ImgFactory.SINGLETON;
    }

    public BufferedImage getNumImg(int number) {
        if (!this.pool.containsKey(number)) this.pool.put(number, new Img(number));
        return this.pool.get(number).image;
    }
}