package P06GreedyTimes;

import input.Reader;
import output.ConsolePrinter;

public class GreedySystem {
    private final Bag bag;

    public GreedySystem() {
        long bagCapacity = Long.parseLong(Reader.readLine());
        this.bag = new Bag(bagCapacity);
    }

    public void start() {
        String[] safe = Reader.readStringArray("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String typeName = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            Item item = new Item(typeName, quantity);
            bag.addItem(item);
        }

        ConsolePrinter.printLine(bag.toString());
    }
}
