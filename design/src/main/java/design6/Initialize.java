package design6;

public class Initialize {

    public static Manager initialize() {
        Manager manager = new Manager();
        manager.register("big box", new MessageBox('$', 5));
        manager.register("small box", new MessageBox('=', 2));
        manager.register("strong underLine", new UnderlinePen('*'));
        manager.register("weak underLine", new UnderlinePen('-'));
        return manager;
    }
}