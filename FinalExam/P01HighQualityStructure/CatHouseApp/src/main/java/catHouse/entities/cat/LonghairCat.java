package catHouse.entities.cat;
//Can only live in LongHouse!

public class LonghairCat extends BaseCat{

    public static final int INITIAL_KILOGRAMS = 9;
    public static final int KILOGRAMS_INCREMENT = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + KILOGRAMS_INCREMENT);
    }
}
