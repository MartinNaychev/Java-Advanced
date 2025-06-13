package IteratorsAndComparatorsExercise.ListyIterator;


import java.util.Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator<String> listyIterator = null;

        while (!input.equals("END")) {
            String[] parts = input.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "Create" -> {
                    if (parts.length > 1) {
                        listyIterator = new ListyIterator<>(Arrays.copyOfRange(parts, 1, parts.length));
                    } else {
                        listyIterator = new ListyIterator<>();
                    }
                }
                case "Move" ->{
                    if (listyIterator.iterator().hasNext()){
                        System.out.println(listyIterator.iterator().hasNext());
                        listyIterator.iterator().next();

                    }else {
                        System.out.println("false");
                    }
                }
                case "HasNext" -> System.out.println(listyIterator.iterator().hasNext());

                case "Print" ->{

                    listyIterator.print();
                   /* if (listyIterator.isEmpty()){
                        System.out.println("Invalid Operation!");
                    }else {
                        System.out.println(listyIterator.getText().get(listyIterator.index));
                    }*/
                }
                case "PrintAll" -> listyIterator.printAll();
            }
            input = scanner.nextLine();
        }



    }


}
