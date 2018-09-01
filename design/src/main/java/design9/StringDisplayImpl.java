package design9;

public class StringDisplayImpl extends DisplayImpl {

    private String str;

    public StringDisplayImpl(String str) {
        this.str = str;
    }

    @Override
    void open() {
        this.printLine();
    }

    @Override
    void print() {
        String ch = "|";
        System.out.println(ch + this.str + ch);
    }

    @Override
    void close() {
        this.printLine();
    }

    private void printLine() {
        String ch = "+";
        System.out.print(ch);
        for (int i = 0; i < this.str.length(); i++)
            System.out.print("-");
        System.out.println(ch);
    }
}