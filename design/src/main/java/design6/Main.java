package design6;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Manager manager = Initialize.initialize();
        Product bigBox = manager.create("weak underLine");
        bigBox.use("ReimuWang");
    }
}