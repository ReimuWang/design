package design3;

public class Main {

    public static void main(String[] args) {
        int times = 5;
        AbstractDisplay adChar = new CharDisplay('蓬', times);
        adChar.display();
        AbstractDisplay adStr = new StringDisplay("I am the bone of my sword", times);
        adStr.display();
    }
}