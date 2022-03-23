package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;

public class FoodRepositoryImpl<T extends BakedFood> extends BaseRepository<T> implements FoodRepository<T> {
    public FoodRepositoryImpl() {
        super(new ArrayList<>());
    }

    @Override
    public T getByName(String name) {
        return this.getAll().stream().filter(f->f.getName().equals(name)).findFirst().orElse(null);
    }
}
