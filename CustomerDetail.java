package Assignment6View;

import Assignment6Controller.CustomerAccountDAO;
import Assignment6Controller.CustomerDAO;
import Assignment6Controller.CustomerDTO;
import Assignment6Model.BankAccount;
import Assignment6Model.BankCustomer;
import Assignment6Model.CustomerAddress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerDetail extends JFrame {

    // Fields
    private JTextField firstNameTextField; // Text field for first name
    private JTextField lastNameTextField; // Text field for last name
    private JTextField emailTextField; // Text field for email
    private JTextField phoneTextField; // Text field for phone number
    private BankCustomer customer; // BankCustomer object representing the customer

    // Constructor using CustomerDTO object
    public CustomerDetail(CustomerDTO customerDTO) {
        // Convert the CustomerDTO object to a BankCustomer object
        BankCustomer customer = new BankCustomer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setCity(customerDTO.getCity());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(String.valueOf(customerDTO.getPhone()));

        // Call the constructor that accepts a BankCustomer object
        new CustomerDetail(customer);
    }

    // Constructor using BankCustomer object
    public CustomerDetail(BankCustomer customer) {
        this.customer = customer;

        setTitle("Customer Detail"); // Set frame title
        setSize(400, 200); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation

        JPanel panel = new JPanel(new GridLayout(6, 6)); // Panel for layout
        panel.add(new JLabel("First Name:")); // Label for first name
        firstNameTextField = new JTextField(customer.getFirstName()); // Text field for first name with current value
        panel.add(firstNameTextField);
        panel.add(new JLabel("Last Name:")); // Label for last name
        lastNameTextField = new JTextField(customer.getLastName()); // Text field for last name with current value
        panel.add(lastNameTextField);
        panel.add(new JLabel("Email:")); // Label for email
        emailTextField = new JTextField(customer.getEmail()); // Text field for email with current value
        panel.add(emailTextField);
        panel.add(new JLabel("Phone:")); // Label for phone number
        phoneTextField = new JTextField(customer.getPhone()); // Text field for phone number with current value
        panel.add(phoneTextField);

        JLabel addressLabel = new JLabel("Address:"); // Label for address
        panel.add(addressLabel);
        JTextArea addressTextArea = new JTextArea(); // Text area for address details
        CustomerAddress address = customer.getAddress(); // Get customer's address
        if (address != null) {
            addressTextArea.setText(address.toString()); // Set address details text
        }
        panel.add(addressTextArea);

        JButton updateButton = new JButton("Update "); // Button to update address
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open CustomerAddress GUI frame for address update
                new CustomerAddressFrame(customer.getAddress());
            }
        });
        panel.add(updateButton);

        JButton showAccountsButton = new JButton("Show Accounts"); // Button to show customer accounts
        showAccountsButton.addActionListener(e -> findCustomerAccounts(customer.getId()));
        panel.add(showAccountsButton);

        JButton saveButton = new JButton("Save"); // Button to save customer data
        saveButton.addActionListener(e -> {
            // Save the updated customer data
            saveCustomerData();
        });
        panel.add(saveButton);

        JButton closeButton = new JButton("Close"); // Button to close the frame
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the CustomerDetail frame
            }
        });
        panel.add(closeButton);

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Method to save customer data
    private void saveCustomerData() {
       // Retrieve updated information from text fields
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();

        // Update the customer object with the new information
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(String.valueOf(Integer.parseInt(phone)));

        //  Save the updated customer to the database
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.updateCustomer(customer);

        //  Show a confirmation message
        JOptionPane.showMessageDialog(this, "Customer Detail Updated Successfully.");

        // Close the CustomerDetail frame
        this.dispose();
    }

    // Method to find customer accounts
    private void findCustomerAccounts(int customerId) {
        CustomerAccountDAO accountDAO = new CustomerAccountDAO();
        List<BankAccount> accounts = accountDAO.findCustomerAccounts(customerId);
        new AccountList(accounts);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample BankCustomer object
        BankCustomer customer = new BankCustomer(1, "John", "Doe", "john.doe@example.com", "123-456-7890", new CustomerAddress("123 Main St", "City", "State", "12345"));
        // Create an instance of CustomerDetail for the sample customer and make it visible
        SwingUtilities.invokeLater(() -> new CustomerDetail(customer));
    }
}
