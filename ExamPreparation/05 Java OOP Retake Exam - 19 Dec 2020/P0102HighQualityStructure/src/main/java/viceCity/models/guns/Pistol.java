package viceCity.models.guns;

public class Pistol extends BaseGun {

    public static final int BULLETS_PER_BARREL = 10;
    public static final int BULLETS_PER_SHOT = 1;
    public static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }


    @Override
    protected int getBarrelCapacity() {
        return BULLETS_PER_BARREL;
    }

    @Override
    protected int getBulletsPerShot() {
        return BULLETS_PER_SHOT;
    }

}
