package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

public class BeverageRepositoryImpl extends BaseRepository<Beverages> implements BeverageRepository<Beverages> {
    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.getAllEntities()
                .stream()
                .filter(t->t.getName().equals(drinkName) && t.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }
}
