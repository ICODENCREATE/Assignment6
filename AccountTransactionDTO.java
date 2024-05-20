// Adharsh T

package Assignment6Controller;

public class AccountTransactionDTO {
    // Fields
    private int transactionId; // Transaction ID
    private int accountId; // Account ID associated with the transaction
    private double amount; // Transaction amount
    private String date; // Transaction date

    // Constructor
    public AccountTransactionDTO(int transactionId, int accountId, double amount, String date) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // Override toString method to provide meaningful representation of the object
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Account ID: " + accountId + ", Amount: " + amount + ", Date: " + date;
    }
}