package Generics.ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils{

    public static <T extends Comparable<T>> T getMin (List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }
        return Collections.min(list);
    }
    public static <T extends Comparable<T>> T getMax (List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }
        return Collections.max(list);
    }


}
