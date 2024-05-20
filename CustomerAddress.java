package Assignment6Model;

public class CustomerAddress {

        // Fields
        private int streetNum; // Street number (not used in constructors or methods)
        private int zip; // Zip code
        private int id; // Customer ID
        private String streetName; // Street name
        private String city; // City
        private String state; // State

        // Constructor
        public CustomerAddress(int custID, String streetName, String city, String state, int zip) {
                this.id = custID;
                this.streetName = streetName;
                this.city = city;
                this.state = state;
                this.zip = zip;
        }

        // Default constructor
        public CustomerAddress(String streetName, String city, String state, String zip) {
        }

// Setters and getters

        public String getStreetName() {
                return streetName;
        }

        public void setStreetName(String streetName) {
                this.streetName = streetName;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public int getZip() {
                return zip;
        }

        public void setZip(int zip) {
                this.zip = zip;
        }

        public int getID() {
                return id;
        }

        public void setID(int id) {
                this.id = id;
        }

        // Override toString method for easy debugging
        @Override
        public String toString() {
                return "CustomerAddress{" +
                        "id=" + id +
                        ", streetName='" + streetName + '\'' +
                        ", city='" + city + '\'' +
                        ", state='" + state + '\'' +
                        ", zip=" + zip +
                        '}';
        }
}