package FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boundLength = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> validateName = name -> name.length()<=boundLength;

        for (String name : names) {
            if (validateName.test(name)){
                System.out.println(name);

            }
        }

    }
}
