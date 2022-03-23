package restaurant.entities.tables;

import restaurant.entities.tables.interfaces.Table;

public interface TableFactory {
    Table getInstance(String type, int tableNumber, int capacity);

}
