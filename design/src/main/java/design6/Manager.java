package design6;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<String, Product> showcase = new HashMap<String, Product>();

    public void register(String name, Product proto) {
        this.showcase.put(name, proto);
    }

    public Product create(String name) throws CloneNotSupportedException {
        return this.showcase.get(name).createClone();
    }
}