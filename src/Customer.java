public class Customer {
        private String name; // Nom du client
        private String address; // Adresse du client
        private String postalCode; // Code postal du client
        private String city; // Ville du client

        public Customer(String name, String address, String postalCode, String city) {
            this.name = name;
            this.address = address;
            this.postalCode = postalCode;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
