package P04RandomArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        for (int i = 0; !list.isEmpty(); i++) {
            System.out.println(list.getRandomElement());
        }

    }
}
