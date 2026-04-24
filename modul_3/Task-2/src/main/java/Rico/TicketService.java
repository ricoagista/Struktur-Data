package Rico;

// Class ini menghubungkan Queue dan Stack (business logic)
public class TicketService {

    private PassengerQueue queue;
    private TransactionStack stack;
    private int ticketCounter;

    public TicketService() {
        queue = new PassengerQueue();
        stack = new TransactionStack();
        ticketCounter = 1;
    }

    // MENU 1: Tambah penumpang ke antrian
    public void addPassenger(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }
        queue.enqueue(name);
    }

    // MENU 2: Lihat antrian saat ini
    public void displayQueue() {
        System.out.println("Current Queue:");
        queue.display();
    }

    // MENU 3: Layani penumpang (ambil dari depan queue, simpan ke stack)
    public void servePassenger() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty! No passenger to serve.");
            return;
        }

        String servedPassenger = queue.dequeue();
        if (servedPassenger != null) {
            String ticketNumber = "TIK-" + String.format("%04d", ticketCounter++);
            String transaction = ticketNumber + " | " + servedPassenger + " | Served";
            stack.push(transaction);
            System.out.println("Serving passenger: " + servedPassenger + " Transaction saved.");
        }
    }

    // MENU 4: Undo transaksi terakhir (ambil dari stack, kembalikan ke queue)
    public void undoLastTransaction() {
        if (stack.isEmpty()) {
            System.out.println("No transaction to undo!");
            return;
        }

        String lastTransaction = stack.pop();
        String[] parts = lastTransaction.split(" \\| ");
        String passengerName = parts[1];

        // Kembalikan penumpang ke DEPAN antrian
        queue.addToFront(passengerName);
        ticketCounter--;

        System.out.println("Undo last transaction: " + passengerName + " " + passengerName + " added back to queue.");
    }
}