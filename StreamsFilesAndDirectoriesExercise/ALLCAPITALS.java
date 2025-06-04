package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) {
        String in = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String out = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectoriesExercise/output.txt";

        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));
            ){
            String line = bufferedReader.readLine();
            while (line != null){
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
