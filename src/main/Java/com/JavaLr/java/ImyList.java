package com.JavaLr.java;


public interface ImyList<E> {
    void push_back(E data);
    void printList();
    E get(int index);
    void insert(int index, E data);
    void removeIndex(int index);
    int getSize();
    void sort();
}
