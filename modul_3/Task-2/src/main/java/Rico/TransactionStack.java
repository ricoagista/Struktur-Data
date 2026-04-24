package Rico;

import java.util.Stack;

// Class untuk mengelola riwayat transaksi (LIFO) - mendukung UNDO
public class TransactionStack {

    private Stack<String> stack;

    public TransactionStack() {
        stack = new Stack<>();
    }

    // Simpan transaksi ke stack (paling atas)
    public void push(String transaction) {
        stack.push(transaction);
    }

    // Ambil dan hapus transaksi terakhir (untuk UNDO)
    public String pop() {
        if (stack.isEmpty()) {
            System.out.println("No transaction to undo!");
            return null;
        }
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}