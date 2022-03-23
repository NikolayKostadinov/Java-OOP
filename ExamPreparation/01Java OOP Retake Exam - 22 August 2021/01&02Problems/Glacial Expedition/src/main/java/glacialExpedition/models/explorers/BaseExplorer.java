package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.text.DecimalFormat;
import java.util.stream.Collectors;

import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer {
    private static final double STEP_DOWN = 15;
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(0, this.getEnergy() - STEP_DOWN));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s", this.name)).append(System.lineSeparator());
        DecimalFormat df = new DecimalFormat("####");
        sb.append(String.format("Energy: %s", df.format(this.energy))).append(System.lineSeparator());
        if (this.getSuitcase().getExhibits().isEmpty()) {
            sb.append("Suitcase exhibits: None");
        } else {
            sb.append(this.getSuitcase().toString());
        }
        return sb.toString();
    }
}
