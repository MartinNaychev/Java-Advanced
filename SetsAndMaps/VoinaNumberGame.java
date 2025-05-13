package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getCards(scanner);
        LinkedHashSet<Integer> secondPlayer = getCards(scanner);
        int rounds = 50;

        while (rounds-->0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()){
            int firstPlayerCard = getCard(firstPlayer);
            int secondPlayerCard = getCard(secondPlayer);
            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard>secondPlayerCard){
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            }else if (secondPlayerCard>firstPlayerCard){
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }


        }
        if (firstPlayer.size()== secondPlayer.size()){
            System.out.println("Draw");
        } else if (firstPlayer.size()< secondPlayer.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("First player win!");
        }


    }

    private static int getCard(LinkedHashSet<Integer> firstPlayer) {
        for (Integer card : firstPlayer) {
            return card;
        }
        return 0;
    }

    private static LinkedHashSet<Integer> getCards(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
