package SetsAndMapsExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Set<String>> hands = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", ");
            if (hands.containsKey(name)) {
                for (String card : cards) {
                    hands.get(name).add(card);
                }

            } else {
                hands.putIfAbsent(name, new HashSet<>());
                for (String card : cards) {
                    hands.get(name).add(card);
                }
            }

            input = scanner.nextLine();
        }


        for (var entry : hands.entrySet()) {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int value = getValue(cards);
            System.out.printf("%s: %d%n",name,value);

        }


    }

    private static int getValue(Set<String> cards) {
        int value = 0;

        for (String card : cards) {
            char[] cardSymbols = card.toCharArray();

            String symbol = String.valueOf(cardSymbols[0]);
            String symbolType = String.valueOf(cardSymbols[1]);
            if (symbolType.equals("0")){
                 symbolType = String.valueOf(cardSymbols[2]);
                int type = validateType(symbolType);
                value += 10 * type;


            }else {

                int power = validatePower(symbol);
                int type = validateType(symbolType);
                value += power * type;
            }

        }


        return value;
    }

    private static int validateType(String symbolType) {
        int type = 0;
        switch (symbolType){
            case "S" -> type=4;
            case "H" -> type=3;
            case "D" -> type=2;
            case "C" -> type=1;
        }


        return type;
    }

    private static int validatePower(String symbol) {
        int power = 0;

        switch (symbol) {
            case "1" -> power = 1;
            case "2" -> power = 2;
            case "3" -> power = 3;
            case "4" -> power = 4;
            case "5" -> power = 5;
            case "6" -> power = 6;
            case "7" -> power = 7;
            case "8" -> power = 8;
            case "9" -> power = 9;

            case "J" -> power = 11;
            case "Q" -> power = 12;
            case "K" -> power = 13;
            case "A" -> power = 14;
        }

        return power;
    }


}
