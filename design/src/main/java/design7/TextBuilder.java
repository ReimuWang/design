package design7;

public class TextBuilder extends Builder {

    @SuppressWarnings("unused")
    private static String FILE_TYPE = "txt";

    @Override
    public void bulidHead(String head) {
        String decorate = "====================";
        this.result.add(decorate + head + decorate);
    }

    @Override
    public void bulidTitle(String title) {
        String decorate = "#";
        this.result.add(decorate + title + decorate);
    }

    @Override
    public void bulidString(String str) {
        this.result.add(str);
    }

    @Override
    public void bulidItems(String[] items) {
        for (String item : items)
            this.result.add("    · " + item);
    }

    @Override
    public void bulidTail() {}
}