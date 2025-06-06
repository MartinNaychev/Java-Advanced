package FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Consumer;


public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameArray = scanner.nextLine().split("\\s+");

        Consumer<String[]> printArray = array -> {
            for (String text : array) {
                System.out.println(text);
            }
        };

        printArray.accept(nameArray);



    }
}
