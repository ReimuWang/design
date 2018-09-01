package design8.listfactory;

import java.util.ArrayList;
import java.util.List;

import design8.factory.Link;

public class ListLink extends Link {

    ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public List<String> makeHtml() {
        List<String> result = new ArrayList<String>();
        result.add("<li><a href=\"" + this.url + "\">" + this.caption + "</a></li>");
        return result;
    }
}