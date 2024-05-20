// Adharsh T


package Assignment6Controller;

import Assignment6Model.BankAccount;

public class AccountDTO {
    private int id; // Account ID
    private int accountNum; // Account number
    private double balance; // Account balance
    private String type; // Account type
    private int custNum; // Customer number associated with the account

    public AccountDTO(){}

    // Constructor
    public AccountDTO(int id, int accountNum, double balance, String type, int custNum) {
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
        this.type = type;
        this.custNum = custNum;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }
}
