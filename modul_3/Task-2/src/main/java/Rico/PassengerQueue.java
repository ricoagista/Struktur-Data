package Rico;

import java.util.LinkedList;
import java.util.Queue;

// Class untuk mengelola antrian penumpang (FIFO)
public class PassengerQueue {

    private Queue<String> queue;

    public PassengerQueue() {
        queue = new LinkedList<>();
    }

    // Tambah penumpang ke belakang antrian
    public void enqueue(String name) {
        queue.add(name);
        System.out.println("Passenger added to queue.");
    }

    // Hapus dan ambil penumpang dari depan antrian
    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty! No passenger to serve.");
            return null;
        }
        return queue.poll();
    }

    // Lihat penumpang paling depan tanpa menghapus
    public String peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    // Tampilkan semua antrian
    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int position = 1;
        for (String passenger : queue) {
            System.out.println(position + ". " + passenger);
            position++;
        }
    }

    // Khusus untuk UNDO: masukkan penumpang ke depan antrian
    public void addToFront(String passenger) {
        Queue<String> newQueue = new LinkedList<>();
        newQueue.add(passenger);
        newQueue.addAll(queue);
        queue = newQueue;
    }
}