package CounterStriker.models.players;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.isAlive = true;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty())
            throw new NullPointerException(INVALID_PLAYER_NAME);
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0)
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0)
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        this.armor = armor;
    }

    public void setGun(Gun gun) {
        if (gun == null)
            throw new NullPointerException(INVALID_GUN);
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public void takeDamage(int points) {
        if (armor > 0) {
            int result = this.armor - points;
            if (result >= 0) {
                this.armor = result;
                return;
            } else {
                points -= this.armor;
                this.armor = 0;
            }
        }

        if (points > 0 && health > 0) {
            health = (health - points) < 0 ? 0 : health - points;
        }

        this.isAlive = this.health > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(),this.getUsername())).append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.getHealth())).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.getArmor())).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.getGun().getName()));
        return sb.toString();
    }
}
