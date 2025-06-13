package IteratorsAndComparatorsExercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] parts = input.split("\\s+");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String town = parts[2];

            Person person = new Person(name,age,town);

            people.add(person);


            input = scanner.nextLine();
        }


        int index = Integer.parseInt(scanner.nextLine())-1;

        Person specialPerson = people.get(index);

        int countEquals = 0;

        for (Person person : people) {
            if (person.compareTo(specialPerson)==0){
                countEquals++;
            }
        }
        if (countEquals==1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d",countEquals,people.size()-countEquals, people.size());
        }

    }
}
