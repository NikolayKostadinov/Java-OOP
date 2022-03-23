package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.ShorthairCat;

public class ShortHouse extends BaseHouse{

    public static final int CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addCat(Cat cat) {
        if (!(cat instanceof ShorthairCat)){
            throw new IllegalCallerException(ConstantMessages.UNSUITABLE_HOUSE);
        }
        super.addCat(cat);
    }
}
