package Assignment6View;
import Assignment6Controller.CustomerDAO;
import Assignment6Controller.CustomerDTO;
import Assignment6Model.BankCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerSearch extends JFrame {
    private JTextField cityTextField;
    private JButton searchButton;

    // Constructor
    public CustomerSearch() {
        setTitle("Customer Search"); // Set frame title
        setSize(300, 200); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation

        JPanel panel = new JPanel(); // Panel for layout
        cityTextField = new JTextField(20); // Text field for entering city
        searchButton = new JButton("Search"); // Button to trigger search
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findCustomer(); // Action listener to find customer
            }
        });

        panel.add(new JLabel("Enter City:")); // Add label for city text field
        panel.add(cityTextField); // Add city text field
        panel.add(searchButton); // Add search button

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Method to find customer by city
    private void findCustomer() {
        String city = cityTextField.getText(); // Get city from text field
        List<BankCustomer> bankCustomers = CustomerDAO.findCustomersByCity(city); // Find customers by city

        // Convert BankCustomer objects to CustomerDTO objects
        List<CustomerDTO> customers = new ArrayList<>();
        for (BankCustomer bankCustomer : bankCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    bankCustomer.getId(),
                    bankCustomer.getName(),
                    bankCustomer.getCity()
            );
            customers.add(customerDTO); // Add converted customer to list
        }

        CustomerList customerList = new CustomerList(customers); // Create CustomerList frame with found customers
        customerList.setVisible(true); // Make CustomerList frame visible
    }

    // Main method for testing
    public static void main(String[] args) {
        new CustomerSearch(); // Create and display CustomerSearch frame
    }
}