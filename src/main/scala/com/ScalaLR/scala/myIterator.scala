package com.ScalaLR.scala

import com.JavaLr.java.Action

class myIterator[E <: Comparable[E] ](private val list: myList[E]) {

  def forEach(a: Action[E]): Unit = {
    var temp: myNode[E] = list.getHead
    if (temp != null) {
      for (i <- 0 until list.getSize) {
        a.toDo(temp.data)
        temp = temp.next
      }
    }
  }
}
