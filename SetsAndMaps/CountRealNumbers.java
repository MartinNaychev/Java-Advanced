package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Integer> numbersCount = new LinkedHashMap<>();

        String [] numbers = scanner.nextLine().split("\\s+");

        for (String number : numbers) {
            if (!numbersCount.containsKey(number)){
                numbersCount.put(number,1);

            }else {
                int count = numbersCount.get(number)+1;
                numbersCount.put(number,count);

            }
        }

        for (var entry : numbersCount.entrySet()) {
            double number = Double.parseDouble(entry.getKey());
            int count = entry.getValue();
            System.out.printf("%.1f -> %d%n",number,count);

        }
    }
}
