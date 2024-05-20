package Assignment6View;

import Assignment6Model.BankAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AccountList extends JFrame {
    private JList<BankAccount> accountJList;

    // Constructor
    public AccountList(List<BankAccount> accounts) {
        setTitle("Account List"); // Set frame title
        setSize(400, 300); // Set frame size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation

        JPanel panel = new JPanel(new BorderLayout()); // Panel for layout
        DefaultListModel<BankAccount> listModel = new DefaultListModel<>(); // List model for JList
        for (BankAccount account : accounts) {
            listModel.addElement(account); // Add accounts to the list model
        }

        accountJList = new JList<>(listModel); // Create JList with list model
        JScrollPane scrollPane = new JScrollPane(accountJList); // Scroll pane for JList
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton showDetailsButton = new JButton("Account Details"); // Button to show account details
        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountDetails(); // Action listener to show account details
            }
        });
        panel.add(showDetailsButton, BorderLayout.SOUTH); // Add button to panel

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // Default constructor
    public AccountList() {
        this(new ArrayList<>()); // Initialize with an empty list
    }

    // Method to show account details
    private void showAccountDetails() {
        BankAccount selectedAccount = accountJList.getSelectedValue(); // Get selected account from JList
        if (selectedAccount != null) {
            new AccountDetail(selectedAccount); // Show account details in AccountDetail frame
        } else {
            JOptionPane.showMessageDialog(this, "Please select an account to view details."); // Show message if no account is selected
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample list of BankAccount objects
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(123456, 1000.0));
        accounts.add(new BankAccount(654321, 1500.0));
        accounts.add(new BankAccount(789012, 2000.0));

        // Print each account
        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }

        // Create an instance of AccountList and pass the sample list
        SwingUtilities.invokeLater(() -> new AccountList(accounts));
    }
}