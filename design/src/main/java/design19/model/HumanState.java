package design19.model;

public class HumanState extends NidaleeState {

    HumanState(Nidalee nidalee) {
        super(nidalee);
        this.type = "human";
        this.maxMana = 4 * (220 + 45 * 17);
        this.manaRegen = (int)(5 * (0.9 + 0.06 * 17));
        this.mana = maxMana;
        this.skillQ = new Skill(6000L, 90);
        this.skillW = new Skill(18000L, 60);
        this.skillE = new Skill(10000L, 120);
        // 回蓝
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (HumanState.this.nidalee.ifDeath) break;
                    try {
                        int tempMana = HumanState.this.mana + HumanState.this.manaRegen;
                        HumanState.this.mana = tempMana > HumanState.this.maxMana ? HumanState.this.maxMana : tempMana;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void handleQ() {
        this.modMana(this.skillQ.cost);
    }

    @Override
    protected void handleW() {
        this.modMana(this.skillW.cost);
    }

    @Override
    protected void handleE() {
        this.modMana(this.skillE.cost);
        double loseHealthRate = 1.0 - this.nidalee.getHealthRate();
        double addHealthBase = 115 + (230 - 115) * loseHealthRate;
        double addHealthAP = this.nidalee.ap * (0.325 + (0.65 - 0.325) * loseHealthRate);
        int tempHealth = this.nidalee.health + (int)(addHealthBase + addHealthAP);
        this.nidalee.health = tempHealth >= this.nidalee.maxHealth ? this.nidalee.maxHealth : tempHealth;
    }

    private void modMana(int cost) {
        if (this.mana < cost) return;
        int tempMana = this.mana - cost;
        this.mana = tempMana > 0 ? tempMana : 0;
    }
}