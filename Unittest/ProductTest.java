
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class ProductTest {
  
    
    @Test
    public void testProductCreation() {
        printTestHeader("Бүтээгдэхүүний үүсгэлтийн тест");
        
        String name = "Цамц";
        String category = "Хувцас";
        String madeIn = "Монгол";
        String material = "Ноос";
        String color = "Цагаан";
        String size = "M";
        int stock = 15;
        double price = 45000;
        
        
        Product p = new Product(name, category, madeIn, material, color, size, stock, price);
        
        try {
            assertEquals(name, p.getName());
            
            assertEquals(category, p.getCategory());
            
            assertEquals(madeIn, p.getMadeIn());
            
            assertEquals(material, p.getMaterial());
            
            assertEquals(color, p.getColor());
            
            assertEquals(size, p.getSize());
            
            assertEquals(stock, p.getStock());
            
            assertEquals(price, p.getPrice(), 0.001);
            
        } catch (AssertionError e) {
            printTestResult(false, e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void testReduceStockSuccess() {
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        
        p.reduceStock(5);
        int newStock = p.getStock();
        
        try {
            assertEquals(10, newStock);
        } catch (AssertionError e) {
            throw e;
        }
    }
    
    @Test
    public void testReduceStockNotEnough() {
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        
        p.reduceStock(20);
        int newStock = p.getStock();
        
        try {
            assertEquals(15, newStock);
        } catch (AssertionError e) {
            throw e;
        }
    }    
    
    @Test
    public void testProductToString() {
        
        Product p = new Product("Цамц", "Хувцас", "Монгол", "Ноос", "Цагаан", "M", 15, 45000);
        
        String expected = "Бүтээгдэхүүн: Цамц, Ангилал: Хувцас, Үнэ: 45,000.00₮";
        String actual = String.format("Бүтээгдэхүүн: %s, Ангилал: %s, Үнэ: %,.2f₮", 
                                    p.getName(), p.getCategory(), p.getPrice());
        
        try {
            assertEquals(expected, actual);
            System.out.println("\n Тест амжилттай");
        } catch (AssertionError e) {
            throw e;
        }
    }
}
