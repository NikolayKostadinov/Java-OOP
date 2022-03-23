package bakery.entities.drinks;

public class Water extends BaseDrink{
    public static final double PRICE = 1.5;

    public Water(String name, int portion, String brand) {
        super(name, portion, PRICE, brand);
    }
}
