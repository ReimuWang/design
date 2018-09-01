package design8.listfactory;

import design8.factory.Factory;
import design8.factory.Link;
import design8.factory.Page;
import design8.factory.Tray;

public class ListFactory extends Factory {

    private static ListFactory SINGLETON = new ListFactory();

    private ListFactory() {}

    public static ListFactory getInstance() {
        return ListFactory.SINGLETON;
    }

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String caption, Tray tray) {
        return new ListPage(caption, tray);
    }
}