package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;


public abstract class BaseAstronaut implements Astronaut {
    private static final double DECREASE = 10.0;
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public void breath() {
        double oxygenLeft = this.oxygen - DECREASE;
        this.oxygen = oxygenLeft < 0 ? 0 : oxygenLeft;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_ASTRONAUT_NAME, this.name)).append(System.lineSeparator());
        sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, this.oxygen)).append(System.lineSeparator());
        sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, this.bag.getItems().isEmpty() ? "none" :
                this.bag.getItems().stream().collect(Collectors.joining(", "))));
        return sb.toString();
    }
}
