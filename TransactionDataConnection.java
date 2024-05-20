package Assignment6Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDataConnection extends DatabaseConnection {



    // SQL queries to be used to persist transaction objects as needed by its DAO
    private static final String INSERT_SQL = "INSERT INTO accounttransaction (create_date, tran_type, amount, summary, acct_id) VALUES (?, ?, ?, ?,?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM accounttransaction WHERE acct_id = ?";

    public TransactionDataConnection()  { }

    public static String getInsert() {

        return INSERT_SQL;
    }



    public static String getSelect() {

        return SELECT_SQL_BYID;
    }

}

