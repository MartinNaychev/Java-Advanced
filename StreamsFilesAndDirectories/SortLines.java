package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path pathReader = Path.of("/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/input.txt");
        List<String> allLines = Files.readAllLines(pathReader);
        Collections.sort(allLines);

        Path print = Path.of("/Users/martinnaychev/Documents/GitHub/Java-Advanced/StreamsFilesAndDirectories/output.txt");
        Files.write(print,allLines);
    }
}
