package org.example;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    Object[] arr = new Object[10];
    private int arrLength = 10;
    private int numberOfElements = 0;
    public ListIteratorImpl listIterator = new ListIteratorImpl();


    @Override
    public void add(Object object) {
        arr[numberOfElements] = object;
        numberOfElements++;
        isFool();
    }

    @Override
    public void insert(int pos, Object object) {
        try {
            if (pos > numberOfElements - 1 || pos < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        Object[] arr = new Object[arrLength];
        int j = 0;
        for (int i = 0; i < pos; i++) {
            arr[j] = this.arr[i];
            j++;
        }
        arr[pos] = object;
        j++;
        for (int i = pos; i < numberOfElements; i++) {
            arr[j] = this.arr[i];
            j++;
        }
        numberOfElements++;
        this.arr = arr;
        isFool();
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public void remove(Object t) {
        int index = (int) t;
        Object[] arr = new Object[numberOfElements];
        for (int i = 0; i < index; i++) {
            arr[i] = this.arr[i];
        }
        for (int i = index + 1; i < numberOfElements; i++) {
            arr[i - 1] = this.arr[i];
        }
        this.arr = arr;
        numberOfElements--;
    }

    public boolean equals(ListImpl list){
        return toString().equals(list.toString());
    }
    public String toString() {
        String toString = "";
        for (int i = 0; i < numberOfElements; i++) {
            toString = toString + arr[i] + " ";
        }
        return toString;
    }


    private void isFool() {
        if (numberOfElements == arrLength) {
            Object[] arr = new Object[arrLength * 2];
            for (int i = 0; i < arrLength; i++) {
                arr[i] = this.arr[i];
            }
            this.arr = arr;
            arrLength *= 2;
        }
    }

    class ListIteratorImpl implements ListIterator {
        private int iteration = 0;

        @Override
        public boolean hasNext() {
            return arr[iteration] != null;
        }

        @Override
        public Object next() {
            try {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException(e);
            }
            return arr[iteration++];
        }
    }
}
