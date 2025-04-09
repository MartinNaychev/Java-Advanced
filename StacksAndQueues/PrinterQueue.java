package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> files = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (files.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.printf("Canceled %s%n",files.poll());
                }

            }else {
                files.offer(input);
            }

            input= scanner.nextLine();
        }

       while (!files.isEmpty()){
           System.out.println(files.poll());
       }

    }
}
