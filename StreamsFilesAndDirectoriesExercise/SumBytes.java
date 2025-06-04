package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        int sum = 0;

        while (line != null){
            for (char symbol : line.toCharArray()){
                sum+=symbol;
            }
            line = bufferedReader.readLine();
        }

        System.out.println(sum);

    }
}
