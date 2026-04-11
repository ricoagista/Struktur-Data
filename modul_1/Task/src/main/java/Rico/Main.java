import java.util.Scanner;

// 2. Definisi Enum untuk Kelas Tiket [cite: 417]
enum TicketClass {
    ECONOMY, BUSINESS, EXECUTIVE
}

// 1. Kelas Generic untuk Penumpang [cite: 416]
class Passenger<T> {
    private String name;
    private T identityNumber; // Bisa Long atau Integer sesuai output

    public Passenger(String name, T identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    public String getName() { return name; }
    public T getIdentityNumber() { return identityNumber; }
    public String getIdentityType() {
        return identityNumber.getClass().getSimpleName();
    }
}

// 1. Kelas Generic untuk Tiket [cite: 416]
class Ticket<T, U> {
    private T bookingCode;
    private Passenger<U> passenger;
    private TicketClass ticketClass;

    public Ticket(T bookingCode, Passenger<U> passenger, TicketClass ticketClass) {
        this.bookingCode = bookingCode;
        this.passenger = passenger;
        this.ticketClass = ticketClass;
    }

    // 3. Implementasi Method menggunakan Wildcard (<?>)
    static void displayTicketInfo(Ticket<?, ?> ticket) {
        System.out.println("\n=== Ticket Information ===");
        System.out.println("Booking Code    : " + ticket.bookingCode);
        System.out.println("Passenger Name  : " + ticket.passenger.getName());
        System.out.println("Identity Type   : " + ticket.passenger.getIdentityType());
        System.out.println("Identity Number : " + ticket.passenger.getIdentityNumber());
        System.out.println("Ticket Class    : " + ticket.ticketClass);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Railway Ticket Booking ===");

        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Identity Number: ");
        String identityInput = scanner.nextLine();

        System.out.print("Enter Booking Code: ");
        String bookingCode = scanner.nextLine();

        System.out.println("\nSelect Ticket Class:");
        System.out.println("1. ECONOMY");
        System.out.println("2. BUSINESS");
        System.out.println("3. EXECUTIVE");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        // Menentukan Enum berdasarkan pilihan [cite: 343]
        TicketClass selectedClass = TicketClass.ECONOMY;
        if (choice == 2) selectedClass = TicketClass.BUSINESS;
        else if (choice == 3) selectedClass = TicketClass.EXECUTIVE;

        // Logika untuk menentukan apakah Identity itu Integer atau Long (Sesuai contoh Output)
        if (identityInput.length() > 9) {
            long idLong = Long.parseLong(identityInput);
            Passenger<Long> p = new Passenger<>(name, idLong);
            Ticket<String, Long> t = new Ticket<>(bookingCode, p, selectedClass);
            Ticket.displayTicketInfo(t);
        } else {
            int idInt = Integer.parseInt(identityInput);
            Passenger<Integer> p = new Passenger<>(name, idInt);
            Ticket<String, Integer> t = new Ticket<>(bookingCode, p, selectedClass);
            Ticket.displayTicketInfo(t);
        }
    }
}