import java.util.Scanner;

public class WestminsterShoppingManagerConsole {
    public static void main(String[] args) {
        WestminsterShoppingManager manager = new WestminsterShoppingManager();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add a new product");
                System.out.println("2. Delete a product");
                System.out.println("3. Print product list");
                System.out.println("4. Save product list");
                System.out.println("5. Load product list");
                System.out.println("6. Open GUI");
                System.out.println("0. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter product type (1: Electronics, 2: Clothing): ");
                        int type = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        if (type == 1) {
                            System.out.println("Enter product details (ID, Name, Available Items, Price, Brand, Warranty): ");
                            String id = scanner.nextLine();
                            String name = scanner.nextLine();
                            int availableItems = scanner.nextInt();
                            double price = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            String brand = scanner.nextLine();
                            int warranty = scanner.nextInt();
                            Electronics electronics = new Electronics(id, name, availableItems, price, brand, warranty);
                            manager.addProduct(electronics);
                        } else if (type == 2) {
                            System.out.println("Enter product details (ID, Name, Available Items, Price, Size, Color): ");
                            String id = scanner.nextLine();
                            String name = scanner.nextLine();
                            int availableItems = scanner.nextInt();
                            double price = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            String size = scanner.nextLine();
                            String color = scanner.nextLine();
                            Clothing clothing = new Clothing(id, name, availableItems, price, size, color);
                            manager.addProduct(clothing);
                        }
                        break;
                    case 2:
                        System.out.println("Enter product ID to delete: ");
                        String productId = scanner.nextLine();
                        manager.deleteProduct(productId);
                        break;
                    case 3:
                        manager.printProductList();
                        break;
                    case 4:
                        manager.saveProductListToFile();
                        break;
                    case 5:
                        manager.loadProductListFromFile();
                        break;
                    case 6:
                        // Implement GUI opening logic here
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        }
    }
}
