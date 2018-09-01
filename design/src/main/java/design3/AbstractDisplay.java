package design3;

public abstract class AbstractDisplay {

    private int times;

    protected AbstractDisplay(int times) {
        this.times = times;
    }

    public final void display() {
        this.open();
        for (int i = 0; i < this.times; i++)
            this.print();
        this.close();
    }

    protected abstract void open();

    protected abstract void print();

    protected abstract void close();
}