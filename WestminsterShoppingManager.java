import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WestminsterShoppingManager {
    private List<Product> productList;

    // Constructor
    public WestminsterShoppingManager() {
        productList = new ArrayList<>();
    }

    // Methods
    public void addProduct(Product product) {
        if (productList.size() < 50) {
            productList.add(product);
        } else {
            System.out.println("Cannot add more than 50 products.");
        }
    }

    public void deleteProduct(String productId) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println("Deleted product: " + productToRemove.getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void printProductList() {
        Collections.sort(productList, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void saveProductListToFile() {
        // Implementation to save to a file
    }

    public void loadProductListFromFile() {
        // Implementation to load from a file
    }

    public List<Product> getProductList() {
        return productList;
    }
}
