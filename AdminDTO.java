package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AdminDTO {
    // Static instance of AdminDAO for accessing database
    static AdminDAO ad;

    // Static initialization block to initialize AdminDAO
    static {
        try {
            ad = new AdminDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Default constructor
    public AdminDTO() {

    }

    // Method to validate admin credentials
    public static boolean validateAdmin(String givenID, String givenPwd) {
        // Flag to indicate success of validation
        boolean success = false;

        // Get admin details from database
        HashMap hm = ad.getAdmin(givenID);

        // If admin details exist
        if(hm != null) {
            // Get the fetched password
            String fetchedPwd = (String)hm.get("PWD");
            // Check if given password matches fetched password (case insensitive)
            success = givenPwd.equalsIgnoreCase(fetchedPwd);
        }

        return success;
    }
}