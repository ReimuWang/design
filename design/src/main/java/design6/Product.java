package design6;

public interface Product extends Cloneable {

    /**
     * 具体的打印逻辑
     */
    void use(String str);

    /**
     * 复制自身
     */
    Product createClone() throws CloneNotSupportedException;
}