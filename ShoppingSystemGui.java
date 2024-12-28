import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingSystemGui extends JFrame {
    private WestminsterShoppingManager manager;
    private ShoppingCart cart;
    private JTable productTable;

    public ShoppingSystemGui() {
        manager = new WestminsterShoppingManager();
        cart = new ShoppingCart();
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Shopping System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the table for products
        String[] columnNames = {"ID", "Name", "Price", "Available", "Type"};
        Object[][] data = {}; // Load data from manager
        productTable = new JTable(data, columnNames);

        // Populate product table with data from manager
        // TODO: Add logic to load data into the table

        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add product details panel
        JPanel detailsPanel = new JPanel(new GridLayout(5, 2));
        JTextField productIdField = new JTextField();
        JTextField productNameField = new JTextField();
        JTextField productPriceField = new JTextField();
        JTextField productAvailableField = new JTextField();
        JTextField productTypeField = new JTextField();
        detailsPanel.add(new JLabel("Product ID:"));
        detailsPanel.add(productIdField);
        detailsPanel.add(new JLabel("Product Name:"));
        detailsPanel.add(productNameField);
        detailsPanel.add(new JLabel("Product Price:"));
        detailsPanel.add(productPriceField);
        detailsPanel.add(new JLabel("Product Available:"));
        detailsPanel.add(productAvailableField);
        detailsPanel.add(new JLabel("Product Type:"));
        detailsPanel.add(productTypeField);

        add(detailsPanel, BorderLayout.SOUTH);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add to Cart");
        JButton viewCartButton = new JButton("View Cart");
        buttonPanel.add(addButton);
        buttonPanel.add(viewCartButton);

        add(buttonPanel, BorderLayout.NORTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add selected product to cart
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String productId = (String) productTable.getValueAt(selectedRow, 0);
                    // Find product by ID in manager and add to cart
                    for (Product product : manager.getProductList()) {
                        if (product.getProductId().equals(productId)) {
                            cart.addProduct(product);
                            break;
                        }
                    }
                }
            }
        });

        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display cart contents
                new ShoppingCartGUI(cart).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new ShoppingSystemGui().setVisible(true);
    }
}
