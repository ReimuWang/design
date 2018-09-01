package design5;

public class Singleton {

    private static Singleton SINGLETON;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (null == Singleton.SINGLETON)
            Singleton.SINGLETON = new Singleton();
        return Singleton.SINGLETON;
    }
}