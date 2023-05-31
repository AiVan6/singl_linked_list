package com.company;

public class myNode<E extends Comparable<E>> extends myList<E>  {
    E data;
    myNode<E> next;

    myNode(E data){
        this.data = data;
        this.next = null;
    }

    public int compare(myNode<E> other) {
        return this.data.compareTo(other.data);
    }

}
