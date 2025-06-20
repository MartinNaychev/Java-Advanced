package ExamPreparation.exam7.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            data.add(kid);
        }
    }

    public Kid getKid(String street) {
        for (Kid kid : data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }

    public boolean removeKid(String name) {
        Kid kidForRemove = null;
        for (Kid kid : data) {
            if (kid.getName().equals(name)) {
                kidForRemove = kid;
            }
        }
        return data.remove(kidForRemove);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children who visited a house for candy:");
        for (Kid kid : data) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format("%s from %s street", kid.getName(), kid.getStreet()));
        }


        return stringBuilder.toString();
    }
}
