package Assignment6Controller;

public class CustomerDTO {
    // Fields
    private int id; // Customer ID
    private String name; // Customer name
    private String city; // Customer city
    private String email; // Customer email
    private int phone; // Customer phone number

    // Constructors
    public CustomerDTO(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public CustomerDTO(int id, String name, String city, String email, int phone) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    // Override toString for easy debugging
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
