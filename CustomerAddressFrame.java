package Assignment6View;

import Assignment6Model.CustomerAddress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAddressFrame extends JFrame {
    // Fields
    private JTextField streetTextField; // Text field for street
    private JTextField cityTextField; // Text field for city
    private JTextField stateTextField; // Text field for state
    private JTextField zipTextField; // Text field for ZIP code
    private CustomerAddress address; // Customer address object

    // Constructor
    public CustomerAddressFrame(CustomerAddress address) {
        this.address = address;

        setTitle("Update Address"); // Set frame title
        setSize(300, 200); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation

        JPanel panel = new JPanel(new GridLayout(2, 2)); // Panel for layout
        panel.add(new JLabel("Street:")); // Label for street
        streetTextField = new JTextField(address.getStreetName()); // Text field for street with current value
        panel.add(streetTextField);
        panel.add(new JLabel("City:")); // Label for city
        cityTextField = new JTextField(address.getCity()); // Text field for city with current value
        panel.add(cityTextField);
        panel.add(new JLabel("State:")); // Label for state
        stateTextField = new JTextField(address.getState()); // Text field for state with current value
        panel.add(stateTextField);
        panel.add(new JLabel("ZIP Code:")); // Label for ZIP code
        zipTextField = new JTextField(String.valueOf(address.getZip())); // Text field for ZIP code with current value
        panel.add(zipTextField);

        JButton saveButton = new JButton("Save"); // Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCustomerAddress(); // Action listener to save customer address
            }
        });
        panel.add(saveButton);

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Method to save customer address
    private void saveCustomerAddress() {
        // Update the address object with the new details
        address.setStreetName(streetTextField.getText());
        address.setCity(cityTextField.getText());
        address.setState(stateTextField.getText());
        address.setZip(Integer.parseInt(zipTextField.getText()));

        // Show a confirmation message
        JOptionPane.showMessageDialog(this, "Address updated successfully.");

        // Close the frame after saving
        this.dispose();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample CustomerAddress object
        CustomerAddress address = new CustomerAddress("123 Main St", "City", "State", "12345");

        // Create an instance of CustomerAddressFrame and make it visible
        SwingUtilities.invokeLater(() -> new CustomerAddressFrame(address));
    }
}