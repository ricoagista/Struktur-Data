package Rico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketService service = new TicketService();
        int choice;

        System.out.println("=== RAILWAY TICKET SERVICE SYSTEM ===");
        System.out.println("Welcome to the train station ticketing system");

        do {
            // TAMPILAN MENU
            System.out.println("\n=== Railway Ticket Service ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Display Queue");
            System.out.println("3. Serve Passenger");
            System.out.println("4. Undo Last Transaction");
            System.out.println("5. Exit");
            System.out.print("Choose menu: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter passenger name: ");
                        String name = scanner.nextLine();
                        service.addPassenger(name);
                        break;
                    case 2:
                        service.displayQueue();
                        break;
                    case 3:
                        service.servePassenger();
                        break;
                    case 4:
                        service.undoLastTransaction();
                        break;
                    case 5:
                        System.out.println("\nThank you for using Railway Ticket Service!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = 0;
            }
        } while (choice != 5);

        scanner.close();
    }
}