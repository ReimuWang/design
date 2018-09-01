package design17_2;

public class Main {

    public static void main(String[] args) {
        Model model = new Model(1000L, 50);
        new Thread(model).start();
        new View(model).launchFrame();
    }
}