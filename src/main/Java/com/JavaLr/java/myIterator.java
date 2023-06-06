package com.JavaLr.java;

public class myIterator<E extends Comparable<E>> {

    private myList<E> list = new myList<E>();

    public myIterator(myList<E> list){
        this.list = list;
    }

    public void forEch(Action<E> a){
        myNode<E> temp = list.getHead();
        if(temp != null)
            for(int i = 0; i < list.getSize();i++){
                a.toDo(temp.data);
                temp = temp.next;
            }
    }

}
