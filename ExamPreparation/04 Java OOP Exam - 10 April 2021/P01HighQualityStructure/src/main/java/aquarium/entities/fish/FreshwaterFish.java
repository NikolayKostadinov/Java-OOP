package aquarium.entities.fish;

/**
 * Can only live in FreshwaterAquarium!
 */
public class FreshwaterFish extends BaseFish{

    public static final int INITIAL_SIZE = 3;
    public static final int SIZE_INCREMENT = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + SIZE_INCREMENT);
    }
}
