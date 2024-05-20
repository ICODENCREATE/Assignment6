package Assignment6Model;

import java.util.ArrayList;

public class BankCustomerBuilder {
    // Fields
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ArrayList<CustomerAddress> addresses;
    private String custBirthday;

    // Constructors
    public BankCustomerBuilder() {
    }

    public BankCustomerBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public BankCustomerBuilder(String firstName, String lastName, String phoneNumber, ArrayList<CustomerAddress> addresses, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
        this.email = email;
    }

    // Setters for additional parameters
    public BankCustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public BankCustomerBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public BankCustomerBuilder address(ArrayList<CustomerAddress> addrList) {
        this.addresses = addrList;
        return this;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<CustomerAddress> getAddresses() {
        return addresses;
    }

    public String getEmail() {
        return email;
    }

    // Method to build a BankCustomer object
    public BankCustomer build() {
        // Create and return a new BankCustomer object using the provided builder parameters
        BankCustomer customer = new BankCustomer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(String.valueOf(Integer.parseInt(phoneNumber)));
        customer.setEmail(email);
        if (addresses != null) {
            for (CustomerAddress address : addresses) {
                customer.setAddress(address);
            }
        }
        // You can set additional attributes here if needed
        return customer;
    }
}