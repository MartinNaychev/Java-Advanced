package ExamPreparation.exam3.vintageLocos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainStation {

    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() < capacity && railGauge == locomotive.getGauge()) {
            locomotives.add(locomotive);

        } else if (locomotives.size() >= capacity) {
            System.out.println("This train station is full!");

        } else {
            System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.%n", Math.abs(this.railGauge - locomotive.getGauge()));

        }
    }


    public Locomotive getLocomotive(String name) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getName().equals(name)) {
                return locomotive;
            }
        }
        return null;
    }

    public boolean removeLocomotive(String name) {
        Locomotive locomotive = getLocomotive(name);
        return locomotives.remove(locomotive);
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {

        LocalDate oldestDate = LocalDate.MAX;
        Locomotive oldestLocomotive = null;

        for (Locomotive locomotive : locomotives) {
            if (locomotive.getBuildDate().isBefore(oldestDate)) {
                oldestDate = locomotive.getBuildDate();
                oldestLocomotive = locomotive;
            }

        }
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        } else {
            return String.format("%s", oldestLocomotive.getName());
        }

    }

    public String getFastestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        } else {
            int maxSpeed = 0;
            Locomotive fastestLocomotive = null;
            for (Locomotive locomotive : locomotives) {
                if (locomotive.getMaxSpeed() > maxSpeed) {
                    maxSpeed = locomotive.getMaxSpeed();
                    fastestLocomotive = locomotive;
                }
            }
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.", fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());
        }
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
        if (locomotives.isEmpty()) {
            stringBuilder.append(String.format("There are no locomotives departing from %s station.", this.name));

        } else {

            stringBuilder.append("Locomotives departed from ").append(this.name + ":");
            for (Locomotive locomotive : locomotives) {
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(String.format("%d. ",counter));
                counter++;
                stringBuilder.append(locomotive.getName());
            }
        }
        return stringBuilder.toString();

    }
}
