
package WorkingWithAbstractionExercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantity = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long zlato = 0;
        long kamuni = 0;
        long mangizi = 0;

        for (int i = 0; i < itemsAndQuantity.length; i += 2) {
            String name = itemsAndQuantity[i];
            long quantity = Long.parseLong(itemsAndQuantity[i + 1]);

            String type = "";


            if (name.length() == 3) {
                type = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                type = "Gold";
            }

            if (type.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (type) {
                case "Gem":
                    if (!bag.containsKey(type)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(type).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(type)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(type).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }


            bag.putIfAbsent((type), new LinkedHashMap<String, Long>());


            if (!bag.get(type).containsKey(name)) {
                bag.get(type).put(name, 0L);
            }


            bag.get(type).put(name, bag.get(type).get(name) + quantity);
            if (type.equals("Gold")) {
                zlato += quantity;
            } else if (type.equals("Gem")) {
                kamuni += quantity;
            } else if (type.equals("Cash")) {
                mangizi += quantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}