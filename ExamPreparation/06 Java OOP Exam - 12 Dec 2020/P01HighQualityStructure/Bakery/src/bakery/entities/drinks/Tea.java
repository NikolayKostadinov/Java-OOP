package bakery.entities.drinks;

public class Tea extends BaseDrink{

    public static final double PRICE = 2.5;

    public Tea(String name, int portion, String brand) {
        super(name, portion, PRICE, brand);
    }
}
