package aquarium.entities.fish;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish {
    private String name;
    private String species;
    private int size;
    private double price;


    protected BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(FISH_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    protected void setSpecies(String species) {
        if (species == null || species.trim().isEmpty())
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        this.species = species;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    protected void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void eat() {
        this.size += 5;
    }
}
