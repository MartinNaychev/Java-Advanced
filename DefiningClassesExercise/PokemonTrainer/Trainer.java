package DefiningClassesExercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private int badges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.badges = 0;
        this.pokemons= new ArrayList<>();
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}
