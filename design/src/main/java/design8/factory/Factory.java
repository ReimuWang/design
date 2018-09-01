package design8.factory;

import design8.listfactory.ListFactory;

/**
 * 抽象工厂
 */
public abstract class Factory {

    public static Factory getListFactory() {
        return ListFactory.getInstance();
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String caption, Tray tray);
}