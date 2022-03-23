package viceCity.models.guns;

public class Rifle extends BaseGun{

    public static final int BULLETS_PER_BARREL = 50;
    public static final int TOTAL_BULLETS = 500;
    public static final int BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    protected int getBulletsPerShot() {
        return BULLETS_PER_SHOT;
    }
}
