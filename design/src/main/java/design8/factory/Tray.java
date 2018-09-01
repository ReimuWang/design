package design8.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象零件：托盘。
 * 其中保存着托盘或者链接
 */
public abstract class Tray extends Item {

    protected List<Item> content = new ArrayList<Item>();

    /**
     * @param caption, 为null则表示该tray是最大的那一个托盘
     */
    protected Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        this.content.add(item);
    }
}