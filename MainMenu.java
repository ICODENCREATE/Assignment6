package Assignment6View;

import Assignment6Controller.CustomerDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame implements ActionListener {

    JButton searchButton, accountButton, transactionButton, showAllCustomersButton;

    MainMenu() {

        setLayout(null); // Set layout to null for absolute positioning

        // Create an icon for the frame
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/Banking.jpg")); // Load icon from resources
        Image image = icon.getImage().getScaledInstance(1000, 630, Image.SCALE_DEFAULT); // Scale the icon image
        ImageIcon scaledIcon = new ImageIcon(image); // Create ImageIcon with scaled image
        JLabel backgroundLabel = new JLabel(scaledIcon); // Create label to hold the background image
        backgroundLabel.setBounds(0, 0, 1100, 630); // Set bounds for background label
        add(backgroundLabel); // Add background label to the frame

        JLabel heading = new JLabel("Banking Application"); // Create heading label
        heading.setBounds(100, 100, 400, 40); // Set bounds for heading label
        heading.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font for heading label
        backgroundLabel.add(heading); // Add heading label to the background label

        // Button for searching customers
        searchButton = new JButton("Search Customer(s)");
        searchButton.setBounds(100, 200, 200, 40); // Set bounds for search button
        searchButton.addActionListener(this); // Add action listener to search button
        backgroundLabel.add(searchButton); // Add search button to the background label

        // Button for accessing accounts
        accountButton = new JButton("View Accounts");
        accountButton.setBounds(100, 250, 200, 40); // Set bounds for account button
        accountButton.addActionListener(this); // Add action listener to account button
        backgroundLabel.add(accountButton); // Add account button to the background label

        // Button for accessing transactions
        transactionButton = new JButton("View Transactions");
        transactionButton.setBounds(100, 300, 200, 40); // Set bounds for transaction button
        transactionButton.addActionListener(this); // Add action listener to transaction button
        backgroundLabel.add(transactionButton); // Add transaction button to the background label

        // Button for showing all customers
        showAllCustomersButton = new JButton("Show All Customers");
        showAllCustomersButton.setBounds(100, 350, 200, 40); // Set bounds for show all customers button
        showAllCustomersButton.addActionListener(this); // Add action listener to show all customers button
        backgroundLabel.add(showAllCustomersButton); // Add show all customers button to the background label

        setSize(1120, 630); // Set frame size
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setVisible(true); // Make the frame visible

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            // Open the CustomerSearch page
            new CustomerSearch();
            this.setVisible(false); // Hide the current page
        } else if (ae.getSource() == accountButton) {
            // Open the AccountList page
            new AccountList();
            this.setVisible(false); // Hide the current page
        } else if (ae.getSource() == transactionButton) {
            // Open the TransactionList page
            new TransactionList();
            this.setVisible(false); // Hide the current page
        } else if (ae.getSource() == showAllCustomersButton) {
            // Create dummy data for testing
            List<CustomerDTO> customers = List.of(
                    new CustomerDTO(1, "John Doe", "New York"),
                    new CustomerDTO(2, "Alice Smith", "Los Angeles")
            );
            // Create and display the CustomerList frame
            SwingUtilities.invokeLater(() -> new CustomerList(customers));
            this.setVisible(false); // Hide the current page
        }
    }

    public static void main(String[] args) {
        new MainMenu(); // Create an instance of MainMenu
    }
}