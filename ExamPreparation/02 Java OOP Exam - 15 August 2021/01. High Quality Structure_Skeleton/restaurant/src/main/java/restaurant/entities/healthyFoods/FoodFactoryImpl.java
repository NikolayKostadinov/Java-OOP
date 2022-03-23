package restaurant.entities.healthyFoods;

public class FoodFactoryImpl implements FoodFactory{

    @Override
    public Food getInstance(String type, double price, String name) {
        switch (type){
            case "Salad":
                return new Salad(name, price);
            case "VeganBiscuits":
                    return new VeganBiscuits(name, price);
            default:
                return null;
        }
    }
}
