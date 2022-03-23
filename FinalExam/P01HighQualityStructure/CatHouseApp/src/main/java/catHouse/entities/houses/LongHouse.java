package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;

public class LongHouse extends BaseHouse{

    public static final int CAPACITY = 30;

    public LongHouse(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addCat(Cat cat) {
        if (!(cat instanceof LonghairCat)){
            throw new IllegalCallerException(ConstantMessages.UNSUITABLE_HOUSE);
        }
        super.addCat(cat);
    }
}
