package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository<Gun>{

    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Gun model) {
        if (!this.models.contains(model)){
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models
                .stream()
                .filter(gun -> gun.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Gun> getModels() {
        return models;
    }
}
