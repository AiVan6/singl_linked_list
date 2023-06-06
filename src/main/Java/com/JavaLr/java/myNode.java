package com.JavaLr.java;

import java.io.Serializable;

public class myNode<E extends Comparable<E>> implements Serializable {
    E data;//Экземпляр для данный
    myNode<E> next; // Сыылка на следующий узел
    //конструктор для иницализции
    myNode(E data){
        this.data = data;
        this.next = null;
    }
}
