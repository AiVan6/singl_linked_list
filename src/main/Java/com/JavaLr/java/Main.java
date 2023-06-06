package com.JavaLr.java;


import scala.Int;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        myList<Integer> list = new myList<>();
        list.push_back(6);
        list.push_back(5);
        list.push_back(88);
        list.push_back(12);
        list.push_back(7);
        list.push_back(10);

        list.insert(2,8);

        list.removeIndex(0);

        //myIterator iterator = new myIterator(list);
        //iterator.forEch(System.out::println);

        list.sort();
        list.printList();
        //Загрузка данных в файл
        System.out.println("-------------------");
        DataSerializable<Integer> serializable = new DataSerializable<>();
        try {
            serializable.serializeToBinary(list,"save.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Выгрузка данных из двоичного файла
        try {
            Object obj = DataSerializable.deserializeFromBinary("save.txt");
            myList<Integer> temp = (myList<Integer>) obj;
            temp.printList();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
