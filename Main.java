import java.util.*;
public class Main {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-----Бүртгэл----- ");
        
        System.out.print("\nGmail: ");
        String email = scanner.nextLine();

        System.out.print("Нэр: ");
        String name = scanner.nextLine();

        System.out.print("Нууц үг: ");
        String password = scanner.nextLine();

        User user = new User(email, name, password);
        System.out.print("------------------------- ");
        System.out.println("\nБарааны төрлийг сонгоно уу:");
        System.out.println("1. Хувцас");
        System.out.println("2. Гэр ахуйн бараа");
        System.out.print("Төрөл №: ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("------------------------- ");
        
        String category = (categoryChoice == 1) ? "Хувцас" : "Гэр ахуйн бараа";
        String subcategory = "";

        if (category.equals("Хувцас")) {
            System.out.print("------------------------- ");
            
            System.out.println("\nДэд төрлийг сонгоно уу:");
            System.out.println("1. Эрэгтэй");
            System.out.println("2. Эмэгтэй");
            System.out.println("3. Хүүхэд");
            System.out.print("Дэд төрөл №: ");
            int subChoice = scanner.nextInt();
            scanner.nextLine();
            switch (subChoice) {
                case 1: subcategory = "Эрэгтэй"; break;
                case 2: subcategory = "Эмэгтэй"; break;
                case 3: subcategory = "Хүүхэд"; break;
                default: subcategory = "Бусад"; break;
            }
        }

        List<Product> productList = new ArrayList<>();
        if (category.equals("Хувцас")) {
            System.out.print("------------------------- ");
            
            productList.add(new Product("Цамц", category + "/" + subcategory, "Монгол", "Ноос", "Цагаан", "M", 15, 45000));
            productList.add(new Product("Юбка", category + "/" + subcategory, "Солонгос", "Полиэстр", "Хар", "S", 10, 38000));
            productList.add(new Product("Өмд", category + "/" + subcategory, "Хятад", "Хөвөн", "Хөх", "L", 20, 25000));
        } else {
            System.out.print("------------------------- ");
            
            productList.add(new Product("Ширээ", "Гэр ахуйн бараа/Тавилга", "Хятад", "Мод", "Бор", "150x75", 5, 120000));
            productList.add(new Product("Сандал", "Гэр ахуйн бараа/Тавилга", "Орос", "Металл", "Саарал", "Стандарт", 10, 50000));
            productList.add(new Product("Тоос сорогч", "Гэр ахуйн бараа/Цахилгаан бараа", "Герман", "Хуванцар", "Хар", "1.5L", 8, 185000));
        }

        System.out.println("\nСонгосон төрөлд байгаа бараанууд:");
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - ₮" + p.getPrice() + " (" + p.getStock() + " үлдсэн)");
        }
        
        System.out.print("------------------------- ");
        
        System.out.print("Худалдан авах барааны №: ");
        int productIndex = scanner.nextInt() - 1;

        if (productIndex < 0 || productIndex >= productList.size()) {
            System.out.print("------------------------- ");
            
            System.out.println("❌ Буруу сонголт. Програм зогсож байна.");
            return;
        }

        Product selectedProduct = productList.get(productIndex);
        
        System.out.print("------------------------- ");
        
        System.out.println("\nСонгосон бараа:");
        System.out.println("Нэр: " + selectedProduct.getName());
        System.out.println("Төрөл: " + selectedProduct.getCategory());
        System.out.println("Үйлдвэрлэсэн улс: " + selectedProduct.getMadeIn());
        System.out.println("Материал: " + selectedProduct.getMaterial());
        System.out.println("Өнгө: " + selectedProduct.getColor());
        System.out.println("Хэмжээ: " + selectedProduct.getSize());
        System.out.println("Үнэ: ₮" + selectedProduct.getPrice());
        System.out.println("Үлдэгдэл: " + selectedProduct.getStock());
        
        System.out.print("------------------------- ");
        
        System.out.print("Хэдийг авах вэ? ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        if (qty > selectedProduct.getStock()) {
            System.out.print("------------------------- ");
            
            System.out.println("❌ Нөөц хүрэлцэхгүй.");
            return;
        }

        CartItem item = new CartItem(selectedProduct, qty);
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(item);
        
        System.out.print("------------------------- ");
        
        System.out.print("Хүргэлтийн хаяг: ");
        String address = scanner.nextLine();
        
        System.out.print("------------------------- ");
        
        System.out.println("\nТөлбөрийн хэрэгсэл сонгоно уу:");
        System.out.println("1. Карт");
        System.out.println("2. Данс");
        System.out.print("Сонголт: ");
        int paymentOption = scanner.nextInt();
        scanner.nextLine();

        String paymentMethod = (paymentOption == 1) ? "Карт" : "Qpay";
        Order order = new Order(user, cartItems, address, paymentMethod);
        order.confirmOrder();
    }
}