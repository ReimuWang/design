package design9;

public class Main {

    public static void main(String[] args) {
        DisplayImpl displayImpl = new StringDisplayImpl("ReimuWang");
        CountDisplay display = new CountDisplay(displayImpl);
        display.multiDisplay(5);
    }
}