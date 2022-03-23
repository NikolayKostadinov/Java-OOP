package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void losesHealthWhenAttacked() {
        // Act
        dummy.takeAttack(ATTACK_POINTS);

        // Assert
        assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCannotBeAttacked() {
        // Act & Assert
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void deadDummyCanGiveXP() {
        // Act
        int experience = deadDummy.giveExperience();
        // Assert
        assertEquals(DUMMY_EXPERIENCE, experience);
    }


    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        // Act
        int experience = dummy.giveExperience();
    }

}