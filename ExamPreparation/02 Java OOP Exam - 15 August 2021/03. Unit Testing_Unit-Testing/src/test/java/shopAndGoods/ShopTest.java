package shopAndGoods;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ShopTest {
    public static final String SHELVES_1 = "Shelves1";
    public static final String SHELVES_2 = "Shelves2";
    public static final Goods GOODS = new Goods("Toy", "ToyCode");
    public static final Goods OTHER_GOODS = new Goods("Doll", "DollCode");
    public static final String NOT_EXIST_SHELF = "NotExist";
    Shop shop;

    @Before
    public void Init() {
        shop = new Shop();
    }


    @Test
    public void ctorCreatesShop() {
        // Assert
        assertEquals(12, shop.getShelves().size());
    }

    @Test
    public void addGoodsAddGoodsToShelf() throws OperationNotSupportedException {
        // Act
        String result = this.shop.addGoods(SHELVES_1, GOODS);
        // Assert
        Goods goods = shop.getShelves().get(SHELVES_1);
        assertEquals(GOODS, goods);
        assertEquals(GOODS.getName(), goods.getName());
        assertEquals(String.format("Goods: %s is placed successfully!", GOODS.getGoodsCode()), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsThrowsErrorIfShelfDoesNotExist() throws OperationNotSupportedException {
        // Act
        shop.addGoods(NOT_EXIST_SHELF, GOODS);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsThrowsErrorIfShelfIsTaken() throws OperationNotSupportedException {
        // Act
        shop.addGoods(SHELVES_1, GOODS);
        shop.addGoods(SHELVES_1, GOODS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addGoodsThrowsErrorIfGoodsExists() throws OperationNotSupportedException {
        // Act
        shop.addGoods(SHELVES_1, GOODS);
        shop.addGoods(SHELVES_2, GOODS);
    }

    @Test
    public void removeGoodsWillRemoveGood() throws OperationNotSupportedException {
        // Arrange
        shop.addGoods(SHELVES_1, GOODS);
        // Act
        String result = shop.removeGoods(SHELVES_1, GOODS);
        // Assert
        Goods goods = shop.getShelves().get(SHELVES_1);
        assertNull(goods);
        assertEquals(String.format("Goods: %s is removed successfully!", GOODS.getGoodsCode()), result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsWillThrowExceptionIfShelfNotExists() throws OperationNotSupportedException {
        // Act & Assert
        shop.removeGoods(NOT_EXIST_SHELF, GOODS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsWillThrowExceptionIfGoodInShelfNotSame() throws OperationNotSupportedException {
        // Arrange
        shop.addGoods(SHELVES_1, GOODS);

        // Act & Assert
        shop.removeGoods(SHELVES_1, OTHER_GOODS);
    }
}