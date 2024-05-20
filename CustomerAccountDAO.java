package Assignment6Controller;

import Assignment6Model.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountDAO {
    private int id;

    // Method to find accounts associated with a customer
    public List<BankAccount> findCustomerAccounts(int customerId) {
        List<BankAccount> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection
            connection = DatabaseConnection.getConnection();

            // Prepare SQL statement
            String sql = "SELECT * FROM Account WHERE customerId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);

            // Execute query
            resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                // Extract account details from the result set
                int accountId = resultSet.getInt("accountId");
                int accountNumber = resultSet.getInt("accountNumber");
                double balance = resultSet.getDouble("balance");
                String type = resultSet.getString("type");

                // Create BankAccount object
                BankAccount account = new BankAccount(id, balance);
                // Add the account to the list
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exception
        } finally {
            // Close the connection, statement, and result set
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return accounts;
    }
}

