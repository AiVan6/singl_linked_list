package com.company;


public interface ImyList<E> {
    void push_back(E data);
    void printList();
    E get(int index);
    void insert(int index, E data);
    void removeIndex(int index);
    void sort();
}
