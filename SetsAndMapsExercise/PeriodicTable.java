package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        Set<String>uniqueChemicals = new TreeSet<>();


        while (counter-->0){
            String[] chemicals = scanner.nextLine().split("\\s+");
            uniqueChemicals.addAll(Arrays.asList(chemicals));

        }

        uniqueChemicals.forEach(chemical -> System.out.print(chemical + " "));

    }
}
