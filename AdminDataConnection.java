package Assignment6Controller;

public class AdminDataConnection {

    // SQL query to select admin by user ID
    private static final String SELECT_ADMIN = "SELECT * FROM admin WHERE userid = ?";

    // Default constructor
    public AdminDataConnection()  { }

    // Method to get the SQL query for selecting admin by user ID
    public static String getSelect() {
        return SELECT_ADMIN;
    }

}
