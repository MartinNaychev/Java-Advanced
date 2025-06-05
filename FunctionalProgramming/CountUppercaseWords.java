package FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        List<String> words = Arrays.stream(text.split("\\s+"))
                              .collect(Collectors.toList());

        Predicate<String> isUpperCase = word ->  Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(isUpperCase).collect(Collectors.toList());

        int size = words.size();
        System.out.println(size);

        System.out.println(String.join("\n", words));

    }
}
