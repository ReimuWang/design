package design19.model;

public class Nidalee extends Hero {

    Skill skillR = new Skill(4000L, 0);

    NidaleeState state;

    public Nidalee() {
        NidaleeState humanState = new HumanState(this);
        NidaleeState leopardState = new LeopardState(this);
        humanState.otherState = leopardState;
        leopardState.otherState = humanState;
        this.state = humanState;
    }

    @Override
    public void useQ() {
        this.state.useQ();
    }

    @Override
    public void useW() {
        this.state.useW();
    }

    @Override
    public void useE() {
        this.state.useE();
    }

    @Override
    public void useR() {
        this.state.useR();
    }

    @Override
    public boolean ifHaveMana() {
        return this.state.maxMana > 0;
    }

    @Override
    public double getManaRate() {
        return 1.0 * this.state.mana / this.state.maxMana;
    }

    @Override
    public String getImgKeyWord() {
        return this.state.type;
    }

    @Override
    public double remainQ() {
        if (this.ifDeath) return 0.0;
        return 1.0 * this.remainTime(this.state.skillQ) / this.state.skillQ.cd;
    }

    @Override
    public double remainW() {
        if (this.ifDeath) return 0.0;
        return 1.0 * this.remainTime(this.state.skillW) / this.state.skillW.cd;
    }

    @Override
    public double remainE() {
        if (this.ifDeath) return 0.0;
        return 1.0 * this.remainTime(this.state.skillE) / this.state.skillE.cd;
    }

    @Override
    public double remainR() {
        if (this.ifDeath) return 0.0;
        return 1.0 * this.remainTime(this.skillR) / this.skillR.cd;
    }
}