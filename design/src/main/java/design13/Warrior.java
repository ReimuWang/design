package design13;

public class Warrior {

    private String name;

    private String race;

    private int attack;

    private int defense;

    public Warrior(String name, String race, int attack, int defense) {
        this.name = name;
        this.race = race;
        this.attack = attack;
        this.defense = defense;
    }

    public void show(Visitor visitor) {
        visitor.show(this);
    }

    /**
     * 随机增强或减弱
     * @param max int, 增强或减弱的上限
     */
    public void change(Visitor visitor, int max) {
        visitor.change(this, max);
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}