package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = {1, 2, 3};
    public static final Integer[] ELEMENTS17 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final Integer[] ELEMENTS0 = {};

    private Database db;

    @Before
    public void Initialize() throws OperationNotSupportedException {
        db = new Database(ELEMENTS);
    }

    @Test
    public void ctorCreatesDatabase() {
        // Assert
        Integer[] result = db.getElements();
        assertArrayEquals(ELEMENTS, result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ctorThrowsExceptionIfElementsCountIs0() throws OperationNotSupportedException {
        // Arrange & Act & Assert
        new Database(ELEMENTS0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ctorThrowsExceptionIfElementsCountIs17() throws OperationNotSupportedException {
        // Arrange & Act & Assert
        new Database(ELEMENTS17);
    }

    @Test
    public void addAnElementAtTheNextFreeCell() throws OperationNotSupportedException {
        // Act
        db.add(10);
        // Assert
        Integer[] result = db.getElements();
        assertEquals(ELEMENTS.length + 1, result.length);
        assertEquals(Integer.valueOf(10), result[result.length-1] );
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementThrowsException() throws OperationNotSupportedException {
        // Act & Assert
        db.add(null);
    }

    @Test
    public void removeRemovesElementAtTheLastIndex() throws OperationNotSupportedException {
        // Act
        db.remove();

        // Assert
        Integer[] result = db.getElements();
        assertArrayEquals(Arrays.copyOf(ELEMENTS, ELEMENTS.length - 1), result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDbThrowsException() throws OperationNotSupportedException {
        // Arrange
        Database db = new Database(1);

        // Act & Assert
        db.remove();
        db.remove();
    }


}