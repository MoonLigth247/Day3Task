import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CartItemTest {
    private Product testProduct;
    private CartItem cartItem;

    @Before
    public void setUp() {
        testProduct = new Product("iPhone 13", "Smartphone", "USA", "Aluminum", "Midnight", "6.1-inch", 10, 3500000.0);
        cartItem = new CartItem(testProduct, 2);
    }

    @Test
    public void testGetTotalWithSingleItem() {
        CartItem singleItem = new CartItem(testProduct, 1);
        double total = singleItem.getTotal();
        assertEquals(3500000.0, total, 0.001);
    }

    @Test
    public void testGetTotalWithZeroQuantity() {
        CartItem zeroItem = new CartItem(testProduct, 0);
        double total = zeroItem.getTotal();
        assertEquals(0.0, total, 0.001);
    }
    
    @Test
    public void testLargeQuantity() {
        CartItem largeQuantityItem = new CartItem(testProduct, Integer.MAX_VALUE);
        double total = largeQuantityItem.getTotal();
        assertEquals(3500000.0 * Integer.MAX_VALUE, total, 0.001);
    }

    @Test
    public void testFractionalPriceProduct() {
        Product cheapProduct = new Product("Pen", "Stationery", "Japan", "Plastic", "Blue", "One", 200, 1250.50);
        CartItem penItem = new CartItem(cheapProduct, 3);
        double total = penItem.getTotal();
        assertEquals(3751.50, total, 0.001);
    }
}
