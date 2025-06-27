package WorkingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopSide(n);
        printBottSide(n);
    }

    private static void printBottSide(int n) {
        for (int i = 1; i < n; i++) {
            printString(" ", i);
            printString("* ", n - i);
            System.out.println();
        }

    }

    private static void printTopSide(int n) {
        for (int i = 1; i <= n; i++) {
            printString(" ", n - i);
            printString("* ", i);
            System.out.println();
        }

    }

    private static void printString(String symbol, int counter) {
        for (int i = 1; i <= counter; i++) {
            System.out.print(symbol);
        }
    }
}

