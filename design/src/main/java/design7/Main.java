package design7;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
        String path = "D:" + File.separator;
        String title = "东方幻想乡";
        new Designer().construct(new TextBuilder(), path, title);
        new Designer().construct(new HtmlBuilder(), path, title);
    }
}