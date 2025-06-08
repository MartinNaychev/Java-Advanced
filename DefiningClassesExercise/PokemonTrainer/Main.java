package DefiningClassesExercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {

            String[] parts = input.split("\\s+");
            String trainerName = parts[0];
            String pokemonName = parts[1];
            String pokemonElement = parts[2];
            int pokemonHealth = Integer.parseInt(parts[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer());
            }
            trainers.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String element = input;

            trainers.forEach((key, value) -> {
                for (Pokemon pokemon : value.getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        value.setBadges(value.getBadges() + 1);
                        break;

                    } else {
                        pokemon.setHealth(pokemon.getHealth() - 10);

                        if (pokemon.getHealth() <= 0) {
                            value.getPokemons().remove(pokemon);
                            break;
                        }
                    }
                   // if (value.getPokemons().size() == 1) {
                   //     break;
                   // }

                }
            });


            input = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((a, b) -> {
                    return b.getValue().getBadges() - a.getValue().getBadges();

                })
                .forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue().getBadges() + " " + e.getValue().getPokemons().size());
                });

        System.out.println();

    }
}
