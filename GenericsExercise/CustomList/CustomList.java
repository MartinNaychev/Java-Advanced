package GenericsExercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> customList;
    public int size;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
        this.size++;
    }

    public T remove(int index) {
        this.size--;
        return this.customList.remove(index);
    }

    public boolean contains(T element) {
        return this.customList.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.customList, index1, index2);
    }

    public int grater(T element) {
        int counter = 0;
        for (T curentElement : customList) {
            if (curentElement.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = this.customList.getFirst();
        for (T element : customList) {
            if (element.compareTo(max) > 0) {
                max = element;
            }

        }
        return max;
    }

    public T getMin() {
        T min = this.customList.getFirst();
        for (T element : customList) {
            if (element.compareTo(min) < 0) {
                min = element;
            }

        }
        return min;
    }

    public T get(int index) {
        return this.customList.get(index);
    }
}
