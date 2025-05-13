package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,LinkedHashMap<String, List<String>>>continents = new LinkedHashMap<>();
        int rows = Integer.parseInt(scanner.nextLine());

        while (rows-->0){
            String [] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String town = input[2];

            continents.putIfAbsent(continent,new LinkedHashMap<>());
            LinkedHashMap<String,List<String>>countries = continents.get(continent);
            countries.putIfAbsent(country,new ArrayList<>());
            countries.get(country).add(town);

        }
        for (var continent : continents.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (var country : continent.getValue().entrySet()) {
                String countryEntry = country.getKey();
                String towns = String.join(", ", country.getValue());

                System.out.printf("%s -> %s%n",countryEntry,towns);

            }


        }

    }
}
