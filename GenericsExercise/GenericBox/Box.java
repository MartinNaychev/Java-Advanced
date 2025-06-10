package GenericsExercise.GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : elements) {

            stringBuilder.append(element.getClass().getName()).append(": ");
            stringBuilder.append(element).append(System.lineSeparator());

        }


        return stringBuilder.toString();
    }

    public void swap(int index1, int index2) {
        Collections.swap(elements, index1, index2);
    }

    public int compare(T toCompare) {
        int count = 0;
        for (T element : elements) {
            if (element.compareTo(toCompare) > 0) {
                count++;

            }
        }

        return count;
    }
}
