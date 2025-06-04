package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/input.txt";
        String output = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/output.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(output);

        int currentByte = inputStream.read();

        while (currentByte>=0){
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?'){
                outputStream.write(currentSymbol);
            }
            currentByte= inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
