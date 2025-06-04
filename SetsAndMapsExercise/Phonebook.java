package SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        String[] entry = scanner.nextLine().split("-");
        while (!entry[0].equals("search")) {
            String name = entry[0];
            String phone = entry[1];
            phonebook.put(name, phone);


            entry = scanner.nextLine().split("-");

        }
        String forSerch = scanner.nextLine();
        while (!forSerch.equals("stop")) {
            if (phonebook.containsKey(forSerch)){

                System.out.printf("%s -> %s%n",forSerch, phonebook.get(forSerch));
            }else {
                System.out.printf("Contact %s does not exist.%n",forSerch);
            }


            forSerch = scanner.nextLine();
        }


    }
}
