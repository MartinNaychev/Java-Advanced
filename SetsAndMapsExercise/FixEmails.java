package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,String>emailsBook = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")){
            String email = scanner.nextLine();

            if (!email.endsWith(".com") && !email.endsWith(".uk") && !email.endsWith(".us")){
                emailsBook.put(name,email);
            }

            name= scanner.nextLine();
        }

        for (var entry : emailsBook.entrySet()) {
            String nameForPrint = entry.getKey();
            String email = entry.getValue();
            System.out.println(nameForPrint +" -> " + email);


        }




    }
}
