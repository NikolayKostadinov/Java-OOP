package restaurant.repositories;

import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class BaseRepository<T> implements Repository<T> {
    private List<T> entities;

    public BaseRepository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<T> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(T entity) {
        this.entities.add(entity);
    }
}
