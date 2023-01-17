package entities;

import java.util.ArrayList;
import java.util.List;

public class PrintServiceWithGenerics<T> { //tipo T QUALQUER
    private List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if(list.isEmpty())
            throw new IllegalStateException("The list is empty");

        return list.get(0);
    }

    public void print() {
        System.out.println(list);
    }
}