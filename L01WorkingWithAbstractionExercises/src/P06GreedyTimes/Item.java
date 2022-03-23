package P06GreedyTimes;

public class Item {
    private final String name;
    private final long quantity;
    private final ItemType type;

    public Item(String name, long quantity) {
        this.name = name;
        this.type = ItemType.parseItemType(name);
        this.quantity = quantity;
    }


    public ItemType getType() {
        return this.type;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
