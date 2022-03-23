package restaurant.entities.tables;

import restaurant.entities.tables.interfaces.Table;

public class TableFactoryImpl implements TableFactory {
    @Override
    public Table getInstance(String type, int tableNumber, int capacity) {
        switch (type) {
            case "InGarden":
                return new InGarden(tableNumber, capacity);
            case "Indoors":
                return new Indoors(tableNumber, capacity);
            default:
                return null;
        }
    }
}
