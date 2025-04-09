package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        while (number != 0) {
            binaryNumber.push(number % 2);
            number /= 2;

        }

        //System.out.println(binaryNumber.toString().replaceAll("[\\[\\], ]", ""));

        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }

    }
}
