package design7;

public class HtmlBuilder extends Builder {

    @SuppressWarnings("unused")
    private static String FILE_TYPE = "html";

    @Override
    public void bulidHead(String head) {
        this.result.add("<html>");
        this.result.add(this.indent(1) + "<head><title>" + head + "</title></head>");
        this.result.add(this.indent(1) + "<body>");
    }

    @Override
    public void bulidTitle(String title) {
        this.result.add(this.indent(2) + "<h1>" + title + "</h1>");
    }

    @Override
    public void bulidString(String str) {
        this.result.add(this.indent(2) + "<p>" + str + "</p>");
    }

    @Override
    public void bulidItems(String[] items) {
        this.result.add(this.indent(2) + "<ul>");
        for (String item : items)
            this.result.add(this.indent(3) + "<li>" + item + "</li>");
        this.result.add(this.indent(2) + "</ul>");
    }

    @Override
    public void bulidTail() {
        this.result.add(this.indent(1) + "</body>");
        this.result.add("</html>");
    }

    private String indent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append("  ");
        return sb.toString();
    }
}