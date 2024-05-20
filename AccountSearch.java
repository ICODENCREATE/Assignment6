package Assignment6View;

import Assignment6Controller.AccountTransactionDAO;
import Assignment6Controller.AccountTransactionDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AccountSearch extends JFrame {
    // Fields
    private JTextField accountIdTextField; // Text field for account ID
    private JButton searchButton; // Button to search transactions

    // Constructor
    public AccountSearch() {
        setTitle("Search Transactions"); // Set frame title
        setSize(400, 200); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation

        JPanel panel = new JPanel(new GridLayout(3, 2)); // Panel for layout
        panel.add(new JLabel("Account ID:")); // Label for account ID
        accountIdTextField = new JTextField(); // Text field for account ID
        panel.add(accountIdTextField);

        searchButton = new JButton("Search"); // Search button
        searchButton.addActionListener(new SearchButtonActionListener()); // Action listener for search button
        panel.add(searchButton);

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // ActionListener for search button
    private class SearchButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdText = accountIdTextField.getText(); // Get account ID text from text field
            if (accountIdText.isEmpty()) { // Check if account ID is empty
                JOptionPane.showMessageDialog(AccountSearch.this, "Please enter an account ID.", "Error", JOptionPane.ERROR_MESSAGE); // Show error message if empty
                return;
            }

            int accountId;
            try {
                accountId = Integer.parseInt(accountIdText); // Parse account ID to integer
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AccountSearch.this, "Invalid account ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE); // Show error message for invalid input
                return;
            }

            try {
                AccountTransactionDAO transactionDAO = new AccountTransactionDAO(); // Create AccountTransactionDAO instance
                List<AccountTransactionDTO> transactions = transactionDAO.findTransactions(accountId); // Find transactions for the given account ID
                if (transactions.isEmpty()) { // Check if transactions list is empty
                    JOptionPane.showMessageDialog(AccountSearch.this, "No transactions found for the given account ID.", "Info", JOptionPane.INFORMATION_MESSAGE); // Show info message if no transactions found
                } else {
                    TransactionList transactionListFrame = new TransactionList(transactions); // Create TransactionList frame with found transactions
                    transactionListFrame.setVisible(true); // Make TransactionList frame visible
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(AccountSearch.this, "Error retrieving transactions: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Show error message for SQL exception
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AccountSearch()); // Create instance of AccountSearch and make it visible
    }
}