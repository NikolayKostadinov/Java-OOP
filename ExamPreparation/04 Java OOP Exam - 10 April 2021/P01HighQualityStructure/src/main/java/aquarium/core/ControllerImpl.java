package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = getAquarium(aquariumType, aquariumName);

        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    private Aquarium getAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        return aquarium;
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = getDecoration(type);

        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    private Decoration getDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Plant":
                decoration = new Plant();
                break;
            case "Ornament":
                decoration = new Ornament();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        return decoration;
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = findAquarium(aquariumName);
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null)
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));

        aquarium.addDecoration(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = getFish(fishType, fishName, fishSpecies, price);

        Aquarium aquarium = findAquarium(aquariumName);

        String message = String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);

        try {
            aquarium.addFish(fish);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }

        return message;
    }

    private Aquarium findAquarium(String aquariumName) {
        return this.aquariums
                .stream()
                .filter(aq -> aq.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
    }

    private Fish getFish(String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        return fish;
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = findAquarium(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = findAquarium(aquariumName);
        double aquariumValue = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum() +
                aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, aquariumValue);
    }

    @Override
    public String report() {
        return this.aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
