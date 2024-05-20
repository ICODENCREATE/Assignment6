package Assignment6Controller;

import Assignment6Model.BankCustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    // Method to find customers by city
    public static List<BankCustomer> findCustomersByCity(String city) {
        List<BankCustomer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customer WHERE city = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "username", "password");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set city parameter
            stmt.setString(1, city);
            // Execute query
            ResultSet rs = stmt.executeQuery();
            // Process result set
            while (rs.next()) {
                BankCustomer customer = new BankCustomer(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Method to update customer information
    public static void updateCustomer(BankCustomer customer) {
        String query = "UPDATE Customer SET name = ?, city = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "username", "password");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set parameters
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getCity());
            stmt.setInt(3, customer.getId());
            // Execute update
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






