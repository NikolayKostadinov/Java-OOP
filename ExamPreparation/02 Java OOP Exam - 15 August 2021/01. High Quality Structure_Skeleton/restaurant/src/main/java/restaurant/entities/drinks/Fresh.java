package restaurant.entities.drinks;

public class Fresh extends BaseBeverage{

    public static final double PRICE = 3.50;

    public Fresh(String name, int counter, String brand) {
        super(name, counter, PRICE, brand);
    }
}
