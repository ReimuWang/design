package design8.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * 抽象产品：页面
 * 产品也可被视为一种零件，或者反过来说也成立。因为此时已经是一种一对一的关系了(该产品只由一种零件构成)
 * 其中保存着网页基本信息及存储主体内容的托盘
 */
public abstract class Page extends Item {

    protected Tray tray;

    protected Page(String caption, Tray tray) {
        super(caption);
        this.tray = tray;
    }

    public void createFile(String outPutPath) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
        FileOutputStream fos = null;
        PrintStream ps = null;
        try {
            fos = new FileOutputStream(new File(outPutPath + File.separator + this.caption + ".html"));
            ps = new PrintStream(fos);
            List<String> strList = this.makeHtml();
            for (String str : strList) ps.println(str);
        } finally {
            ps.close();
            fos.close();
        }
    }
}