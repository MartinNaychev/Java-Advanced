package SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        Map<Character,Integer> characters = new TreeMap();
        for (char symbol : input) {
            if (characters.containsKey(symbol)){
                int counter = characters.get(symbol);
                characters.put(symbol,counter+1);
            }
            characters.putIfAbsent(symbol,1);
        }

        for (var entry : characters.entrySet()) {
            char symbol = entry.getKey();
            int count = entry.getValue();
            System.out.printf("%c: %d time/s%n",symbol,count);

        }





    }
}
