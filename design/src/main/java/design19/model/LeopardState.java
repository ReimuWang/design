package design19.model;

public class LeopardState extends NidaleeState {

    LeopardState(Nidalee nidalee) {
        super(nidalee);
        this.type = "leopard";
        this.skillQ = new Skill(5000L, 0);
        this.skillW = new Skill(3500L, 0);
        this.skillE = new Skill(6000L, 0);
    }

    @Override
    protected void handleQ() {}

    @Override
    protected void handleW() {}

    @Override
    protected void handleE() {}
}