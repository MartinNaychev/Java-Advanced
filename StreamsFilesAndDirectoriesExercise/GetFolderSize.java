package StreamsFilesAndDirectoriesExercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int size = 0;

        for (File file : allFiles) {
            int currentSize = (int) file.length();
            size+=currentSize;
        }

        System.out.println("Folder size: " + size);


    }
}
