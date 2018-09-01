package design3;

public class CharDisplay extends AbstractDisplay {

    private char ch;

    public CharDisplay(char ch, int times) {
        super(times);
        this.ch = ch;
    }

    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(this.ch);
    }

    @Override
    protected void close() {
        System.out.println(">>");
    }
}