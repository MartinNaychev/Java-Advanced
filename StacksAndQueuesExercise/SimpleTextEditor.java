package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyText = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1 -> {
                    historyText.push(String.valueOf(text));
                    text.append(input[1]);
                }
                case 2 -> {
                    historyText.push(String.valueOf(text));
                    int numbersToRemove = Integer.parseInt(input[1]);
                    int startIndex = text.length() - numbersToRemove;
                    text.delete(startIndex, text.length());
                }
                case 3 -> {
                    int index = Integer.parseInt(input[1]) - 1;
                    System.out.println(text.charAt(index));

                }
                case 4 -> text= new StringBuilder(historyText.pop());
            }

        }


    }
}
