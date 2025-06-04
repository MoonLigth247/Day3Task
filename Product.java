class Product {
    private String name, category, madeIn, material, color, size;
    private int stock;
    private double price;

    public Product(String name, String category, String madeIn, String material, String color, String size, int stock, double price) {
        this.name = name;
        this.category = category;
        this.madeIn = madeIn;
        this.material = material;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.price = price;
    }

    public void reduceStock(int qty) {
        if (qty <= stock) 
        stock -= qty;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getMadeIn() { return madeIn; }
    public String getMaterial() { return material; }
    public String getColor() { return color; }
    public String getSize() { return size; }
    public int getStock() { return stock; }
    public double getPrice() { return price; }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return product.getPrice() * quantity; }
}