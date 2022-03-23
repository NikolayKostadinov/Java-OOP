package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints = 0;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        this.name = name;
    }

    protected void setLifePoints(int lifePoints) {
        if (lifePoints < 0)
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints -= points;
        if (this.lifePoints < 0) this.lifePoints = 0;
    }

    public void setGunRepository(Repository<Gun> gunRepository) {
        this.gunRepository = gunRepository;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }
}
