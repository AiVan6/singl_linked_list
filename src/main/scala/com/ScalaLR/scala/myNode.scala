package com.ScalaLR.scala
import java.io.Serializable

class myNode[E <: Comparable[E]](val data:E) extends Serializable{
  var next: myNode[E] = _ // Ссылка на следующий узел

  override def toString: String = data.toString// преобразование к строковому типу

  // Конструктор для инициализации
  def this(data: E, next: myNode[E]) = {
    this(data)
    this.next = next
  }
}
