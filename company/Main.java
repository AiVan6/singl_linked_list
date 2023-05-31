package com.company;


import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        myList<Integer> list = new myList<Integer>();

        list.push_back(6);
        list.push_back(5);
        list.push_back(88);
        list.push_back(12);
        list.push_back(7);
        list.push_back(10);

        list.insert(2,8);

        list.removeIndex(1);

        myIterator iterator = new myIterator(list);
        iterator.forEch(System.out::println);
        list.sort();
        list.printList();


        DataSerializable serializable = new DataSerializable();
        try {
            serializable.serializeToBinary(list,"save.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
