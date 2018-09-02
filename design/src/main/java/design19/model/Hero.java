package design19.model;

public abstract class Hero {

    protected boolean ifDeath;

    protected int maxHealth = 2 * (370 + 90 * 17);

    protected int healthRegen = (int)(3 * (1 + 0.12 * 17));

    protected int health = maxHealth;

    protected int ap;

    public abstract void useQ();

    public abstract void useW();

    public abstract void useE();

    public abstract void useR();

    public abstract boolean ifHaveMana();

    protected abstract double manaRate();

    public abstract String getImgKeyWord();

    public abstract double remainQ();

    public abstract double remainW();

    public abstract double remainE();

    public abstract double remainR();

    Hero() {
        // 回血
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Hero.this.ifDeath) {
                        Hero.this.health = 0;
                        break;
                    }
                    try {
                        int tempHealth = Hero.this.health + Hero.this.healthRegen;
                        Hero.this.health = tempHealth > Hero.this.maxHealth ? Hero.this.maxHealth : tempHealth;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public boolean isDeath() {
        return ifDeath;
    }

    public void damage(int value) {
        int tempHealth = this.health - value;
        if (tempHealth <= 0) {
            this.ifDeath = true;
            this.health = 0;
            return;
        }
        this.health = tempHealth;
    }

    public double getHealthRate() {
        return 1.0 * this.health / this.maxHealth;
    }

    public double getManaRate() {
        if (!this.ifHaveMana()) throw new UnsupportedOperationException();
        return this.manaRate();
    }

    long remainTime(Skill skill) {
        long pass = System.currentTimeMillis() - skill.last;
        return (pass - skill.cd) >= 0 ? 0 : (skill.cd - pass);
    }

    boolean check(String mark) {
        if (this.ifDeath) return false;
        if ("Q".equals(mark))
            if (this.remainQ() > 0) return false;
        if ("W".equals(mark))
            if (this.remainW() > 0) return false;
        if ("E".equals(mark))
            if (this.remainE() > 0) return false;
        if ("R".equals(mark))
            if (this.remainR() > 0) return false;
        return true;
    }
}