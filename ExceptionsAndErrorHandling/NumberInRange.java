package ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersRange = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = numbersRange[0];
        int end = numbersRange[1];

        System.out.printf("Range: [%d...%d]%n", start,end);


        while (true){
            String input = scanner.nextLine();
            try{
                int number = Integer.parseInt(input);

                if (number>=start && number<=end){
                    System.out.println("Valid number: " + number);
                    break;
                }else {
                    System.out.println("Invalid number: " + number);
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid number: " + input);
            }





        }
    }
}
