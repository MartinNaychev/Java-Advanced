package IteratorsAndComparatorsExercise.ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator <String> implements Iterable<String> {

    private List<String> text;
    int index = 0;

    public ListyIterator() {
        this.text = new ArrayList<>();
    }

    public ListyIterator(String ... elements) {
        this.text = Arrays.asList(elements);
    }

    public void print() {
        if (text.isEmpty()) {
            System.out.println("Invalid Operation!");
        }else {
        System.out.println(this.text.get(index));
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {


            @Override
            public boolean hasNext() {
                return index < text.size()-1;
            }

            @Override
            public String next() {

                String indexText = text.get(index);
                index++;

                return indexText;
            }
        };
    }


    public void printAll() {
        this.text.forEach(line -> System.out.print(line + " "));
        System.out.println();
    }
}
