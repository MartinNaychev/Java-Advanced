package DefiningClassesExercise.OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());

        while (peopleCount-- > 0) {
            String[] peopleInfo = scanner.nextLine().split("\\s+");
            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);
            Person person = new Person(name,age);
            peopleList.add(person);
        }

        peopleList= peopleList.stream().filter(person-> person.getAge()>30).collect(Collectors.toList());
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        peopleList.forEach(person -> System.out.println(person.toString()));
    }
}
