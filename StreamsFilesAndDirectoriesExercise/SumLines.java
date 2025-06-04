package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        List<String> allLines = Files.readAllLines(path);

        allLines.stream()
                .map(line -> line.toCharArray())
                .forEach(array -> {
                    int sum = 0;
                    for (char symbol: array){
                        sum+= symbol;
                    }
                    System.out.println(sum);
                });
    }
}
