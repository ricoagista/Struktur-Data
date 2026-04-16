package Rico;

public class Passenger {
    private String name;
    private String email;
    private String phone;
    private int passengerId;
    private int age;
    private static int idCounter = 1;

    public Passenger(String name, String email, String phone, int age) {
        this.passengerId = idCounter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPassengerId() { return passengerId; }

    public void displayInfo() {
        System.out.println("ID: " + passengerId + " | Nama: " + name + " | Email: " + email + " | Umur: " + age);
    }
}