package Assignment6View;

import Assignment6Controller.AccountDAO;
import Assignment6Controller.AccountDTO;
import Assignment6Model.BankAccount;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AccountDetail extends JFrame {
    private static int id; // Static field for account ID (not used)
    private final JTextField balanceTextField; // Text field for balance
    private final BankAccount account; // BankAccount object associated with this AccountDetail frame

    // Constructor
    public AccountDetail(BankAccount account) {
        this.account = account;

        setTitle("Account Detail"); // Set frame title
        setSize(300, 200); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation

        JPanel panel = new JPanel(new GridLayout(3, 2)); // Panel for layout
        panel.add(new JLabel("Account Number:"));
        JTextField accountNumberTextField = new JTextField(account.getAccountNum()); // Text field for account number
        panel.add(accountNumberTextField);
        panel.add(new JLabel("Balance:"));
        balanceTextField = new JTextField(String.valueOf(account.getBalance())); // Text field for balance
        panel.add(balanceTextField);

        JButton saveButton = new JButton("Save"); // Save button
        saveButton.addActionListener(e -> {
            try {
                saveAccount(); // Save account details
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(saveButton);

        JButton closeButton = new JButton("Close"); // Close button
        closeButton.addActionListener(e -> dispose()); // Close the AccountDetail frame
        panel.add(closeButton);

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Method to save updated account details to the database
    private void saveAccount() throws SQLException {
        // Update the account object with the new balance
        AccountDTO accountDTO = new AccountDTO(
                account.getId(), // Assuming getId() returns the account ID
                account.getAccountNum(),
                Double.parseDouble(balanceTextField.getText()),
                account.getType(), // Assuming getType() returns the account type
                account.getCustNum() // Assuming getCustNum() returns the customer number
        );

        // Save the updated account to the database
        AccountDAO accountDAO = new AccountDAO();
        boolean success = accountDAO.updateAccount(accountDTO);

        // Show message based on success or failure
        if (success) {
            JOptionPane.showMessageDialog(this, "Account details updated successfully.");
            dispose(); // Close the AccountDetail frame
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample BankAccount object
        BankAccount account = new BankAccount(123456, 1000.0);

        // Create an instance of AccountDetail for the sample account and make it visible
        SwingUtilities.invokeLater(() -> new AccountDetail(account));
    }
}
