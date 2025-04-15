package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();


        for (char symbol : input.toCharArray()) {

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                openBrackets.push(symbol);
            } else if (openBrackets.isEmpty() || !validateCloseBracket(openBrackets.pop(), symbol)) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");

    }

    private static boolean validateCloseBracket(char openBracket, char closeBracket) {
        if (openBracket == '{') {
            return closeBracket == '}';
        } else if (openBracket == '[') {
            return closeBracket == ']';
        } else {
            return closeBracket == ')';
        }
    }
}


