package Assignment6Controller;

import java.sql.*;

public class DatabaseConnection {

    // Database connection parameters
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DATABASE_USERNAME = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the JDBC driver is loaded
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found");
        }
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    // Method to close database resources
    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Overloaded method to close resources without ResultSet
    public static void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
}