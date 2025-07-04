package GenericsExercise.CustomListSort;

public class Sorted {


    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {

        for (int i = 0; i < customList.size; i++) {
            T currentElement = customList.get(i);
            for (int j = i + 1; j < customList.size; j++) {
                T nextElement = customList.get(j);
                if (currentElement.compareTo(nextElement) > 0) {
                    customList.swap(i, j);
                }

            }

        }

    }
}
