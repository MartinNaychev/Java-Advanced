package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputOne = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String inputTwo = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String output = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectoriesExercise/output.txt";

        List<String> listOne = Files.readAllLines(Path.of(inputOne));
        List<String> lineTwo = Files.readAllLines(Path.of(inputTwo));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));


        listOne.forEach(line -> {
            try {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        lineTwo.forEach(line -> {
            try {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        });

        bufferedWriter.close();


    }
}
