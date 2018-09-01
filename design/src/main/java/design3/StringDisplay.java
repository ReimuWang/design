package design3;

public class StringDisplay extends AbstractDisplay {

    private String str;

    public StringDisplay(String str, int times) {
        super(times);
        this.str = str;
    }

    @Override
    protected void open() {
        this.printLine();
    }

    @Override
    protected void print() {
        System.out.println("|" + this.str + "|");
    }

    @Override
    protected void close() {
        this.printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < this.str.length(); i++)
            System.out.print("-");
        System.out.println("+");
    }
}