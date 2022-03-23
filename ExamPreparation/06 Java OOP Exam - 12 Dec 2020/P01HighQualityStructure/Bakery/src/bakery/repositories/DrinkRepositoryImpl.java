package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;

public class DrinkRepositoryImpl<T extends Drink> extends BaseRepository<T> implements DrinkRepository<T> {
    public DrinkRepositoryImpl() {
        super(new ArrayList<>());
    }

    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        return this.getAll()
                .stream()
                .filter(d->d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }
}
