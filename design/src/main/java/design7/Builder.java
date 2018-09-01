package design7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Builder {

    protected List<String> result = new ArrayList<String>();

    public abstract void bulidHead(String head);

    public abstract void bulidTitle(String title);

    public abstract void bulidString(String str);

    public abstract void bulidItems(String[] items);

    public abstract void bulidTail();

    public void createFile(String pathPre) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
        Field filed = this.getClass().getDeclaredField("FILE_TYPE");
        filed.setAccessible(true);
        String fileType = (String)filed.get(null);
        String outPutPath = pathPre + "." + fileType;
        FileOutputStream fos = null;
        PrintStream ps = null;
        try {
            fos = new FileOutputStream(new File(outPutPath));
            ps = new PrintStream(fos);
            for (String str : this.result) ps.println(str);
        } finally {
            ps.close();
            fos.close();
        }
    }
}