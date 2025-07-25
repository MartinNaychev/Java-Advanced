package IteratorsAndComparatorsExercise.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{

private List<Integer>numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {


        return new Iterator<Integer>() {
            int evenIndex = 0;
            int oddIndex = 1;

            @Override
            public boolean hasNext() {
                return evenIndex<numbers.size() || oddIndex<numbers.size();
            }

            @Override
            public Integer next() {
                int number;
                if (evenIndex<numbers.size()){
                    number=numbers.get(evenIndex);
                    evenIndex+=2;
                }else {
                    number=numbers.get(oddIndex);
                    oddIndex+=2;
                }


                return number;
            }
        };
    }
}
