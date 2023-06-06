package com.ScalaLR.scala

object Main {

  def main(args: Array[String]): Unit = {
    val list:myList[Integer] = new myList[Integer]
    print("Добавление в конец:")
    list.push_back(6)
    list.push_back(5)
    list.push_back(88)
    list.push_back(12)
    list.push_back(7)
    list.push_back(10)
    list.printList()

    println("Добавление в начало и середину")
    list.insert(0,5)
    list.insert(4,77)
    list.printList()
    val iterator = new myIterator[Integer](list)
    println("Iterator")
    iterator.forEach(println)

    println("Двоичный файл")
    //двичный файл
    val binar:DataSerializable[Integer] = new DataSerializable[Integer]()
    //сохранение списка в файл
    binar.serializeToBinary(list,"saveScalar.txt")
    val obj:Any = binar.deserializeFromBinary("saveScalar.txt")
    //загрузка
    val temp:myList[Integer] = obj.asInstanceOf[myList[Integer]]
    temp.printList()
    println("Сортировка")
    list.sort()
    list.printList()

    var window:myApp = new myApp()//Оконно приложение
    window.createWindow()
    window.addButton()
    window.run()

  }
}
