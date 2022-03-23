package farmville;

import org.junit.Assert;
import org.junit.Test;

import static farmville.Farm.*;
import static org.junit.Assert.*;

public class FarmvilleTests {
    private static final String FARM_NAME = "FarmName";
    private static final int FARM_CAPACITY = 10;


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    @Test(expected = NullPointerException.class)
    public void testIfSetEmptyNameThrowsException(){
        //arrange & act & assert
        Farm farm = new Farm(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfSetNegativeCapacityThrowsException(){
        //arrange & act & assert
        Farm farm = new Farm("Name", -1);
    }


    @Test
    public void testCtorWithValidArgumentsWillCreateValidFarm(){
        // Arrange & Act
        Farm farm = new Farm(FARM_NAME, FARM_CAPACITY);
        
        // Assert
        assertEquals(FARM_NAME, farm.getName());
        assertEquals(FARM_CAPACITY, farm.getCapacity());
    }

    @Test
    public void testAddingAnimalWillIncreaseAnimalsCount(){
        // Arrange
        Farm farm = new Farm(FARM_NAME, FARM_CAPACITY);
        Animal dog = new Animal("Dog", 10);

        int animalsInitialCount = farm.getCount();
        // Act
        farm.add(dog);

        // Assert
        assertEquals(animalsInitialCount+1, farm.getCount());
    }

    @Test
    public void testCreateAnimal(){
        // Arrange
        Animal dog = new Animal("Dog", 10);

        // Act
        String type = dog.getType();
        double energy = dog.getEnergy();
        // Assert
        assertEquals("Dog", type);
        assertEquals(energy, 10, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAnimalWillThrowExceptionIfFarmIsFull(){
        // Arrange
        Farm farm = new Farm(FARM_NAME, 1);

        // Act & Assert
        farm.add(new Animal("TestAnimal1", 1));
        farm.add(new Animal("TestAnimal2", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAnimalWillThrowExceptionIfDuplicatedAnimalExists(){
        // Arrange
        Farm farm = new Farm(FARM_NAME, 2);
           Animal animal =new Animal("TestAnimal1", 1);
        // Act & Assert
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testWillRemoveAnimalIfExists(){
        // Arrange
        Farm farm = new Farm(FARM_NAME, FARM_CAPACITY);
        Animal dog = new Animal("Dog", 10);
        farm.add(dog);
        // Act

        // Assert
        assertTrue(farm.remove("Dog"));
    }

    @Test
    public void testWontRemoveAnimalIfNotExists(){
        // Arrange
        Farm farm = new Farm(FARM_NAME, FARM_CAPACITY);
        Animal dog = new Animal("Dog", 10);
        farm.add(dog);
        // Act

        // Assert
        assertFalse(farm.remove("Cat"));
    }
    
}
