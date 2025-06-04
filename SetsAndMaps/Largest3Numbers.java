package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        input.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(n -> System.out.print(n + " "));






    }
}
