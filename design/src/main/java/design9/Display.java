package design9;

public class Display {

    protected DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public final void display() {
        this.impl.open();
        this.impl.print();
        this.impl.close();
    }
}