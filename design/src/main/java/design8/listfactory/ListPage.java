package design8.listfactory;

import java.util.ArrayList;
import java.util.List;

import design8.factory.Page;
import design8.factory.Tray;

public class ListPage extends Page {

    protected ListPage(String caption, Tray tray) {
        super(caption, tray);
    }

    @Override
    public List<String> makeHtml() {
        List<String> result = new ArrayList<String>();
        result.add("<html>");
        result.add("<head><title>" + this.caption + "</title></head>");
        result.add("<body>");
        result.addAll(this.tray.makeHtml());
        result.add("</body>");
        result.add("</html>");
        return result;
    }
}