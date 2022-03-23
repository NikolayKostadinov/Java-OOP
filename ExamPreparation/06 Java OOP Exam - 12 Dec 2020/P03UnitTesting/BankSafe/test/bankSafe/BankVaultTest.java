package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    public static final String ITEM_ID = "ItemId";
    public static final String ITEM_ID1 = "ItemId1";
    public static final Item ITEM = new Item("Owner", ITEM_ID);
    public static final Item ITEM1 = new Item("Owner1", ITEM_ID1);
    public static final String CELL = "A1";
    public static final String CELL1 = "B1";

    public BankVault bankVault;

    @Before
    public void onInit() {
        this.bankVault = new BankVault();
    }

    @Test
    public void ctorWillCreate12EmptyCells(){
        // Assert
        assertEquals(12, this.bankVault.getVaultCells().size());
        assertTrue(this.bankVault.getVaultCells().entrySet().stream().allMatch(e->e.getValue() == null));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getVaultCellsReturnsUnmodifiableMap(){
        this.bankVault.getVaultCells().put("NewCell", ITEM);
    }

    @Test
    public void addItemAddsItemToCell() throws OperationNotSupportedException {
        // Arrange
        String expectedMessage = String.format("Item:%s saved successfully!", ITEM_ID);

        //Act
        String message = this.bankVault.addItem(CELL, ITEM);

        // assert
        assertEquals(expectedMessage, message);
        assertEquals(ITEM, this.bankVault.getVaultCells().get(CELL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemWillThrowExceptionIfCellDoesNotExist() throws OperationNotSupportedException {
        this.bankVault.addItem("NotExistCell", ITEM);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addItemWillThrowExceptionIfCellIsNotEmpty() throws OperationNotSupportedException {
        this.bankVault.addItem(CELL, ITEM);
        this.bankVault.addItem(CELL, ITEM1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addItemWillThrowExceptionIfItemIsAlreadyInCell() throws OperationNotSupportedException {
        this.bankVault.addItem(CELL, ITEM);
        this.bankVault.addItem(CELL1, ITEM);
    }

    @Test
    public void removeItemWillRemoveTheItem() throws OperationNotSupportedException {
        // Arrange
        this.bankVault.addItem(CELL, ITEM);
        String expectedMessage = String.format("Remove item:%s successfully!", ITEM_ID);

        // Act
        String message = this.bankVault.removeItem(CELL, ITEM);

        // Assert
        assertEquals(expectedMessage, message);
        assertNull(this.bankVault.getVaultCells().get(CELL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemThrowsExceptionWhenCellDoesNotExist(){
        this.bankVault.removeItem("NotExistCell", ITEM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemThrowsExceptionWhenItemDoesNotExist(){
        this.bankVault.removeItem(CELL, ITEM);
    }

}