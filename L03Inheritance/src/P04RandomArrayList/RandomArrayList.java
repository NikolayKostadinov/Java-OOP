package P04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    Random rnd = new Random();
    public Object getRandomElement(){
        int index = this.rnd.nextInt(this.size());
        return this.remove(index);
    }
}
