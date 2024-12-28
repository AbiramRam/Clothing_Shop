import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShoppingCartGUI extends JFrame {
    public ShoppingCartGUI(ShoppingCart cart) {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        List<Product> products = cart.getProducts();
        String[] columnNames = {"ID", "Name", "Price"};
        Object[][] data = new Object[products.size()][3];
        for (int i = 0; i < products.size(); i++) {
            data[i][0] = products.get(i).getProductId();
            data[i][1] = products.get(i).getProductName();
            data[i][2] = products.get(i).getPrice();
        }

        JTable cartTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(cartTable);
        add(scrollPane, BorderLayout.CENTER);

        double totalCost = cart.calculateTotalCost();
        JLabel totalLabel = new JLabel("Total: $" + totalCost);
        add(totalLabel, BorderLayout.SOUTH);
    }
}
