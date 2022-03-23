package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    public static final String AQUARIUM_NAME = "Aquarium1";
    public static final int CAPACITY = 10;
    public static final String FISH_NAME = "Fish1";
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    private Aquarium aquarium;

    @Before
    public void onInit() {
        this.aquarium = new Aquarium(AQUARIUM_NAME, CAPACITY);
    }

    @Test
    public void ctorWillCreateNeqInstance() {
        // Arrange & Act


        // Assert
        assertEquals(AQUARIUM_NAME, aquarium.getName());
        assertEquals(CAPACITY, aquarium.getCapacity());
    }


    @Test(expected = NullPointerException.class)
    public void ctorWillThrowExceptionIfNameIsNull() {
        // Arrange & Act & Assert
        new Aquarium(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void ctorWillThrowExceptionIfNameIsEmpty() {
        // Arrange & Act & Assert
        new Aquarium("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctorWillThrowExceptionIfCapacityIsLessThan0() {
        // Arrange & Act & Assert
        new Aquarium(AQUARIUM_NAME, -1);
    }

    @Test
    public void addFishAddsFishToAquarium() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        int initialFishCount = this.aquarium.getCount();
        // Act
        this.aquarium.add(fish);

        // Assert
        assertEquals(initialFishCount + 1, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFishThrowsExceptionIfCapacityIsExceeded() {
        // Arrange
        this.aquarium = new Aquarium(AQUARIUM_NAME, 1);
        Fish fish = new Fish(FISH_NAME);
        Fish fish1 = new Fish(FISH_NAME + 1);
        int initialFishCount = this.aquarium.getCount();

        // Act & Assert
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
    }

    @Test
    public void removeFishRemovesFishFromAquarium() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        int initialFishCount = this.aquarium.getCount();
        this.aquarium.add(fish);
        // Act
        this.aquarium.remove(FISH_NAME);
        // Assert
        assertEquals(0, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFishThrowsExceptionIfFishDoesNotExists() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        int initialFishCount = this.aquarium.getCount();
        this.aquarium.add(fish);
        // Act & Assert
        this.aquarium.remove(FISH_NAME + 1);
    }

    @Test
    public void sellFishSellFishFromAquarium() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        int initialFishCount = this.aquarium.getCount();
        this.aquarium.add(fish);
        // Act
        Fish fishSold = this.aquarium.sellFish(FISH_NAME);
        // Assert
        assertEquals(fish.getName(), fishSold.getName());
        assertEquals(fish.isAvailable(), false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFishThrowsExceptionIfFishDoesNotExists() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        int initialFishCount = this.aquarium.getCount();
        this.aquarium.add(fish);
        // Act & Assert
        this.aquarium.sellFish(FISH_NAME + 1);
    }

    @Test
    public void reportReturnMessage() {
        // Arrange
        Fish fish = new Fish(FISH_NAME);
        Fish fish1 = new Fish(FISH_NAME + 1);
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
        String expectedMessage =
                String.format("Fish available at %s: %s", AQUARIUM_NAME, FISH_NAME + ", " + FISH_NAME + 1);
        // Act
        String message = this.aquarium.report();

        // Assert
        assertEquals(expectedMessage, message);
    }

}

