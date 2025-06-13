package IteratorsAndComparatorsExercise.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        Set<Person> setByName = new TreeSet<>(new ComparatorByName());
        Set<Person> setByAge = new TreeSet<>(new ComparatorByAge());

        while (rows-->0){

            String[] parts = scanner.nextLine().split("\\s+");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);

            Person person = new Person(name, age);
            setByName.add(person);
            setByAge.add(person);


        }

        setByName.forEach(System.out::println);
        setByAge.forEach(System.out::println);
    }
}
