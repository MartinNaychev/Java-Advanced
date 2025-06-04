package StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("/Users/martinnaychev/Downloads/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                        if (!file.isDirectory()){
                            System.out.printf("%s: [%d]%n",file.getName(),file.length());
                        }
                }
            }

        }

    }
}
