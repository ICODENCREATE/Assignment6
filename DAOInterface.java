package Assignment6Controller;

import java.sql.SQLException;

// Interface defining common data access operations
public interface DAOInterface<T> {

    // Method to retrieve an object by its ID
    T get(int id) throws SQLException;

    // Method to create a new object
    int create(T e) throws SQLException;

    // Method to update an existing object
    int update(T e) throws SQLException;

    // Method to delete an object
    int delete(T e) throws SQLException;

}