package design12;

public class Cake extends Dessert {

    @Override
    protected int getSatiety() {
        return 10;
    }

    @Override
    protected int getHappiness() {
        return 5;
    }

    @Override
    protected String name() {
        return "[蛋糕]";
    }
}