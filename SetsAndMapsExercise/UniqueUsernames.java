package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int counter = Integer.parseInt(scanner.nextLine());


        while (counter-->0 ){
        String input = scanner.nextLine();
        names.add(input);

        }

        for (String name : names) {
            System.out.println(name);
        }

    }
}
