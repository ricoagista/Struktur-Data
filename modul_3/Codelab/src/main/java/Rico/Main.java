package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // ***********************************************
        // BAGIAN 1: QUEUE DEMONSTRATION (FIFO)
        // ***********************************************
        // Queue digunakan untuk antrian pelayanan di stasiun
        // Penumpang yang datang pertama akan dilayani pertama
        // ***********************************************

        // TODO 1: Inisialisasi Queue untuk antrian pelayanan
        // Clue: Queue adalah interface, implementasinya menggunakan LinkedList
        // Sintaks: Queue<TipeData> namaVariable = new LinkedList<>();
        Queue<String> serviceQueue = new LinkedList<>(); // Lengkap inisialisasi Queue

        // TODO 2: Menambahkan penumpang ke antrian menggunakan add()
        // Clue: Gunakan method add(element) untuk menambahkan ke antrian
        // Sintaks: namaQueue.add("data");
        //
        // Tambahkan 3 penumpang: Andi, Titan, Rapi
        serviceQueue.add("Andi");   // Lengkap method untuk menambahkan ke antrian
        serviceQueue.add("Titan");  // Lengkap method untuk menambahkan ke antrian
        serviceQueue.add("Rapi");   // Lengkap nama Queue dan method

        // Menampilkan antrian awal
        System.out.println("Initial Service Queue:");
        System.out.println(serviceQueue);

        // TODO 3: Melayani penumpang (mengambil dari depan antrian) menggunakan poll()
        // Clue: Gunakan method poll() untuk mengambil dan menghapus elemen pertama
        // Sintaks: String hasil = namaQueue.poll();
        // poll() mengembalikan null jika queue kosong
        // Alternatif: remove() - throws exception jika kosong
        String servedPassenger = serviceQueue.poll(); // Lengkap method untuk mengambil dari antrian
        System.out.println("Serving passenger: " + servedPassenger);

        // Menampilkan antrian setelah pelayanan
        System.out.println("Queue after serving:");
        System.out.println(serviceQueue);

        // TODO 4: Melihat penumpang di depan antrian tanpa menghapus menggunakan peek()
        // Clue: Gunakan method peek() untuk melihat elemen pertama tanpa menghapus
        // Sintaks: String first = namaQueue.peek();
        String nextPassenger = serviceQueue.peek(); // Lengkapi method untuk melihat elemen pertama
        System.out.println("Next passenger to serve: " + nextPassenger);
        System.out.println();

        // ***********************************************
        // BAGIAN 2: STACK DEMONSTRATION (LIFO)
        // ***********************************************

        // TODO 5: Inisialisasi Stack untuk riwayat transaksi
        // Clue: Gunakan class Stack untuk membuat stack
        // Sintaks: Stack<TipeData> namaVariable = new Stack<>();
        Stack<String> transactionHistory = new Stack<>(); // Lengkapi inisialisasi stack

        // TODO 6: Menambahkan transaksi ke stack menggunakan push()
        // Clue: Gunakan method push(element) untuk menambahkan ke stack
        // Sintaks: namaStack.push("data");
        // Tambahkan 3 transaksi: Transaction-1, Transaction-2, Transaction-3
        transactionHistory.push("Transaction-1"); // Lengkapi method untuk menambah ke stack
        transactionHistory.push("Transaction-2"); // Lengkapi method untuk menambah ke stack
        transactionHistory.push("Transaction-3"); // Lengkapi nama stack dan method

        // Menampilkan riwayat transaksi
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);

        // TODO 7: Membatalkan transaksi terakhir (undo) menggunakan pop()
        // Clue: Gunakan method pop() untuk mengambil dan menghapus elemen teratas
        // Sintaks: String hasil = namaStack.pop();
        // pop() throws EmptyStackException jika stack kosong
        String lastTransaction = transactionHistory.pop(); // Lengkapi method untuk mengambil dari stack
        System.out.println("Undo last transaction: " + lastTransaction);

        // Menampilkan riwayat setelah undo
        System.out.println("Transaction History after undo:");
        System.out.println(transactionHistory);

        // TODO 8: Melihat transaksi terakhir tanpa menghapus menggunakan peek()
        // Clue: Gunakan method peek() untuk melihat elemen teratas tanpa menghapus
        // Sintaks: String top = namaStack.peek();
        String topTransaction = transactionHistory.peek(); // Lengkapi method untuk melihat elemen teratas
        System.out.println("Current top transaction: " + topTransaction);

        // TODO 9: Mengecek apakah stack kosong menggunakan isEmpty()
        // Clue: Gunakan method isEmpty() untuk mengecek apakah stack kosong
        // Sintaks: boolean kosong = namaStack.isEmpty();
        System.out.println();
        if (transactionHistory.isEmpty()) { // Lengkapi method untuk cek stack kosong
            System.out.println("No transaction history.");
        } else {
            System.out.println("Transaction history is not empty. Size: " + transactionHistory.size()); // Lengkapi method untuk mendapatkan ukuran
        }
    }
}