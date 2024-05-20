package Assignment6Model;

import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount> {

    // Instance variables
    private int accountNum;
    private LocalDate createDate;
    private double balance;
    private String type;
    private int custNum;
    private int id;

    // Static variables
    private static String bankName = "Your Bank";
    private static int currentNumber = 0;

    // Constructors
    public BankAccount(int id, double balance) {
        this.id = id;
        this.createDate = LocalDate.now();
        this.balance = balance;

    }

    public BankAccount(int num, double balance, String type, int accountNum) {
        this.accountNum = accountNum;
        this.createDate = LocalDate.now();
    }

    // Getters and setters
    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    @Override
    public int compareTo(BankAccount ba) {
        return Integer.compare(this.accountNum, ba.accountNum);
    }

    @Override
    public String toString() {
        return "[ID:" + id + "Num: " + accountNum + " Create Date: " + createDate.toString() + " Balance: " + balance + "]";
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean transfer(BankAccount account, double amount) {
        if (balance >= amount) {
            balance -= amount;
            account.balance += amount;
            return true;
        } else {
            return false;
        }
    }
}