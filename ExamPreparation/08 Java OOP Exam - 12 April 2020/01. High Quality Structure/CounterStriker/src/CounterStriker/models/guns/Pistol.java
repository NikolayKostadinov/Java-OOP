package CounterStriker.models.guns;

public class Pistol extends GunImpl{

    public static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    protected int getBulletsPerShot() {
        return BULLETS_PER_SHOT;
    }
}
