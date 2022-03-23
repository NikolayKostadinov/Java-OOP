package restaurant.entities.healthyFoods;

public interface FoodFactory {
    Food getInstance(String type, double price, String name);
}
