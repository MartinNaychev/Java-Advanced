package ExamPreparation.exam4.spaceCrafts;

import java.util.ArrayList;
import java.util.List;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (spacecrafts.size() < capacity) {
            spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public Spacecraft getSpacecraft(String name) {
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public boolean removeSpacecraft(String name) {
        Spacecraft spacecraft = getSpacecraft(name);
        return spacecrafts.remove(spacecraft);
    }

    public String getHeaviestSpacecraft() {
        int weight = 0;
        String name = "";
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getWeight() > weight) {
                weight = spacecraft.getWeight();
                name = spacecraft.getName();
            }
        }
        return String.format("%s - %dkg.", name, weight);
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftsByMissionType = new ArrayList<>();
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                spacecraftsByMissionType.add(spacecraft);
            }
        }
        if (spacecraftsByMissionType.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
            return null;
        } else {
            return spacecraftsByMissionType;
        }
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Spacecrafts launched from %s:", name));
        int counter = 1;

        if (spacecrafts.isEmpty()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("none");

        } else {
            for (Spacecraft spacecraft : spacecrafts) {
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(String.format("%d. ",counter));
                counter++;
                stringBuilder.append(spacecraft.getName());
            }

        }
        return stringBuilder.toString();
    }
}
