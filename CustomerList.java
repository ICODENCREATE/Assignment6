package Assignment6View;

import Assignment6Controller.CustomerDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerList extends JFrame {
    private JList<CustomerDTO> customerJList;

    // Constructor
    public CustomerList(List<CustomerDTO> customers) {
        setTitle("Customer List"); // Set frame title
        setSize(600, 400); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation

        JPanel panel = new JPanel(new BorderLayout()); // Panel for layout
        DefaultListModel<CustomerDTO> listModel = new DefaultListModel<>();
        for (CustomerDTO customer : customers) {
            listModel.addElement(customer);
        }

        customerJList = new JList<>(listModel); // JList to display customers
        JScrollPane scrollPane = new JScrollPane(customerJList); // Scroll pane for JList
        panel.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to panel

        JButton showDetailButton = new JButton("Show Detail"); // Button to show customer detail
        showDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomerDetail(); // Action listener to show customer detail
            }
        });
        panel.add(showDetailButton, BorderLayout.SOUTH); // Add button to panel

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Method to show customer detail
    private void showCustomerDetail() {
        CustomerDTO selectedCustomer = customerJList.getSelectedValue(); // Get selected customer
        if (selectedCustomer != null) {
            // Open CustomerDetail frame with selected customer
            new CustomerDetail(selectedCustomer);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer."); // Show message if no customer is selected
        }
    }

    // Example method to find a customer by name
    public CustomerDTO findCustomerByName(String name) {
        for (int i = 0; i < customerJList.getModel().getSize(); i++) {
            CustomerDTO customer = customerJList.getModel().getElementAt(i);
            if (customer.getName().equals(name)) {
                return customer; // Return customer if found
            }
        }
        return null; // Return null if not found
    }

    // Main method for testing
    public static void main(String[] args) {
        // Dummy data for testing
        List<CustomerDTO> customers = List.of(
                new CustomerDTO(1, "John Doe", "New York", "john@gmail.com", 1234567890),
                new CustomerDTO(2, "Adharsh Thiagarajan", "Los Angeles", "adharsh@gmail.com", 456321)
        );

        // Create and display the CustomerList frame
        SwingUtilities.invokeLater(() -> new CustomerList(customers));
    }
}