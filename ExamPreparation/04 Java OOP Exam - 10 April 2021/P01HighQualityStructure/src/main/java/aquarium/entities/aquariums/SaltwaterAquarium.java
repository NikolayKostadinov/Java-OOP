package aquarium.entities.aquariums;

import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;

public class SaltwaterAquarium extends BaseAquarium{

    public static final int CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addFish(Fish fish) {
        if (!fish.getClass().equals(SaltwaterFish.class))
            throw new IllegalArgumentException("Water not suitable.");
        super.addFish(fish);
    }
}
