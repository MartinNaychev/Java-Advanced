package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        ArrayDeque<Character> closeBrackets = new ArrayDeque<>();

        for (char symbol : input.toCharArray()) {

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                openBrackets.push(symbol);
            } else if (symbol == '}' || symbol == ']' || symbol == ')') {
                closeBrackets.offer(symbol);
            }
        }
        for (Character bracket : openBrackets) {
            if (bracket == '{') {
                if (closeBrackets.peek() == '}') {
                    openBrackets.pop();
                    closeBrackets.poll();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (bracket == '[') {
                if (closeBrackets.peek() == ']') {
                    openBrackets.pop();
                    closeBrackets.poll();
                } else {
                    System.out.println("NO");
                    return;
                }

            } else if (bracket == '(') {
                if (closeBrackets.peek() == ')') {
                    openBrackets.pop();
                    closeBrackets.poll();
                } else {
                    System.out.println("NO");
                    return;
                }

            }
        }

        if (openBrackets.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");


    }
}


