package Assignment6View;

import Assignment6Controller.AccountTransactionDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionList extends JFrame {
    public TransactionList(List<AccountTransactionDTO> transactions) {
        setTitle("Transaction List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout()); // Create panel with BorderLayout
        DefaultListModel<AccountTransactionDTO> listModel = new DefaultListModel<>();
        for (AccountTransactionDTO transaction : transactions) {
            listModel.addElement(transaction); // Add transactions to the list model
        }

        JList<AccountTransactionDTO> transactionJList = new JList<>(listModel); // Create JList with list model
        panel.add(new JScrollPane(transactionJList), BorderLayout.CENTER); // Add JList to a scroll pane and to the center of the panel

        add(panel); // Add panel to the frame
        setVisible(true); // Make the frame visible
    }

    public TransactionList() {
        this(new ArrayList<>()); // Initialize with an empty list
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Sample data for testing
            List<AccountTransactionDTO> sampleTransactions = new ArrayList<>();
            sampleTransactions.add(new AccountTransactionDTO(1, 123456, 100.0, "2023-01-01"));
            sampleTransactions.add(new AccountTransactionDTO(2, 123456, 200.0, "2023-02-01"));
            sampleTransactions.add(new AccountTransactionDTO(3, 123456, 150.0, "2023-03-01"));
            sampleTransactions.add(new AccountTransactionDTO(4, 123456, 50.0, "2023-04-01"));

            // Create and display the TransactionList GUI
            new TransactionList(sampleTransactions);
        });
    }
}