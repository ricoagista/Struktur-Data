package Rico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat object dari class yang sudah kita buat
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        PostfixEvaluator evaluator = new PostfixEvaluator();

        // Tampilan judul program
        System.out.println("=".repeat(55));
        System.out.println("      PEMROSES EKSPRESI MATEMATIKA");
        System.out.println("      Infix ke Postfix & Evaluator");
        System.out.println("=".repeat(55));
        System.out.println("Operator yang didukung: + , - , * , /");
        System.out.println("Mendukung tanda kurung ( ) dan bilangan desimal");
        System.out.println("-".repeat(55));

        // Input dari user
        System.out.print("\nMasukkan ekspresi infix: ");
        String infixExpression = scanner.nextLine();

        // Hilangkan spasi berlebih
        infixExpression = infixExpression.trim().replaceAll("\\s+", " ");

        // Tampilkan Infix
        System.out.println("\nInfix    : " + infixExpression);

        // Proses konversi ke Postfix
        String postfixExpression = converter.convert(infixExpression);
        System.out.println("\nPostfix  : " + postfixExpression);

        // Proses evaluasi Postfix
        try {
            double result = evaluator.evaluate(postfixExpression);
            System.out.println("\nResult   : " + evaluator.formatResult(result));
        } catch (Exception e) {
            System.out.println("\nError    : " + e.getMessage());
        }

        scanner.close();
    }
}