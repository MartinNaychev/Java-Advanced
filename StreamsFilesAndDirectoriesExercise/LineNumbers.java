package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        String out = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectoriesExercise/output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));


        int counter = 1;
        for (String line : allLines) {
            bufferedWriter.write(counter + ". " + line);
            bufferedWriter.newLine();
            counter++;
        }

        bufferedWriter.close();





    }
}
