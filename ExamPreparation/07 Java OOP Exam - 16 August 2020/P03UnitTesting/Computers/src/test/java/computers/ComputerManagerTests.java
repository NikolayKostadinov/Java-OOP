package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    public static final String MANUFACTURER = "ASUS";
    public static final String MODEL = "ROG";
    public static final Computer COMPUTER = new Computer(MANUFACTURER, MODEL, 200);
    private static final String MANUFACTURER1 = "ACER";
    public static final String MODEL1 = "ASPIRE";
    public static final Computer COMPUTER1 = new Computer(MANUFACTURER1, MODEL1, 200);
    private ComputerManager computerManager;
    @Before
    public void onInit(){
        this.computerManager = new ComputerManager();
    }

    @Test
    public void addComputerAddsComputer(){
        // Arrange
        int computerCount = this.computerManager.getCount();

        // Act
        this.computerManager.addComputer(COMPUTER);

        //
        assertEquals(computerCount + 1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerThrowsExceptionIfAddExistComputer(){
        this.computerManager.addComputer(COMPUTER);
        this.computerManager.addComputer(COMPUTER);
    }

    @Test
    public void removeComputerRemovesComputer(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);
        int computerCount = this.computerManager.getCount();
        // Act
        Computer removedComputer = this.computerManager.removeComputer(MANUFACTURER, MODEL);
        //
        assertEquals(computerCount - 1, this.computerManager.getCount());
        assertEquals(COMPUTER, removedComputer);
    }

    @Test
    public void getComputerGetsComputer(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);

        // Act
        Computer removedComputer = this.computerManager.getComputer(MANUFACTURER, MODEL);

        // Assert
        assertEquals(COMPUTER, removedComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowExceptionIfComputerNotFound(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);

        // Act
        Computer removedComputer = this.computerManager.getComputer(MANUFACTURER, MODEL1);

        // Assert
        assertEquals(COMPUTER, removedComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowExceptionIfNullManufacturer(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);

        // Act
        Computer removedComputer = this.computerManager.getComputer(null, MODEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowExceptionIfNullModel(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);

        // Act
        Computer removedComputer = this.computerManager.getComputer(MANUFACTURER, null);
    }

    @Test
    public void getComputersByManufacturerReturnsCorrectRecords(){
        // Arrange
        this.computerManager.addComputer(COMPUTER);
        this.computerManager.addComputer(COMPUTER1);

        // Act
        List<Computer> computers = this.computerManager.getComputersByManufacturer(MANUFACTURER);

        // Assert
        assertEquals(1, computers.size());
        assertEquals(COMPUTER, computers.get(0));
    }



}