package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque <Integer> bracketsIndex = new ArrayDeque<>();


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol=='('){
                bracketsIndex.push(i);
            }else if (symbol ==')'){
                int firstIndex = bracketsIndex.pop();
                int lastIndex = i+1;
                String sb = input.substring(firstIndex,lastIndex);
                System.out.println(sb);
            }


        }



    }
}
