package Rico;

import java.util.Stack;

public class PostfixEvaluator {

    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Error: Pembagian dengan nol tidak diperbolehkan!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operator tidak dikenal: " + operator);
        }
    }

    public double evaluate(String postfix) {
        Stack<Double> operandStack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            // Jika token adalah angka (termasuk desimal)
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                operandStack.push(Double.parseDouble(token));
            }
            // Jika token adalah operator
            else if (isOperator(token)) {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = calculate(operand1, operand2, token);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    public String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}