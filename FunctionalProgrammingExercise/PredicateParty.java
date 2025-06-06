package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> invitedGuests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        Predicate<String> removeOrDouble = input -> input.contains("Remove");
        Predicate<String> isItStart = input -> input.contains("Start");
        Predicate<String> isItEnd = input -> input.contains("End");
        Predicate<String> isItLength = input -> input.contains("Length");



        while (!command.equals("Party!")) {
            String textBound = command.split("\\s+")[2];

            if (removeOrDouble.test(command)) {
                if (isItStart.test(command)) {
                    invitedGuests.removeIf(guest -> guest.startsWith(textBound));

                } else if (isItEnd.test(command)) {
                    invitedGuests.removeIf(guest -> guest.endsWith(textBound));

                } else if (isItLength.test(command)) {
                    int range = Integer.parseInt(textBound);
                    invitedGuests.removeIf(guest -> guest.length() == range);
                }


            } else {
                List<String> guestsToAdd = new ArrayList<>();

                if (isItStart.test(command)) {
                    for (String guest : invitedGuests) {
                        if (guest.startsWith(textBound)) {
                            guestsToAdd.addFirst(guest);
                        }
                    }
                    invitedGuests.addAll(guestsToAdd);

                } else if (isItEnd.test(command)) {
                    for (String guest : invitedGuests) {
                        if (guest.endsWith(textBound)) {
                            guestsToAdd.addFirst(guest);
                        }
                    }
                    invitedGuests.addAll(guestsToAdd);

                } else if (isItLength.test(command)) {
                    int range = Integer.parseInt(textBound);
                    for (String guest : invitedGuests) {
                        if (guest.length() == range) {
                            guestsToAdd.addFirst(guest);
                        }
                    }
                    invitedGuests.addAll(guestsToAdd);

                }

            }


            command = scanner.nextLine();
        }

        if (invitedGuests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {

            System.out.println(invitedGuests.stream()
                    .sorted()
                    .toList()
                    .toString()
                    .replace("[", "")
                    .replace("]", "")
                    + " are going to the party!");

        }

    }
}
