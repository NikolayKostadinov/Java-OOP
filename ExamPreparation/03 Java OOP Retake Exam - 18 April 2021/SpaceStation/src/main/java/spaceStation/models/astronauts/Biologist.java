package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    public static final int INITIAL_OXYGEN = 70;
    public static final int DECREASE = 5;

    protected Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double oxygenLeft = this.getOxygen() - DECREASE;
        this.setOxygen(oxygenLeft < 0 ? 0 : oxygenLeft);
    }
}
