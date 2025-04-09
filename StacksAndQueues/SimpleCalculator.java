package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i+=2) {
            numbers.push(Integer.valueOf(input[i]));
        }

        for (int i = 1; i < input.length; i+=2) {
            operators.push(input[i]);
        }

        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();
        ArrayDeque<String> reversedOperators = new ArrayDeque<>();
        while (!numbers.isEmpty()){
            int number = numbers.pop();
            reversedNumbers.push(number);
        }
        while (!operators.isEmpty()){
            String operator = operators.pop();
            reversedOperators.push(operator);
        }

       while (reversedNumbers.size()>1){
           int firstNumber = reversedNumbers.pop();
           String operator = reversedOperators.pop();
           int secondNumber = reversedNumbers.pop();
           int result = 0;
           if (operator.equals("+")){
               result=firstNumber + secondNumber;
           }else {
               result = firstNumber-secondNumber;
           }
           reversedNumbers.push(result);

       }

        System.out.println(reversedNumbers.peek());

    }
}
