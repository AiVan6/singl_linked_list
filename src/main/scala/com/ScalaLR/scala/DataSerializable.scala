package com.ScalaLR.scala

import java.io._

class DataSerializable[E <: Comparable[E]] {
  def serializeToBinary(data: myList[E], filename: String): Unit = {
    val oos = new ObjectOutputStream(new FileOutputStream(filename))
    oos.writeObject(data)
    oos.close()
  }

  def deserializeFromBinary(filename: String): Any = {
    val ois = new ObjectInputStream(new FileInputStream(filename))
    val data = ois.readObject()
    ois.close()
    data
  }
}
