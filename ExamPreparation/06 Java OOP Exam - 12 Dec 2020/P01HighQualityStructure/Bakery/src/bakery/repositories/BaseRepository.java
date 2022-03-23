package bakery.repositories;

import bakery.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

public class BaseRepository <T> implements Repository<T> {
   private Collection<T> models;

    public BaseRepository(Collection<T> models) {
        this.models = models;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }
}
