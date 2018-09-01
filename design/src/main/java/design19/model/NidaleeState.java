package design19.model;

public abstract class NidaleeState {

    protected Nidalee nidalee;

    protected String type;

    protected NidaleeState otherState;

    protected int maxMana;

    protected int manaRegen;

    protected int mana;

    protected Skill skillQ;

    protected Skill skillW;

    protected Skill skillE;

    protected abstract void handleQ();

    protected abstract void handleW();

    protected abstract void handleE();

    NidaleeState(Nidalee nidalee) {
        this.nidalee = nidalee;
    }

    void useQ() {
        if (!this.nidalee.check("Q")) return;
        if (this.mana < this.skillQ.cost) return;
        this.skillQ.last = System.currentTimeMillis();
        this.handleQ();
    }

    void useW() {
        if (!this.nidalee.check("W")) return;
        if (this.mana < this.skillW.cost) return;
        this.skillW.last = System.currentTimeMillis();
        this.handleW();
    }

    void useE() {
        if (!this.nidalee.check("E")) return;
        if (this.mana < this.skillE.cost) return;
        this.skillE.last = System.currentTimeMillis();
        this.handleE();
    }

    void useR() {
        if (!this.nidalee.check("R")) return;
        this.nidalee.skillR.last = System.currentTimeMillis();
        this.nidalee.state = this.otherState;
    }
}