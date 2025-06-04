package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/input.txt";
        String output = "/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/output.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(output);

        int currentByte = inputStream.read();
        while (currentByte >= 0) {
            if (currentByte == 32 || currentByte == 10) {
                outputStream.write(currentByte);
            }else {
                String digit = String.valueOf(currentByte);
                for (int i = 0; i < digit.length(); i++) {
                    outputStream.write(digit.charAt(i));

                }
            }


            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();

    }
}
