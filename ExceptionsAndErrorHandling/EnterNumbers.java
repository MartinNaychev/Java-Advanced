package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EnterNumbers {
    public static void main(String[] args) {


        List<Integer> numbers = readNumbers(1, 100);

        System.out.println(numbers.toString().replace("[", "").replace("]", ""));

    }

    private static List<Integer> readNumbers(int start, int end) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();


        while (numbers.size() < 10) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number <= start || number >= end) {
                    System.out.printf("Your number is not in range %d - 100!%n", start);
                } else {
                    numbers.add(number);
                    start = number;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            }
        }


        return numbers;
    }
}
