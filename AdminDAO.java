// Adharsh T

package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;


public class AdminDAO {
    // Connection object for database access
    static Connection connection = null;
    // Prepared statement for executing SQL queries
    PreparedStatement pStatement;
    // Result set for storing query results
    ResultSet result;

    // Constructor
    AdminDAO() throws SQLException {
        // Establish database connection
        connection = DatabaseConnection.getConnection();
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to get admin details by ID
    public HashMap getAdmin(String id) {
        // HashMap to store admin details
        HashMap hm = null;

        try {
            // Prepare SQL statement
            pStatement = connection.prepareStatement(AdminDataConnection.getSelect());
            // Set parameter
            pStatement.setString(1, id);
            // Execute query
            result = pStatement.executeQuery();

            // If result exists, populate HashMap with admin details
            if (result.next()) {
                hm = new HashMap();
                hm.put("ID", result.getString("userid"));
                hm.put("PWD", result.getString("pwd"));
            }
        } catch (Exception e) {
            // Show error message if an exception occurs
            JOptionPane.showMessageDialog(null, e.getMessage() + " Try again..");
        }

        return hm;
    }
}

