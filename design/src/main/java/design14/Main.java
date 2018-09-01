package design14;

public class Main {

    public static void main(String[] args) {
        Handler handler = Handler.init();
        for (int i = 0; i < 30; i++)
            handler.handle(new Trouble(i));
    }
}