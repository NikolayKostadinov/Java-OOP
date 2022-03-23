package CounterStriker.models.guns;

import CounterStriker.common.ExceptionMessages;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0){
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public int fire() {
        if (this.bulletsCount < this.getBulletsPerShot()){
            return 0;
        }

        this.bulletsCount -= this.getBulletsPerShot();
        return this.getBulletsPerShot();
    }

    protected abstract int getBulletsPerShot();
}
