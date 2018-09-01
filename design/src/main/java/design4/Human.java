package design4;

public class Human extends Role {

    protected Human(String name) {
        super(name);
    }

    @Override
    protected String race() {
        return "人类";
    }
}