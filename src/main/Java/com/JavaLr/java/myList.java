package com.JavaLr.java;
/*Односвязный список*/


import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class myList<E extends Comparable<E>> implements ImyList<E>, Serializable {
    private myNode<E> head; //первый элемент списка
    private myNode<E> tail; // Последний элемент списка
    private int size = 0;// размер списка

    //Добавление в конец списка
    public void push_back(E data) {
        var node = new myNode<E>(data);//узел заполняется данными
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.next = node;
        }//Если есть последний элемент, инициализируем ссылку на следующий
        tail = node;//Инициализируем/переопределяем последний элемент
        size++;
    }

    //Отображение списка
    public void printList() {
        myNode<E> node = head;//Предаем во временную переменную "Голову"
        //Если "Голова" элемент инициализирован
        while (node != null) {
            System.out.println(node.data);//Отображаем данные узла, через Enter
            node = node.next; //Переходим к следующему элементу
        }
    }

    //Получение элемента по индексу
    public E get(int index) {
        myNode<E> node = head;
        int count = 0;//создается счетчик
        //Если есть "Голова"
        while (node != null) {
            //Проверка есть ли такой индекс
            if (index == count)
                return node.data;
            node = node.next;//переход к следующему элементу
            count++;
        }
        System.out.println("Element missing");//Если не нашелся нужный индекс
        throw new NoSuchElementException();
    }

    public myNode<E> getHead() {
        return head;
    }

    //Добавление по индексу
    public void insert(int index, E data) {
        myNode<E> node = head;
        myNode<E> temp = head;//предыдущий узел
        myNode<E> newNode = new myNode<E>(data);//новый узел
        int count = 0;
        //Если есть "Голова"
        while (node != null) {
            //Добавление в начало
            if (index == 0) {
                newNode.next = node;//устанавливаем ссылку на следующий элемента
                head = newNode;//переопределяем "Голову"
                size++;
                return;
            }
            //Если не вышел на пределы списка
            if (count == index) {
                temp.next = newNode;
                newNode.next = node;
                size++;
            }
            count++;
            temp = node;//проинициализируем предыдущий элемент
            node = node.next;//переход к следующему
        }
    }

    //Получение размера
    public int getSize() {
        return size;
    }

    //Удаление узла по индексу
    public void removeIndex(int index) {
        myNode<E> node = head;//
        myNode<E> prev = head;
        int count = 0;
        //Если есть "Голова"
        while (node != null) {
            //Удадение первого узла списка
            if (index == 0) {
                head = node.next;
                size--;
                return;
            }
            //Если не вышел на пределы списка
            if (count == index) {
                //Изменяем ссылку предыдущего узла
                prev.next = node.next;
                node = null;
                size--;
                return;
            }
            //переопределение предыдущего элемента
            prev = node;
            node = node.next;//переход к следующему
            count++;
        }
        size--;
    }

    //Сортировка Однократного слияния
    @Override
    public void sort(){
        head = oneTimeMergeSort(head);
    }

    private myNode<E> oneTimeMergeSort(myNode<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        myNode<E> middle = findMiddle(head);
        myNode<E> nextToMiddle = middle.next;
        middle.next = null;

        myNode<E> left = oneTimeMergeSort(head);
        myNode<E> right = oneTimeMergeSort(nextToMiddle);

        return merge(left, right);
    }

    private myNode<E> merge(myNode<E> left, myNode<E> right) {
        myNode<E> dummy = new myNode<E>(null);
        myNode<E> current = dummy;

        while (left != null && right != null) {
            if (left.data.compareTo(right.data) < 0) {//
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }

    private myNode<E> findMiddle(myNode<E> head) {
        if (head == null) {
            return null;
        }

        myNode<E> slow = head;
        myNode<E> fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    //Сортировка
   /* @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        myNode<E> curr = head;
        myNode<E> sortNode = null;

        while (curr != null) {
            myNode<E> temp = curr.next;//инициализация временного узла следующим после "Голова"

            sortNode = insertSort(sortNode, curr);//вызов сортировка вставками

            curr = temp;
        }

        head = sortNode;
    }

    //Сортировка вставками
    private myNode<E> insertSort(myNode<E> sortNode, myNode<E> newNode) {
        //Если начинаем сортировку с первого узла
        if (sortNode == null || newNode.data.compareTo(sortNode.data) < 0) {
            newNode.next = sortNode;
            return newNode;
        }
        //создание текущей переменной
        myNode<E> curr = sortNode;
        //преверяем два узла, какой больше
        while (curr.next != null && newNode.data.compareTo(curr.next.data) > 0) {
            curr = curr.next;
        }
        //меняем ссылки
        newNode.next = curr.next;
        curr.next = newNode;
        //возвращаем узел
        return sortNode;
    }*/

}