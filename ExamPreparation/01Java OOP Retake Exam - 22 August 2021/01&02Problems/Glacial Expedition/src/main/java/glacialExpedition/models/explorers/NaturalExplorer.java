package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_ENERGY = 60;
    private static final double STEP_DOWN = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(0, this.getEnergy() - STEP_DOWN));
    }
}
