package SetsAndMapsExercise;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set <Integer> firstSet = new LinkedHashSet<>();
        Set <Integer> secondtSet = new LinkedHashSet<>();

        int[] size = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstSize = size[0];
        int secondSize = size[1];


        while (firstSize-->0){
            int input = Integer.parseInt(scanner.nextLine());
            firstSet.add(input);

        }
        while (secondSize-->0){
            int input = Integer.parseInt(scanner.nextLine());
            secondtSet.add(input);
        }


        firstSet.retainAll(secondtSet);
        firstSet.forEach(number -> System.out.print(number + " "));

    }
}
