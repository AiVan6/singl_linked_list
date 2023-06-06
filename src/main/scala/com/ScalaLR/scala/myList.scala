package com.ScalaLR.scala

import java.awt.TextArea

import com.JavaLr.java.ImyList


class myList[E<: Comparable[E]] extends ImyList[E] with Serializable {

  private var head: myNode[E] = _ // первый элемент списка
  private var tail: myNode[E] = _ // последний элемент списка
  private var size: Int = 0 // размер списка

  override def push_back(data: E): Unit = {
    val node = new myNode[E](data) // узел заполняется данными
    if (head == null) {//списко пуст
      head = node
    } // Если первого элемента нет, то инициализируем
    if (tail != null) {
      tail.next = node
    } // Если есть последний элемент, инициализируем ссылку на следующий
    tail = node // Инициализируем/переопределяем последний элемент
    size += 1
  }

  override def printList(): Unit = {
    var node: myNode[E] = head // Предаем во временную переменную "Голову"
    // Если "Голова" элемент инициализирован
    while (node != null) {
      println(node) // Отображаем данные узла, через Enter
      node = node.next // Переходим к следующему элементу
    }
  }

  def printTextForTextArea(text:TextArea): Unit ={
    var node: myNode[E] = head // Предаем во временную переменную "Голову"
    // Если "Голова" элемент инициализирован
    var str:String =""
    while (node != null) {
      str += node.toString + "\n" // Отображаем данные узла, через Enter
      node = node.next // Переходим к следующему элементу
    }
    text.setText(str)
  }

  override def get(index: Int): E = {
    var node:myNode[E] = head;
    var count:Int = 0;//создается счетчик
    //Если есть "Голова"
    while (node != null) {
      //Проверка есть ли такой индекс
      if (index == count)
        return node.data;
      node = node.next;//переход к следующему элементу
      count+=1;
    }
    println("Element missing");//Если не нашелся нужный индекс
    throw new NoSuchElementException;
  }

  override def insert(index: Int, data: E): Unit = {
    var node: myNode[E] = head
    var temp: myNode[E] = head // предыдущий узел
    val newNode: myNode[E] = new myNode[E](data) // новый узел
    var count: Int = 0
    // Если есть "Голова"
    while (node != null) {
      // Добавление в начало
      if (index == 0) {
        newNode.next = node // устанавливаем ссылку на следующий элемента
        head = newNode // переопределяем "Голову"
        size += 1
        return
      }
      // Если не вышел на пределы списка
      if (count == index) {
        temp.next = newNode
        newNode.next = node
        size += 1
      }
      count += 1
      temp = node // проинициализируем предыдущий элемент
      node = node.next // переход к следующему
    }
  }

  override def removeIndex(index: Int): Unit = {
    var node: myNode[E] = head
    var prev: myNode[E] = head
    var count: Int = 0
    // Если есть "Голова"
    while (node != null) {
      // Удадение первого узла списка
      if (index == 0) {
        head = node.next
        size -= 1
        return
      }
      // Если не вышел на пределы списка
      if (count == index) {
        // Изменяем ссылку предыдущего узла
        prev.next = node.next
        node = null
        size -= 1
        return
      }
      // переопределение предыдущего элемента
      prev = node
      node = node.next // переход к следующему
      count += 1
    }
    size -= 1
  }


  //Сортировка Однократного слияния
  override def sort(): Unit = {
    head = oneTimeMergeSort(head)
  }

  private def oneTimeMergeSort(head: myNode[E]): myNode[E] = {
    if (head == null || head.next == null) {
      return head
    }

    val middle = findMiddle(head)
    val nextToMiddle = middle.next
    middle.next = null

    val left = oneTimeMergeSort(head)
    val right = oneTimeMergeSort(nextToMiddle)

    merge(left, right)
  }

  private def merge(left: myNode[E], right: myNode[E]): myNode[E] = {
    val dummy = new myNode[E](null.asInstanceOf[E])
    var current = dummy

    var leftPtr = left
    var rightPtr = right

    while (leftPtr != null && rightPtr != null) {
      if (leftPtr.data.asInstanceOf[Comparable[E]].compareTo(rightPtr.data) < 0) {
        current.next = leftPtr
        leftPtr = leftPtr.next
      } else {
        current.next = rightPtr
        rightPtr = rightPtr.next
      }
      current = current.next
    }

    if (leftPtr != null) {
      current.next = leftPtr
    } else {
      current.next = rightPtr
    }

    dummy.next
  }

  private def findMiddle(head: myNode[E]): myNode[E] = {
    if (head == null) {
      return null
    }

    var slow = head
    var fast = head.next

    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }

    slow
  }

  def getHead: myNode[E] = head

  override def getSize: Int = size
}
