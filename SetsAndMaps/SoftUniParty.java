package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            guests.add(input);
            input = scanner.nextLine();
        }
        input= scanner.nextLine();
        while (!input.equals("END")){
            guests.remove(input);
            input= scanner.nextLine();
        }
        System.out.println(guests.size());
        guests.forEach(guest -> System.out.println(guest));
    }
}
