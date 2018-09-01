package design8.factory;

/**
 * 抽象零件：链接
 */
public abstract class Link extends Item {

    protected String url;

    protected Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}