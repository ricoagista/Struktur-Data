package Rico;

import java.util.ArrayList;
import java.util.Scanner;

public class PassengerManager {
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    //Add Passenger
    public void addPassengerInteractively() {
        System.out.print("Masukkan Nama: ");
        String name = input.nextLine();
        System.out.print("Masukkan Email: ");
        String email = input.nextLine();
        System.out.print("Masukkan No HP: ");
        String phone = input.nextLine();
        System.out.print("Masukkan Umur: ");
        int age = input.nextInt();
        input.nextLine();

        passengers.add(new Passenger(name, email, phone, age));
        System.out.println("Penumpang berhasil ditambahkan ke list!");
    }

    // Get Passenger
    public void getPassenger() {
        System.out.print("Masukkan indeks penumpang: ");
        int index = input.nextInt();
        input.nextLine();
        if (index >= 0 && index < passengers.size()) {
            passengers.get(index).displayInfo();
        } else {
            System.out.println("Indeks tidak ditemukan.");
        }
    }

    // Search: Linear Search berdasarkan Nama
    public void searchByName() {
        System.out.print("Cari Nama: ");
        String target = input.nextLine();
        boolean found = false;
        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(target)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Data tidak ditemukan.");
    }

    // Update
    public void updatePassenger() {
        System.out.print("Indeks yang ingin diubah: ");
        int index = input.nextInt();
        input.nextLine();
        if (index >= 0 && index < passengers.size()) {
            System.out.print("Nama Baru: ");
            passengers.get(index).setName(input.nextLine());
            System.out.println("Data berhasil diupdate!");
        } else {
            System.out.println("Indeks salah.");
        }
    }

    // Remove: Berdasarkan Indeks atau ID
    public void removePassenger() {
        System.out.println("Hapus berdasarkan: 1. Indeks | 2. Passenger ID");
        int opsi = input.nextInt();
        if (opsi == 1) {
            System.out.print("Masukkan indeks: ");
            int idx = input.nextInt();
            if (idx >= 0 && idx < passengers.size()) passengers.remove(idx);
        } else {
            System.out.print("Masukkan ID: ");
            int id = input.nextInt();
            passengers.removeIf(p -> p.getPassengerId() == id);
        }
        System.out.println("Proses hapus selesai.");
    }

    // Display All
    public void displayAll() {
        System.out.println("\n--- DAFTAR PENUMPANG ---");
        if (passengers.isEmpty()) System.out.println("List Kosong.");
        for (Passenger p : passengers) {
            p.displayInfo();
        }
    }

    public static void main(String[] args) {
        PassengerManager pm = new PassengerManager();
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n1. Tambah | 2. Ambil (Index) | 3. Cari Nama | 4. Update | 5. Hapus | 6. Lihat Semua | 0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch(pilih) {
                case 1: pm.addPassengerInteractively(); break;
                case 2: pm.getPassenger(); break;
                case 3: pm.searchByName(); break;
                case 4: pm.updatePassenger(); break;
                case 5: pm.removePassenger(); break;
                case 6: pm.displayAll(); break;
            }
        } while (pilih != 0);
    }
}