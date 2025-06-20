package ExamPreparation.exam6.fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            fishes.add(fish);
        }
    }

    public Fish getFish(String species) {
        Fish fishForReturn = null;
        for (Fish fish : fishes) {
            if (fish.getSpecies().equals(species)) {
                fishForReturn = fish;
            }
        }
        return fishForReturn;
    }

    public boolean removeFish(String species) {
        Fish fish = getFish(species);
        return fishes.remove(fish);
    }

    public Fish getOldestFish() {
        int oldestAge = 0;
        Fish oldestFish = null;

        for (Fish fish : fishes) {
            if (fish.getAge() > oldestAge) {
                oldestAge = fish.getAge();
                oldestFish = fish;
            }
        }
        return oldestFish;
    }

    public int getCount() {
        return fishes.size();
    }

    public int getVacancies() {
        return capacity - fishes.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fishes in the pond:");
        for (Fish fish : fishes) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format("This %s is %d years old and reproduces through %s.", fish.getSpecies(), fish.getAge(), fish.getMatingSeason()));

        }
        return stringBuilder.toString();
    }
}
