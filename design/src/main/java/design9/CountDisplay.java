package design9;

public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        this.impl.open();
        for(int i = 0; i < times; i++) this.impl.print();
        this.impl.close();
    }
}