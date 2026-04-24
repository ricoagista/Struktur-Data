package Rico;

import java.util.Stack;

public class InfixToPostfixConverter {

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;  // prioritas rendah
            case '*':
            case '/':
                return 2;  // prioritas tinggi
            default:
                return -1; // bukan operator
        }
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    public String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Abaikan spasi
            if (c == ' ') {
                continue;
            }

            // Jika karakter adalah angka atau titik desimal
            if (Character.isDigit(c) || c == '.') {
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    number.append(infix.charAt(i));
                    i++;
                }
                postfix.append(number).append(" ");
                i--; // mundur karena loop for akan increment lagi
            }
            // Jika karakter adalah kurung buka '('
            else if (c == '(') {
                operatorStack.push(c);
            }
            // Jika karakter adalah kurung tutup ')'
            else if (c == ')') {
                // Pop semua operator sampai ketemu '('
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                // Hapus '(' dari stack
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
            // Jika karakter adalah operator
            else if (isOperator(c)) {
                // Keluarkan operator dengan prioritas lebih tinggi atau sama
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        // Pop semua operator yang tersisa di stack
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}