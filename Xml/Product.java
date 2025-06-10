import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Бүтээгдэхүүний мэдээллийг хадгалах класс.
 */
public class Product {
    private static final Logger logger = LogManager.getLogger(Product.class);
    
    private String name, category, madeIn, material, color, size;
    private int stock;
    private double price;

    /**
     * Бүтээгдэхүүний шинэ обьектыг үүсгэнэ.
     */
    public Product(String name, String category, String madeIn, String material, 
                  String color, String size, int stock, double price) {
        logger.debug("Шинэ бүтээгдэхүүн үүсгэж байна: {}", name);
        
        this.name = name;
        this.category = category;
        this.madeIn = madeIn;
        this.material = material;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.price = price;
        
        logger.info("Бүтээгдэхүүн амжилттай үүслээ: {} (Үлдэгдэл: {}, Үнэ: {})", name, stock, price);
    }

    public static List<Product> getProductsByCategory(String category, String subcategory) {
        logger.debug("Бүтээгдэхүүнүүдийг шүүж байна: {}/{}", category, subcategory);
        
        List<Product> products = new ArrayList<>();
        
        if (category.equals("Huvtsas")) {
            logger.trace("Хувцасны ангилалд харгалзах бүтээгдэхүүнүүдийг бэлтгэж байна");
            products.add(new Product("Tsamts", category + "/" + subcategory, "Mongol", "Noos", "Tsagaan", "M", 15, 45000));
            products.add(new Product("Hurem", category + "/" + subcategory, "Solongos", "Poliestr", "Har", "S", 10, 38000));
            products.add(new Product("Umd", category + "/" + subcategory, "Hytad", "Huvun", "Huh", "L", 20, 25000));
        } else {
            logger.trace("Гэр ахуйн барааны ангилалд харгалзах бүтээгдэхүүнүүдийг бэлтгэж байна");
            products.add(new Product("Shiree", "Ger ahuin baraa/Tavilga", "Hytad", "Mod", "Bor", "150x75", 5, 120000));
            products.add(new Product("Sandal", "Ger ahuin baraa/Tavilga", "Oros", "Metial", "Saaral", "Standart", 10, 50000));
            products.add(new Product("Toos sorogch", "Ger ahuin baraa/Tsahilgaan baraa", "German", "Huvantsar", "Har", "1.5L", 8, 185000));
        }
        
        logger.info("{} бүтээгдэхүүн олдлоо: {}/{}", products.size(), category, subcategory);
        return products;
    }

    /**
     * Бүтээгдэхүүний үлдэгдлийг тохируулна.
     */
    public void reduceStock(int qty) {
        logger.debug("'{}' бүтээгдэхүүний үлдэгдлийг {} ширхэгээр бууруулж байна", name, qty);
        
        if (qty <= 0) {
            logger.warn("Буруу тоо хэмжээ: {} (Бүтээгдэхүүн: {})", qty, name);
            throw new IllegalArgumentException("Тоо хэмжээ 0-ээс их байх ёстой");
        }
        
        if (qty > stock) {
            logger.error("Үлдэгдэл хүрэлцэхгүй байна! (Оролдсон: {}, Байгаа: {}, Бүтээгдэхүүн: {})", 
                        qty, stock, name);
            throw new IllegalStateException("Үлдэгдэл хүрэлцэхгүй байна");
        }
        
        stock -= qty;
        logger.info("Үлдэгдэл шинэчлэгдлээ. Бүтээгдэхүүн: {}, Хасагдсан: {}, Шинэ үлдэгдэл: {}", 
                   name, qty, stock);
    }

    // Getter methods with debug logging
    public String getName() { 
        logger.trace("getName() дуудагдаж байна: {}", name);
        return name; 
    }

    public String getCategory() { 
        logger.trace("getCategory() дуудагдаж байна: {}", category);
        return category; 
    }

    public String getMadeIn() {
        logger.trace("getMadeIn() дуудагдаж байна: {}", madeIn);
        return madeIn; 
    }

    public String getMaterial() {
        logger.trace("getMaterial() дуудагдаж байна: {}", material);
        return material; 
    }

    public String getColor() {
        logger.trace("getColor() дуудагдаж байна: {}", color);
        return color; 
    }

    public String getSize() {
        logger.trace("getSize() дуудагдаж байна: {}", size);
        return size; 
    }

    public int getStock() {
        logger.debug("getStock() дуудагдаж байна: {} (Үлдэгдэл: {})", name, stock);
        return stock; 
    }

    public double getPrice() {
        logger.debug("getPrice() дуудагдаж байна: {} (Үнэ: {})", name, price);
        return price; 
    }
}