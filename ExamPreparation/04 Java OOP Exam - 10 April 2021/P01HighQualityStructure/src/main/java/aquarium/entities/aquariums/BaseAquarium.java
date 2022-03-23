package aquarium.entities.aquariums;

import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations
                .stream()
                .mapToInt(Decoration::getComfort)
                .sum();
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {
            throw new IllegalStateException("Not enough capacity.");
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Fish: %s",
                (this.fish.isEmpty() ? "none" : this.fish
                        .stream()
                        .map(Fish::getName)
                        .collect(Collectors.joining(" "))))).append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", this.decorations.size())).append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", this.calculateComfort()));

        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
