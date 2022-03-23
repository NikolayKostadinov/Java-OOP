package rpg_lab;

import java.util.Random;

public class Hero {

    private static final int INITIAL_EXPERIENCE = 0;
    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = INITIAL_EXPERIENCE;
        this.weapon = weapon;
    }


    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
