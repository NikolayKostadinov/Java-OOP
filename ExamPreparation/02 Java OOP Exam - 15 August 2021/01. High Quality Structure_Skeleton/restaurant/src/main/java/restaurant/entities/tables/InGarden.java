package restaurant.entities.tables;

public class InGarden extends BaseTable{

    public static final double PRICE_PER_PERSON = 4.50;

    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }
}
