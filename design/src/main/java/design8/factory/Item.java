package design8.factory;

import java.util.List;

public abstract class Item {

    protected String caption;

    Item(String caption) {
        this.caption = caption;
    }

    public abstract List<String> makeHtml();
}