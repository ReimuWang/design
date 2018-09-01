package design12;

public class IceCream extends Dessert {

    @Override
    protected int getSatiety() {
        return 5;
    }

    @Override
    protected int getHappiness() {
        return 10;
    }

    @Override
    protected String name() {
        return "[冰淇淋]";
    }
}