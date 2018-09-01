package design13;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("博丽灵梦", "人类", 97, 85);
        Visitor visitor = new Visitor();
        warrior.show(visitor);
        warrior.change(visitor, 10);
        warrior.show(visitor);
    }
}