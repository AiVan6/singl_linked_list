package com.company;

import java.io.Serializable;
import java.util.*;

public class myList<E extends Comparable<E>> implements ImyList<E>, Serializable {
    private myNode<E> head;
    private myNode<E> tail;
    private int size = 0;

    public void push_back(E data){
        myNode<E> node = new myNode<E>(data);
        if(head == null){head = node;}
        if(tail != null){tail.next = node;}
        tail = node;
        size++;
    }

    public void printList(){
        myNode<E> node = head;
        while (node != null){
            System.out.println(node.data);
            if(node.next != null)
                node = node.next;
            else
                break;
        }
    }

    public E get(int index){
        myNode<E> node = head;
        int count = 0;
        while (node != null){
            if(index == count)
                return node.data;
            node = node.next;
            count++;
        }
        System.out.println("Element missing");
        return null;
    }

    public myNode<E> getHead(){
        return head;
    }

    public void insert(int index, E data){// сделат если список пустой
        myNode<E> node = head;
        myNode<E> temp = head;
        myNode<E> newNode = new myNode<E>(data);
        int count = 0;

        while(node != null){
            if(index==0){
                newNode.next = node;
                head = newNode;
                size++;
                return;
            }
            if(count == index) {
                temp.next = newNode;
                newNode.next = node;
                size++;
            }
            count++;
            temp = node;
            node = node.next;
        }
    }

    public int getSize(){
        return size;
    }

    public void removeIndex(int index){
        myNode<E> node = head;
        myNode<E> temp = head;
        int count = 0;

        while (node != null){
            if(count == index){
                temp.next = node.next;
                node = null;
                size--;
                return;
            }
            temp = node;
            node = node.next;
            count++;
        }
        size--;
    }

    @Override
    public void sort(){
        if(head == null || head.next == null) {
            return;
        }

        myNode<E> curr = head;
        myNode<E> sortNode = null;

        while(curr != null){
            myNode<E> temp = curr.next;

            sortNode = insertSort(sortNode,curr);

            curr = temp;
        }

        head = sortNode;
    }

    private myNode<E> insertSort(myNode<E> sortNode, myNode<E> newNode){

        if(sortNode == null || newNode.data.compareTo(sortNode.data) < 0){
            newNode.next = sortNode;
            return newNode;
        }

        myNode<E> curr = sortNode;
        while (curr.next != null && newNode.data.compareTo(curr.next.data) > 0){
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        /*if(sortNode == null || newNode.data.compareTo(sortNode.data) < 0){
            newNode.next = sortNode;
            return newNode;
        }

        if (sortNode != null && newNode.data.compareTo(sortNode.data)>0){

        }

        return sortNode;*/
        return sortNode;
    }

}
