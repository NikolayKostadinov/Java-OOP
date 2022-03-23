package cats;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HouseTests {
    public static final String HOUSE_NAME = "HouseName";

    public static final int CAPACITY = 10;
    public static final String NAME = "Maca";
    public static final String NO_SUCH_CAT = "No Such Cat";
    private static final String NAME1 = "Kotarana";

    @Test
    public void ctorWillCreateHouse() {
        //Arrange & Act
        House house = new House(HOUSE_NAME, CAPACITY);

        //Assert
        assertEquals(HOUSE_NAME, house.getName());
        assertEquals(CAPACITY, house.getCapacity());
        assertEquals(0, house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void setNameWillThrowExceptionIfNameIsNull() {
        //Arrange & Act &Assert
        House house = new House(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void setNameWillThrowExceptionIfNameIsEmpty() {
        //Arrange & Act &Assert
        House house = new House("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityWillThrowExceptionIfCapacityIsLessThan0() {
        //Arrange & Act &Assert
        House house = new House(HOUSE_NAME, -1);
    }

    @Test
    public void addCatAddsACat(){
        //Arrange
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);

        //Act
        house.addCat(cat);

        //Assert
        assertEquals(1, house.getCount());
        assertEquals(cat, house.catForSale(NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCatThrowsExceptionIfHouseIsFull(){
        //Arrange
        House house = new House(HOUSE_NAME, 1);
        Cat cat = new Cat(NAME);

        //Act
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void removeCatRemovesACat(){
        //Arrange
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);
        house.addCat(cat);

        //Act
        house.removeCat(NAME);

        //Assert
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatThrowsExceptionIfCatDoesNotExist(){
        //Arrange
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);
        house.addCat(cat);

        //Act & Assert
        house.removeCat(NO_SUCH_CAT);
    }

    @Test
    public void catForSaleReturnCatForSale(){
        //Arrange
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);
        house.addCat(cat);

        //Act
        Cat catForSale = house.catForSale(NAME);

        // Assert
        assertEquals(cat, catForSale);
        assertTrue(!catForSale.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleThrowsExceptionIfCatNotFoud(){
        //Arrange
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);
        house.addCat(cat);

        //Act
        Cat catForSale = house.catForSale(NO_SUCH_CAT);

    }

    @Test
    public void statisticsWillReturnCorrectMessage(){
        //Arrange
        String expectedMessage = String.format("The cat %s is in the house %s!", String.join(", ", new String[]{NAME, NAME1}), HOUSE_NAME);
        House house = new House(HOUSE_NAME, CAPACITY);
        Cat cat = new Cat(NAME);
        house.addCat(cat);
        Cat cat1 = new Cat(NAME1);
        house.addCat(cat1);

        //Act
        String result = house.statistics();

        //Assert
        assertEquals(expectedMessage, result);
    }
}
