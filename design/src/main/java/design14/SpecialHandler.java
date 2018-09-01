package design14;

public class SpecialHandler extends Handler {

    private int number;

    public SpecialHandler(int number) {
        super("SpecialHandler-" + number);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == this.number) return true;
        return false;
    }

}