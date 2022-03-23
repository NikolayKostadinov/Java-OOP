package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

public interface BeverageFactory {
    Beverages getInstance(String type, int counter, String brand, String name);
}
