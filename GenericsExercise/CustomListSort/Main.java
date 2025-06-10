package GenericsExercise.CustomListSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParts = scanner.nextLine().split("\\s+");

        CustomList<String> customList = new CustomList<>();

        while (!inputParts[0].equals("END")) {

            String command = inputParts[0];

            switch (command) {
                case "Add" -> customList.add(inputParts[1]);
                case "Remove" -> customList.remove(Integer.parseInt(inputParts[1]));
                case "Contains" -> System.out.println(customList.contains(inputParts[1]));
                case "Swap" -> customList.swap(Integer.parseInt(inputParts[1]), Integer.parseInt(inputParts[2]));
                case "Greater" -> System.out.println(customList.grater(inputParts[1]));
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print" -> {
                    for (int i = 0; i < customList.size; i++) {
                        System.out.println(customList.get(i));

                    }
                }
                case "Sort" -> Sorted.sort(customList);

            }


            inputParts = scanner.nextLine().split("\\s+");
        }
    }
}
