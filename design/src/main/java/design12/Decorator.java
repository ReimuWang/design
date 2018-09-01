package design12;

public abstract class Decorator extends Dessert {

    protected Dessert dessert;

    protected Decorator(Dessert dessert) {
        this.dessert = dessert;
    }
}