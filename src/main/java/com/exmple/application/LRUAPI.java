package com.exmple.application;

import java.util.LinkedList;

public class LRUAPI<T extends BaseClass> {
    LinkedList<T> list = new LinkedList();
    int threshold = 10;


    public void addElement(T value) {
        int size = list.size();
        if (size == threshold) {
            list.pop();
        }
        list.addLast(value);
    }

//    public List<Integer> getValues() {
//        List<Integer> toReturnList = new ArrayList<>();
//        list.forEach(l -> toReturnList.add(l));
//        return toReturnList;
//    }

    public T getValue(int id) {
        T toFetch = null;
        for (T obj : list) {
            if (obj.getId() == id)
                toFetch = obj;
        }
        if(toFetch != null) {
            list.remove(toFetch);
            list.addLast(toFetch);
        }
        return toFetch;
    }

//        public void printValues() {
//        getValues().forEach(elem -> System.out.println(elem));
//    }

}