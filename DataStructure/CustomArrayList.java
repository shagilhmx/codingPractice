package DataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayList<T> implements DataStructure<T> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 1;
    private Object elements[];

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T e) {
        if (size == elements.length)
            ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        int newSize = elements.length + 1;
        elements = Arrays
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        return false;
    }

}
