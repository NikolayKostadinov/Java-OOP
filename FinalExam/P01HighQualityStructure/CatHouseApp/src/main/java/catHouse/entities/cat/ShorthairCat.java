package catHouse.entities.cat;
//Can only live in ShortHouse!
public class ShorthairCat extends BaseCat{

    public static final int INITIAL_KILOGRAMS = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(INITIAL_KILOGRAMS);
    }
}
