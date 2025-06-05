package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        while (counter-- > 0) {
            String input = scanner.nextLine();
            String name = input.split(", ")[0];
            int age = Integer.parseInt(input.split(", ")[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int bound = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        BiPredicate<Integer, Integer> validateAge;

        if (condition.equals("younger")) {
            validateAge = (boundAge, age) -> boundAge >= age;

        } else if (condition.equals("older")) {
            validateAge = (boundAge, age) -> boundAge <= age;
        } else {
            validateAge = null;
        }

        Consumer<Map.Entry<String, Integer>> printPerson = null;

        if (printType.equals("name")) {
            printPerson = personEntry -> System.out.println(personEntry.getKey());

        } else if (printType.equals("age")) {
            printPerson = personEntry -> System.out.println(personEntry.getValue());
        } else if (printType.equals("name age")) {
            printPerson = personEntry -> System.out.println(personEntry.getKey() + " - " + personEntry.getValue());

        }

        people.entrySet().stream()
                .filter(peopleEntry -> validateAge.test(bound, peopleEntry.getValue()))
                .forEach(printPerson);


    }
}
