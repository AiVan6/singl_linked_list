package com.company;

public class myNode<E extends Comparable<E>> extends myList<E>  {
    E data;//Экземпляр для данный
    myNode<E> next; // Сыылка на следующий узел
    //конструктор для иницализции
    myNode(E data){
        this.data = data;
        this.next = null;
    }
}
