package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public static final int BULLETS_PER_SHOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    protected int getBulletsPerShot() {
        return BULLETS_PER_SHOT;
    }
}
