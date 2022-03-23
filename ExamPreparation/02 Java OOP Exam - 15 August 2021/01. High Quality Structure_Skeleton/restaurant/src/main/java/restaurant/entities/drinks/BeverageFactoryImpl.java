package restaurant.entities.drinks;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;

public class BeverageFactoryImpl implements BeverageFactory {
    @Override
    public Beverages getInstance(String type, int counter, String brand, String name) {
        switch (type) {
            case "Fresh":
                return new Fresh(name, counter, brand);
            case "Smoothie":
                return new Smoothie(name, counter, brand);
            default:
                return null;
        }
    }
}
