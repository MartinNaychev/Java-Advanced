package Exam.campers;

import java.util.ArrayList;
import java.util.List;

public class Campsite {
    private String name;
    private int availableTents;
    private List<Camper> campers;

    public Campsite(String name, int availableTents) {
        this.name = name;
        this.availableTents = availableTents;
        this.campers = new ArrayList<>();
    }

    public String addCamper(Camper camper) {
        if (camper.getHasTent()) {
            campers.add(camper);
        } else {
            if (availableTents > 0 && camper.getBudget() >= 30) {
                campers.add(camper);
              //  availableTents--;
              //  camper.setBudget(camper.getBudget()-30);
            } else if (camper.getBudget() < 30) {
                return String.format("%s cannot afford to rent a tent.", camper.getName());
            } else {
                return String.format("No available tents at %s.", this.name);
            }
        }

        return String.format("Camper %s joined the campsite.",camper.getName());
    }

    public Camper getCamper(String name) {
        for (Camper camper : campers) {
            if (camper.getName().equals(name)) {
                return camper;
            }
        }
        return null;
    }

    public int getCount() {
        return campers.size();
    }

    public boolean removeCamper(String name) {
        Camper camper = getCamper(name);
        return campers.remove(camper);
    }

    public String getMostExperiencedCamper() {

        if (campers.isEmpty()) {
            return String.format("There are no Exam.campers at %s.", this.name);
        } else {
            int mostExperiencedCamper = 0;
            String mostExperiencedCamperName = "";

            for (Camper camper : campers) {
                if (camper.getExperienceLevel() > mostExperiencedCamper) {
                    mostExperiencedCamper = camper.getExperienceLevel();
                    mostExperiencedCamperName = camper.getName();
                }

            }

            return String.format("%s has the most camping experience with %d trips.", mostExperiencedCamperName, mostExperiencedCamper);

        }
    }


    public String getCampersWithPersonalTents() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasACamperWithTent = false;
        List<String> campersNames = new ArrayList<>();

        for (Camper camper : campers) {
            if (camper.getHasTent()) {
                hasACamperWithTent = true;
                campersNames.add(camper.getName());
            }

        }
        if (!hasACamperWithTent) {
            stringBuilder.append(String.format("No Exam.campers currently at %s.", this.name));
        } else {
            stringBuilder.append("Campers with their own tents: ");
            stringBuilder.append(campersNames.toString().replace("[", "").replace("]", ""));
        }

        return stringBuilder.toString();
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
        if (!campers.isEmpty()) {
            stringBuilder.append(String.format("Campsite %s hosts the following Exam.campers:", this.name));
            for (Camper camper : campers) {
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(String.format("%d. %s with %d camping trips.", counter, camper.getName(), camper.getExperienceLevel()));
                counter++;


            }
        } else {
            stringBuilder.append(String.format("There are no Exam.campers at %s.", this.name));
        }

        return stringBuilder.toString();
    }

}
