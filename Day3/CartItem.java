/**
 * Сагсанд нэмсэн бүтээгдэхүүний мэдээллийг хадгалах класс.
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * Сагсны шинэ обьектыг үүсгэнэ.
     *
     * @param product сагсанд нэмэх бүтээгдэхүүн
     * @param quantity бүтээгдэхүүний тоо ширхэг
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return сагсанд байгаа бүтээгдэхүүн
     */
    public Product getProduct() { return product; }

    /**
     * @return тухайн бүтээгдэхүүний тоо ширхэг
     */
    public int getQuantity() { return quantity; }

    /**
     * Тухайн бүтээгдэхүүний нийт үнийг тооцоолно (үнэ × тоо ширхэг).
     *
     * @return бүтээгдэхүүний нийт үнэ
     */
    public double getTotal() { return product.getPrice() * quantity; }
}