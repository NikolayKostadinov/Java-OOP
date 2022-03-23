package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;

public class TableRepositoryImpl extends BaseRepository<Table>
        implements restaurant.repositories.interfaces.TableRepository<Table> {
    @Override
    public Table byNumber(int number) {
        return this.getAllEntities()
                .stream()
                .filter(t->t.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
