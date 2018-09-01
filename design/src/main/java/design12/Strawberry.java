package design12;

public class Strawberry extends Decorator {

    public Strawberry(Dessert dessert) {
        super(dessert);
    }

    @Override
    protected int getSatiety() {
        return this.dessert.getSatiety() + 2;
    }

    @Override
    protected int getHappiness() {
        return this.dessert.getHappiness() + 2;
    }

    @Override
    protected String name() {
        return this.dessert.name() + "[草莓]";
    }
}