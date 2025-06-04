package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String input = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/input.txt";
        FileInputStream inputStream = new FileInputStream(input);
        Scanner scanner = new Scanner(inputStream);


        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }



    }
}
