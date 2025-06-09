package DefiningClassesExercise.Google;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        HashMap<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            String[] personParts = input.split("\\s+");
            String name = personParts[0];
            String command = personParts[1];

            if (!people.containsKey(name)) {
                people.put(name, new Person(name));
            }

            switch (command) {
                case "company" -> {

                    people.get(name).setCompany(new Company(personParts[2],personParts[3],Double.parseDouble(personParts[4])));
                }

                case "pokemon" ->{
                    people.get(name).addPokemon(new Pokemon(personParts[2],personParts[3]));
                }

                case "parents" ->{
                    people.get(name).addParent(new Parent(personParts[2],personParts[3]));
                }

                case "children" ->{
                    people.get(name).addChild(new Children(personParts[2],personParts[3]));
                }

                case "car" ->{
                    people.get(name).setCar(new Car(personParts[2],Integer.parseInt(personParts[3])));
                }

            }

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        System.out.println(people.get(name).toString());


    }


}
