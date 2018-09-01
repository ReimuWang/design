package design12;

public class Chocolate extends Decorator {

    public Chocolate(Dessert dessert) {
        super(dessert);
    }

    @Override
    protected int getSatiety() {
        return this.dessert.getSatiety() + 3;
    }

    @Override
    protected int getHappiness() {
        return this.dessert.getHappiness() + 3;
    }

    @Override
    protected String name() {
        return this.dessert.name() + "[巧克力]";
    }
}