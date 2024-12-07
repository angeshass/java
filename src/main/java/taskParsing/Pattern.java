package taskParsing;

public class Pattern {
    //    final int id;
//    final String name;
//    final String company;
//    final String username;
//    final String email;
//    final String address;
//    final String zip;
//    final String state;
//    final String country;
//    final String phone;
//    final String photo;
    int id;
    String name;
    String company;
    String username;
    String email;
    String address;
    String zip;
    String state;
    String country;
    String phone;
    String photo;

    Pattern(int id,
            String name,
            String company,
            String username,
            String email,
            String address,
            String zip,
            String state,
            String country,
            String phone,
            String photo) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.username = username;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.photo = photo;
    }

    void printPattern() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("company: " + company);
        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("address: " + address);
        System.out.println("zip: " + zip);
        System.out.println("state: " + state);
        System.out.println("country: " + country);
        System.out.println("phone: " + phone);
        System.out.println("photo: " + photo);
    }
}