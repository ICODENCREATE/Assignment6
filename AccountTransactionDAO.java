//Adharsh T

package Assignment6Controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTransactionDAO {
    // Method to find transactions for a given account ID
    public List<AccountTransactionDTO> findTransactions(int accountId) throws SQLException {
        List<AccountTransactionDTO> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction WHERE accountId = ?";

        // Using try-with-resources to automatically close resources
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            // Set the account ID parameter in the SQL query
            statement.setInt(1, accountId);
            // Execute the query
            try (ResultSet rs = statement.executeQuery()) {
                // Process the ResultSet
                while (rs.next()) {
                    int transactionId = rs.getInt("transactionId");
                    double amount = rs.getDouble("amount");
                    String date = rs.getString("date");
                    // Create AccountTransactionDTO objects and add them to the list
                    transactions.add(new AccountTransactionDTO(transactionId, accountId, amount, date));
                }
            }
        }

        return transactions;
    }
}