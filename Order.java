import java.util.*;
class Order {
    private User user;
    private List<CartItem> items;
    private String shippingAddress;
    private String paymentMethod;

    public Order(User user, List<CartItem> items, String shippingAddress, String paymentMethod) {
        this.user = user;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(CartItem::getTotal).sum();
    }

    public void confirmOrder() {
        for (CartItem item : items) {
            item.getProduct().reduceStock(item.getQuantity());
        }
        System.out.println("\n✅ Захиалга баталгаажлаа!");
        System.out.println("Нийт үнэ: ₮" + calculateTotal());
        System.out.println("Төлбөрийн хэрэгсэл: " + paymentMethod);
        System.out.println("Хүргэлтийн хаяг: " + shippingAddress);
    }
}