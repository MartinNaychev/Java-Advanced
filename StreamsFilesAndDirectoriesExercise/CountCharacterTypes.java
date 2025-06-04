package StreamsFilesAndDirectoriesExercise;

import javax.xml.stream.events.Characters;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String input = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        String content = Files.readString(Path.of(input));
        content = content.replaceAll("\\s+", "");

        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '!', '?', ',', '.');

        int countVowels = 0;
        int countPunctuation = 0;
        int countOthers = 0;

        for (char symbol : content.toCharArray()) {
            if (vowels.contains(symbol)) {
                countVowels++;
            } else if (punctuation.contains(symbol)) {
                countPunctuation++;

            } else {
                countOthers++;
            }
        }
        String out = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectoriesExercise/output.txt";


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));
        bufferedWriter.write("Vowels: " + countVowels);
        bufferedWriter.newLine();
        bufferedWriter.write("Other symbols: " + countOthers);
        bufferedWriter.newLine();
        bufferedWriter.write("Punctuation: " + countPunctuation);
        bufferedWriter.close();


    }
}
