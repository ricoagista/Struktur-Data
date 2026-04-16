package Rico;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class ScheduleManager {
    private LinkedList<Schedule> schedules = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);

    // Method addFirst & addLast
    public void addFirst(Schedule s) { schedules.addFirst(s); }
    public void addLast(Schedule s) { schedules.addLast(s); }

    public void addScheduleMenu() {
        System.out.print("Kode Kereta: "); String code = sc.nextLine();
        System.out.print("Nama Kereta: "); String name = sc.nextLine();
        System.out.print("Asal: "); String org = sc.nextLine();
        System.out.print("Tujuan: "); String dest = sc.nextLine();
        System.out.print("Waktu: "); String time = sc.nextLine();
        System.out.print("Harga: "); double fare = sc.nextDouble();
        sc.nextLine();

        System.out.println("Tambah di: 1. Awal | 2. Akhir");
        int pos = sc.nextInt(); sc.nextLine();

        Schedule newS = new Schedule(code, name, org, dest, time, fare);
        if (pos == 1) addFirst(newS);
        else addLast(newS);
        System.out.println("Jadwal berhasil ditambahkan!");
    }

    // Remove First & Last
    public void removeFirst() { if (!schedules.isEmpty()) schedules.removeFirst(); }
    public void removeLast() { if (!schedules.isEmpty()) schedules.removeLast(); }

    // Search Routes
    public void searchRoute() {
        System.out.print("Masukkan Kota: ");
        String query = sc.nextLine();
        for (Schedule s : schedules) {
            if (s.getOrigin().equalsIgnoreCase(query) || s.getDestination().equalsIgnoreCase(query)) {
                s.displayInfo();
            }
        }
    }

    // Iterator Traversal
    public void displayAll() {
        System.out.println("\n--- DAFTAR JADWAL KERETA ---");
        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()) {
            it.next().displayInfo();
        }
    }

    // Cleanup pakai Iterator
    public void cleanByOrigin() {
        System.out.print("Hapus semua jadwal dari stasiun: ");
        String target = sc.nextLine();
        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()) {
            if (it.next().getOrigin().equalsIgnoreCase(target)) {
                it.remove();
            }
        }
        System.out.println("Pembersihan selesai.");
    }

    public static void main(String[] args) {
        ScheduleManager sm = new ScheduleManager();
        Scanner mainSc = new Scanner(System.in);
        int menu;

        sm.addLast(new Schedule("TRN01", "Gajayana", "Malang", "Jakarta", "15:00", 500000));

        do {
            System.out.println("\n=== TRAIN SCHEDULE SYSTEM ===");
            System.out.println("1. Tambah Jadwal");
            System.out.println("2. Hapus Jadwal (Pertama/Terakhir)");
            System.out.println("3. Tampilkan Semua");
            System.out.println("4. Cari Rute");
            System.out.println("5. Cleanup Stasiun Asal");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            menu = mainSc.nextInt();
            mainSc.nextLine();

            switch (menu) {
                case 1: sm.addScheduleMenu(); break;
                case 2:
                    System.out.println("1. Hapus Pertama | 2. Hapus Terakhir");
                    int del = mainSc.nextInt();
                    if(del == 1) sm.removeFirst(); else sm.removeLast();
                    break;
                case 3: sm.displayAll(); break;
                case 4: sm.searchRoute(); break;
                case 5: sm.cleanByOrigin(); break;
            }
        } while (menu != 0);
    }
}