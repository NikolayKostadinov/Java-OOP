package bakery.entities.tables;

import bakery.entities.tables.interfaces.Table;

public class InsideTable extends BaseTable {

    public static final double PRICE_PER_PERSON = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
