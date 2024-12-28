import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    // Constructor
    public ShoppingCart() {
        products = new ArrayList<>();
    }

    // Methods
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Getters
    public List<Product> getProducts() {
        return products;
    }
}
