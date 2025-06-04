package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String wordPath = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String textPath = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";

        Map<String, Integer> countWords = new HashMap<>();
        List<String> allWardsLine = Files.readAllLines(Path.of(wordPath));

        for (String line : allWardsLine) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> countWords.put(word, 0));
        }

        List<String> allLanes = Files.readAllLines(Path.of(textPath));

        for (String lane : allLanes) {
            lane.replaceAll(", ", "");
            Arrays.stream(lane.split("\\s+"))
                    .forEach(word -> {
                        if (countWords.containsKey(word)) {
                            int currentCount = countWords.get(word);
                            countWords.put(word, currentCount + 1);
                        }
                    });
        }


        PrintWriter writer = new PrintWriter("/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectoriesExercise/output.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

    }
}
