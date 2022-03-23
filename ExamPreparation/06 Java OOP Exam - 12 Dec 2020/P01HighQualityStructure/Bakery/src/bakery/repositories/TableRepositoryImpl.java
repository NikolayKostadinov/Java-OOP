package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;

public class TableRepositoryImpl<T extends Table> extends BaseRepository<T> implements TableRepository<T> {
    public TableRepositoryImpl() {
        super(new ArrayList<>());
    }

    @Override
    public T getByNumber(int number) {
        return this.getAll().stream().filter(t->t.getTableNumber() == number).findFirst().orElse(null);
    }
}
