package WorkingWithAbstractionExercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankInput = scanner.nextLine();
        String suitInput = scanner.nextLine();

        int power = RankPowers.valueOf(rankInput).getPower()  +SuitPowers.valueOf(suitInput).getPower();
        System.out.printf("Card name: %s of %S; Card power: %d%n",rankInput,suitInput,power);
    }
}
