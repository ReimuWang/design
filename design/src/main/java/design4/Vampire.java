package design4;

public class Vampire extends Role {

    protected Vampire(String name) {
        super(name);
    }

    @Override
    protected String race() {
        return "吸血鬼";
    }
}