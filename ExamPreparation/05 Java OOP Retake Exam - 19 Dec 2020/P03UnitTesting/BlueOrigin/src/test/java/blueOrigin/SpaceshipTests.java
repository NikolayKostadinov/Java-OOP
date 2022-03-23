package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    public static final int CAPACITY = 10;
    public static final String SPACESHIP_NAME = "Spaceship";
    public static final int LESS_THAN_ZERO_CAPACITY = -1;
    public static final int OXYGEN_IN_PERCENTAGE = 100;
    public static final String ASTRONAUT_NAME = "Astronaut";
    private Spaceship spaceship;

    @Before
    public void onInit() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, CAPACITY);
    }

    @Test
    public void ctorCreatesAShip() {
        // Arrange & act
        this.spaceship = new Spaceship(SPACESHIP_NAME, CAPACITY);

        // Assert
        Assert.assertEquals(SPACESHIP_NAME, this.spaceship.getName());
    }

    @Test(expected = NullPointerException.class)
    public void ctorWillThrowExceptionIfNameIsNull() {
        new Spaceship(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void ctorWillThrowExceptionIfNameIsEmpty() {
        new Spaceship("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctorWillThrowExceptionIfCapacityLessThan0() {
        new Spaceship(ASTRONAUT_NAME, LESS_THAN_ZERO_CAPACITY);
    }

    @Test
    public void addAddsAstronautToShip() {
        // Arrange
        Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_IN_PERCENTAGE);

        // Act
        this.spaceship.add(astronaut);

        // Assert
        Assert.assertEquals(1, this.spaceship.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronautThatExistsWillThrowException() {
        // Arrange
        Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_IN_PERCENTAGE);

        // Act & Assert
        this.spaceship.add(astronaut);
        this.spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsExceptionWhenShipIsFull() {
        // Arrange
        Spaceship spaceship = new Spaceship(SPACESHIP_NAME, 1);
        Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_IN_PERCENTAGE);
        Astronaut astronaut1 = new Astronaut(ASTRONAUT_NAME + 1, OXYGEN_IN_PERCENTAGE);

        // Act & Assert
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void removeRemovesAstronautToShip() {
        // Arrange
        Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_IN_PERCENTAGE);
        this.spaceship.add(astronaut);

        // Act
        boolean result = this.spaceship.remove(astronaut.getName());
        boolean resultPesho = this.spaceship.remove("Pesho");

        // Assert
        Assert.assertEquals(0, this.spaceship.getCount());
        Assert.assertTrue(result);
        Assert.assertFalse(resultPesho);
    }

}
