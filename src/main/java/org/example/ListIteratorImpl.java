package org.example;

import java.util.NoSuchElementException;

public class ListIteratorImpl implements ListIterator{
    private ListImpl list;
    private int iteration=0;

    public ListIteratorImpl(ListImpl list) {
        this.list=list;
    }

    public void iterate(ListImpl list){
        this.list=list;
    }
    @Override
    public boolean hasNext() {
        return list.arr[iteration]!=null;
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
        return list.arr[iteration++];

    }
}
