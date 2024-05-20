// Adharsh T


package Assignment6Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    // Define SQL queries
    private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM accounts";
    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (account_num, balance, type, cust_num) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET balance = ?, type = ? WHERE id = ?";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?";

    // Method to retrieve all accounts from the database
    public List<AccountDTO> getAllAccounts() throws SQLException {
        List<AccountDTO> accounts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL_ACCOUNTS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Create AccountDTO objects from ResultSet
                AccountDTO account = new AccountDTO(
                        rs.getInt("id"),
                        rs.getInt("account_num"),
                        rs.getDouble("balance"),
                        rs.getString("type"),
                        rs.getInt("cust_num")
                );
                accounts.add(account);
            }
        } finally {
            // Close resources
            AccountDataConnection.closeResources(conn, stmt, rs);
        }

        return accounts;
    }

    // Method to create a new account in the database
    public boolean createAccount(AccountDTO account) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(INSERT_ACCOUNT);
            stmt.setInt(1, account.getAccountNum());
            stmt.setDouble(2, account.getBalance());
            stmt.setString(3, account.getType());
            stmt.setInt(4, account.getCustNum());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } finally {
            // Close resources
            AccountDataConnection.closeResources(conn, stmt);
        }
    }

    // Method to update an existing account in the database
    public boolean updateAccount(AccountDTO account) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(UPDATE_ACCOUNT);
            stmt.setDouble(1, account.getBalance());
            stmt.setString(2, account.getType());
            stmt.setInt(3, account.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } finally {
            // Close resources
            AccountDataConnection.closeResources(conn, stmt);
        }
    }

    // Method to delete an account from the database
    public boolean deleteAccount(int accountId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(DELETE_ACCOUNT);
            stmt.setInt(1, accountId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } finally {
            // Close resources
            AccountDataConnection.closeResources(conn, stmt);
        }
    }
}