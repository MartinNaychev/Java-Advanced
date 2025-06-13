package IteratorsAndComparatorsExercise.StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {


    @Override
    public int compare(Person person1, Person person2) {

        int nameLength = Integer.compare(person1.getName().length(), person2.getName().length());


        if (nameLength == 0) {
            char firstNameFirstSymbol = person1.getName().toUpperCase().charAt(0);
            char secondNameFirstSymbol = person2.getName().toUpperCase().charAt(0);

            int firstSymbolCompare = Character.compare(firstNameFirstSymbol, secondNameFirstSymbol);

            return firstSymbolCompare;

        }

        return nameLength;
    }
}
