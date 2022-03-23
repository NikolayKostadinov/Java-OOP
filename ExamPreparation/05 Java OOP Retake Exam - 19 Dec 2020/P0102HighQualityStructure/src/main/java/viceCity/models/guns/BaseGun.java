package viceCity.models.guns;

import java.util.Objects;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(NAME_NULL);
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0)
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    public void setTotalBullets(int totalBullets) {
        if (totalBullets < 0)
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        this.totalBullets = totalBullets;
    }

    @Override
    public boolean canFire() {
        return this.totalBullets > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    public boolean isCanFire() {
        return canFire;
    }

    @Override
    public int fire() {
        int bulletsInBarrel = this.getBulletsPerBarrel() - getBulletsPerShot();
        if (bulletsInBarrel < 0) {
            setTotalBullets(getTotalBullets() - getBarrelCapacity());
            bulletsInBarrel = getBarrelCapacity() - getBulletsPerShot();
        }
        this.setBulletsPerBarrel(bulletsInBarrel);
        return getBulletsPerShot();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseGun baseGun = (BaseGun) o;
        return bulletsPerBarrel == baseGun.bulletsPerBarrel
                && totalBullets == baseGun.totalBullets
                && canFire == baseGun.canFire
                && name.equals(baseGun.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bulletsPerBarrel, totalBullets, canFire);
    }

    protected abstract int getBarrelCapacity();

    protected abstract int getBulletsPerShot();

}
