package design6;

/**
 * 在字符串周围加上环绕字符
 */
public class MessageBox implements Product {

    /**
     * 用于环绕字符串的修饰字符
     */
    private char decochar;

    /**
     * 字符串距左右修饰字符的间隙
     */
    private int padding;

    public MessageBox(char decochar, int padding) {
        this.decochar = decochar;
        this.padding = padding;
    }

    @Override
    public void use(String str) {
        this.printLine(str);
        System.out.print(this.decochar);
        for (int i = 0; i < this.padding; i++)
            System.out.print(" ");
        System.out.print(str);
        for (int i = 0; i < this.padding; i++)
            System.out.print(" ");
        System.out.print(this.decochar);
        System.out.println();
        this.printLine(str);
    }

    @Override
    public Product createClone() throws CloneNotSupportedException {
        return (MessageBox)this.clone();
    }

    private void printLine(String str) {
        for (int i = 0; i < str.length() + (this.padding + 1) * 2; i++)
            System.out.print(decochar);
        System.out.println("");
    }
}