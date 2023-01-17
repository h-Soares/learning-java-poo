package entities;

import java.util.ArrayList;
import java.util.List;

public class PrintServiceNoGenerics {
    private List<Integer> numbers = new ArrayList<>();

    public void addValue(int value) {
        numbers.add(value);
    }

    public int first() {
        if(numbers.isEmpty())
            throw new IllegalStateException("The list is empty");

        return numbers.get(0);
    }

    public void print() {
        System.out.println(numbers);
    }
}