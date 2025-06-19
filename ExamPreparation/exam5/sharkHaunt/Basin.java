package ExamPreparation.exam5.sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public Shark getShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    public int getCount() {
        return sharks.size();
    }

    public boolean removeShark(String kind) {
        Shark shark = getShark(kind);
        return sharks.remove(shark);
    }

    public Shark getLargestShark(){
        Shark largestShark = null;
        int sizeOfLargestShark = 0;
        for (Shark shark : sharks) {
            if (shark.getLength()>sizeOfLargestShark){
                sizeOfLargestShark=shark.getLength();
                largestShark=shark;
            }
        }

        return largestShark;
    }
    public int getAverageLength(){
        int counter = 0;
        int lengthSum = 0;
        for (Shark shark : sharks) {
            counter++;
            lengthSum+=shark.getLength();
        }
        return lengthSum/counter;
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Sharks in %s:",this.name));

        for (Shark shark : sharks) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.",shark.getKind(),shark.getLength(),shark.getFood(),shark.getHabitation()));
        }
        return stringBuilder.toString();
    }
}
