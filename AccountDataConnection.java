//Adharsh T

package Assignment6Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDataConnection extends DatabaseConnection {

    // SQL queries

    private static final String INSERT_SQL = "INSERT INTO bankaccount (cust_num, balance, create_date, acct_type) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM bankaccount WHERE acct_num = ?";
    private static final String UPDATE_SQL = "UPDATE bankaccount SET cust_num = ?, balance = ?, create_date = ?, acct_type = ? WHERE acct_num = ?";
    private static final String DELETE_SQL = "DELETE FROM bankaccount WHERE acct_num = ?";


    // Getter methods for SQL queries
    public static String getInsert() {

        return INSERT_SQL;
    }

    public static String getUpdate() {

        return UPDATE_SQL;
    }

    public static String getSelect() {

        return SELECT_SQL_BYID;
    }

    public static String getDelete() {

        return DELETE_SQL;
    }

    // Method to close resources including ResultSet
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

