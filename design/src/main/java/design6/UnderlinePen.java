package design6;

/**
 * 在字符串下方加上下划线
 */
public class UnderlinePen implements Product {

    /**
     * 组成下划线的字符
     */
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String str) {
        System.out.println(str);
        for (int i = 0; i < str.length(); i++)
            System.out.print(this.ulchar);
        System.out.println();
    }

    @Override
    public Product createClone() throws CloneNotSupportedException {
        return (UnderlinePen)this.clone();
    }
}