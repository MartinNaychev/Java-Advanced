package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);


        String output = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/output.txt";
        FileOutputStream outputStream = new FileOutputStream(output);
        PrintWriter writer = new PrintWriter(outputStream);

        int count = 1;
        String line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;
            line= scanner.nextLine();

        }

        writer.close();
        scanner.close();


    }
}
