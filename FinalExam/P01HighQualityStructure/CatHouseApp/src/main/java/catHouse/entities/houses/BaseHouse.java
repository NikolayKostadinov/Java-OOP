package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() >= capacity) {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("%s %s:", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append(String.format("Cats: %s",
                this.cats.isEmpty() ? "none" :
                        this.cats
                        .stream()
                        .map(Cat::getName)
                        .collect(Collectors.joining(" "))))
                .append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %s", this.toys.size(), this.sumSoftness()));

        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }
}
