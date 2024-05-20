package Assignment6Model;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Comparable<BankCustomer> {

    // Define static variables to be used in the customer processing
    private static ArrayList<BankCustomer> customers = new ArrayList<>();
    private static int custCount = 0;
    String firstName;
    String lastName;
    String phone;
    String email;
    String birthday;
    int customerNumber;
    List<BankAccount> accounts = new ArrayList<>();
    CustomerAddress address;
    private String city;
    private int id;

    public BankCustomer(int custCount, String firstName, String lastName, String email, String phone, CustomerAddress customerAddress){

    }

    public BankCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    // 2-Arg Constructor that creates a new instance, adds self to customer collection and increments the static counter
    public BankCustomer() {
        firstName = firstName;
        lastName = lastName;
        email = email;
        phone = String.valueOf(phone);
        customers.add(this);
        customerNumber = ++custCount;
    }

    public BankCustomer(int num, String fName, String lName) {
        firstName = fName;
        lastName = lName;
        customers.add(this);
        customerNumber = num;
    }

    // All setters and getters for customer

    public String getEmail() {
        return email;
    }

    public void setEmail(String em) {
        email = em;
    }

    public void setAddress(CustomerAddress anAddress) {
        address = anAddress;
    }

    public String getName() {
        return (firstName + " " + lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String nm) {
        firstName = nm;
    }

    public void setLastName(String nm) {
        lastName = nm;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAccounts(List<BankAccount> acts) {
        accounts = acts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String ph) {
        phone = ph;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String bd) {
        birthday = bd;
    }

    public void addAccount(BankAccount anAct) {
        accounts.add(anAct);
    }

    public static ArrayList<BankCustomer> getCustomers() {
        // Will add code later to get all bank customers from the Database
        // in collaboration with Customer DTO and DAO objects
        return customers;
    }

    public static int getCustCount() {
        return custCount;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int compareTo(BankCustomer cust) {

        int num1 = this.getCustomerNumber();
        int num2 = cust.getCustomerNumber();

        if (num1 == num2)
            return 0;
        else if (num1 > num2)
            return 1;
        else
            return -1;

    }

    public static BankCustomerBuilder builder() {
        return new BankCustomerBuilder();
    }

    public String toString() {

        String str = "\n";

        str += this.getCustomerNumber();
        str += " : " + this.getName();
        str += " : " + this.getAddress();
        System.out.println(str);

        return str;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
    }
}