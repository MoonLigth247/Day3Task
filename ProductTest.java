import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {
  
    private void printTestHeader(String testName) {
        System.out.println("   " + testName);
    }
    
    private void printTestResult(boolean passed, String message) {
        System.out.println((passed ? " Амжилттай: " : " Алдаатай: ") + message);
    }
    
    @Test
    public void testProductCreation() {
        printTestHeader("Бүтээгдэхүүний");
        
        String name = "Цамц";
        String category = "Хувцас";
        String madeIn = "Хятад";
        String material = "Хөвөн";
        String color = "Улаан";
        String size = "M";
        int stock = 10;
        double price = 50000;
        
        System.out.println("Туршилтын өгөгдөл:");
        System.out.printf(" Нэр: %s\n Ангилал: %s\n Үйлдвэрлэсэн улс: %s\n", name, category, madeIn);
        System.out.printf(" Материал: %s\n Өнгө: %s\n Хэмжээ: %s\n", material, color, size);
        System.out.printf("Тоо ширхэг: %d\n Үнэ: %,.2f₮\n", stock, price);
        
        Product p = new Product(name, category, madeIn, material, color, size, stock, price);
        
        try {
            assertEquals(name, p.getName());
            printTestResult(true, "Нэр");
            
            assertEquals(category, p.getCategory());
            printTestResult(true, "Ангилал");
            
            assertEquals(madeIn, p.getMadeIn());
            printTestResult(true, "Үйлдвэрлэсэн улс");
            
            assertEquals(price, p.getPrice(), 0.001);
            printTestResult(true, "Үнэ");
            
            System.out.println("\n Бүх тест амжилттай ");
        } catch (AssertionError e) {
            printTestResult(false, e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void testReduceStock() {
        printTestHeader("Бараа хасах ");
        
        Product p = new Product("Цамц", "Хувцас", "Хятад", "Хөвөн", "Улаан", "M", 10, 50000);
        
        System.out.println("Анхны үлдэгдэл: " + p.getStock());
        System.out.println("Багасгах тоо хэмжээ: 3");
        
        p.reduceStock(3);
        int newStock = p.getStock();
        System.out.println("ӨӨрчлөгдсөн үлдэгдэл: " + newStock);
        
        try {
            assertEquals(7, newStock);
            printTestResult(true, "Тоо хэмжээ зөв багассан");
            System.out.println("\n Тест амжилттай ");
        } catch (AssertionError e) {
            printTestResult(false, "Тоо хэмжээ буруу: " + e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void testReduceStockToMinus() {
        printTestHeader("Бараа хасах ");
        
        Product p = new Product("Цамц", "Хувцас", "Хятад", "Хөвөн", "Улаан", "M", 10, 50000);
        
        System.out.println("Анхны үлдэгдэл: " + p.getStock());
        p.reduceStock(20);
        int newStock = p.getStock();
        System.out.println("Багасгах тоо : 20 ");
        if(newStock>=0){
            try {
                assertEquals(10, newStock);
                printTestResult(true, "Yлдэгдэл хүрэлцэхгүй байна ");
                System.out.println("\n Тест амжилттай ");
            } catch (AssertionError e) {
                printTestResult(false, "Тоо хэмжээ буруу: " + e.getMessage());
                throw e;
            }
    }
        else {
            System.out.println("\nБарааны үлдэгдэл хүрэлцэхгүй байна ");
        
    }
    }
}