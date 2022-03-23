package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {

    public static final String TEST_PLAYER = "TestPlayer";
    public static final int HEALTH = 10;
    public static final int DAMAGE = 1;
    private static final int DAMAGE11 = 11;
    public static final String COLT = "Colt";

    private Player player;


    @Before
    public void onInit(){
        this.player = new Player(TEST_PLAYER, HEALTH);
    }

    @Test
    public void ctorWillCreatePlayer(){
        // Arrange & Act
        var player = new Player(TEST_PLAYER, HEALTH);

        // Assert
        assertEquals(TEST_PLAYER, player.getUsername());
        assertEquals(HEALTH, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void setUsernameWillThrowExceptionIfUserNameIsNull(){
        new Player(null, HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void setUsernameWillThrowExceptionIfUserNameIsEmpty(){
        new Player("", HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUsernameWillThrowExceptionIfHealthIsLessThan0(){
        new Player(TEST_PLAYER, -1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getGunsReturnsUnmodifiableCollection(){
        // Arrange
        List<Gun> guns = this.player.getGuns();
        // Act & Assert
        guns.add(new Gun("name", 10));
    }

    @Test
    public void takeDamageWillDecreasePlayerHealth(){
        // act
        this.player.takeDamage(DAMAGE);
        // Assert
        assertEquals(HEALTH-DAMAGE, this.player.getHealth());
    }

    @Test
    public void takeDamageWillDecreaseTo0IfPointsAreMoreThenHealth(){
        // act
        this.player.takeDamage(DAMAGE11);
        // Assert
        assertEquals(0, this.player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageWillThrowExceptionIfHealthIsLessThanOrEqualsTo0(){
        // arrange
        this.player.takeDamage(HEALTH);

        // act
        this.player.takeDamage(1);
    }

    @Test
    public void addGunAddsAGun(){
        // Arrange
        Gun gun = new Gun(COLT, 1);

        //Act
        this.player.addGun(gun);
        Gun createdGun = this.player.getGun(COLT);
        // Assert
        assertEquals(1, this.player.getGuns().size());
        assertEquals(gun, createdGun);

    }

    @Test(expected = NullPointerException.class)
    public void addGunThrowsExceptionIfGunIsNull(){
        // Arrange
        Gun gun = null;

        //Act & Assert
        this.player.addGun(gun);
    }

    @Test
    public void removeGunRemovesAGun(){
        // Arrange
        Gun gun = new Gun(COLT, 1);
        this.player.addGun(gun);

        // Assert
        assertTrue(this.player.removeGun(gun));
        assertEquals(0, this.player.getGuns().size());
    }

}
