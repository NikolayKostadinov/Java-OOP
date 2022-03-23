package aquarium.entities.aquariums;

import aquarium.common.ExceptionMessages;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;

public class FreshwaterAquarium extends BaseAquarium{

    public static final int CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addFish(Fish fish) {
        if (!fish.getClass().equals(FreshwaterFish.class))
            throw new IllegalArgumentException("Water not suitable.");
        super.addFish(fish);
    }
}
