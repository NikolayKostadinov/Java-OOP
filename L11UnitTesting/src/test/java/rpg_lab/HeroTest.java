package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {
    private static final String HERO_NAME = "Java";
    private static final int TARGET_XP = 10;

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
    // Arrange
        Weapon stubWeapon = mock(Weapon.class);

        Target stubTarget = mock(Target.class);
        when(stubTarget.isDead()).thenReturn(true);
        when(stubTarget.giveExperience()).thenReturn(TARGET_XP);

    // Act
        Hero hero = new Hero(HERO_NAME, stubWeapon);
        hero.attack(stubTarget);
        
    // Assert
        assertEquals(TARGET_XP, hero.getExperience());
    }
}