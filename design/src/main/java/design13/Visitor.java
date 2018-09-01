package design13;

import java.util.Random;

public class Visitor {

    private Random random = new Random();

    public void show(Warrior warrior) {
        System.out.println("[" + warrior.getName() + "][" + warrior.getRace() + "][攻击力：" + warrior.getAttack() + "][防御力：" + warrior.getDefense() + "]");
    }

    public void change(Warrior warrior, int max) {
        int flag = this.random.nextInt(2);
        if (flag == 0) {
            System.out.println("恭喜~属性增强！所有属性提高" + max);
            warrior.setAttack(warrior.getAttack() + max);
            warrior.setDefense(warrior.getDefense() + max);
        } else {
            System.out.println("真不幸~属性降低！所有属性减少" + max);
            warrior.setAttack(warrior.getAttack() - max);
            warrior.setDefense(warrior.getDefense() - max);
        }
    }
}