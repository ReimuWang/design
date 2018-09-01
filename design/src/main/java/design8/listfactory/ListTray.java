package design8.listfactory;

import java.util.ArrayList;
import java.util.List;

import design8.factory.Item;
import design8.factory.Tray;

public class ListTray extends Tray {

    ListTray(String caption) {
        super(caption);
    }

    @Override
    public List<String> makeHtml() {
        List<String> result = new ArrayList<String>();
        if (null == this.caption) this.addLi(result);
        else {
            result.add("<li>");
            result.add(this.caption);
            this.addLi(result);
            result.add("</li>");
        }
        return result;
    }

    private void addLi(List<String> result) {
        result.add("<ul>");
        for (Item item : this.content) result.addAll(item.makeHtml());
        result.add("</ul>");
    }
}