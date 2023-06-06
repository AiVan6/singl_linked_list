package com.ScalaLR.scala

import java.awt._
import java.awt.event.{ActionEvent, ActionListener}

import javax.swing
import javax.swing.{JButton, JFrame, JPanel, WindowConstants}

class myApp extends App{
  // Создание главного окна
  private var button1: JButton = _
  private var frame:JFrame = _
  private var textArea:TextArea = _
  private var textAreaResult:TextArea = _
  private var buttonPanel:JPanel = _

  private var list:myList[Integer] = _
  private var data:DataSerializable[Integer] = _

  private var printButton:JButton =_
  private var insertButton:JButton =_
  private var removeButton:JButton =_
  private var sortButton:JButton =_
  private var pushBackButton:JButton =_
  private var getButton:JButton =_
  private var saveButton:JButton =_
  private var loadingButton:JButton =_



  def createWindow():Unit ={
    frame = new JFrame("Мое окно")
    frame.setLayout(new BorderLayout())
    textArea = new TextArea()
    textAreaResult = new TextArea()
    buttonPanel = new JPanel()

    list = new myList[Integer]()
    data = new DataSerializable[Integer]()
    // Установка параметров окна
    frame.setSize(700, 300)
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
  }


  def addButton():Unit ={

    // Создание текстового поля для отображения состояния
    frame.add(textArea, BorderLayout.CENTER)
    textAreaResult.setEnabled(false)
    frame.add(textAreaResult, BorderLayout.EAST)

    // Создание панели с кнопками
    printButton =new JButton("print")
    printList()
    insertButton =new JButton("insert")
    insert()
    removeButton =new JButton("remove")
    removeIndex()
    sortButton =new JButton("sort")
    sort()
    pushBackButton =new JButton("push back")
    push_back()
    getButton = new JButton("get")
    get()
    saveButton = new JButton("save")
    save()
    loadingButton = new JButton("loading")
    loading()

    frame.add(buttonPanel, BorderLayout.SOUTH)
  }

  def push_back():Unit = {
    pushBackButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        list.push_back(textArea.getText().toInt)
        textArea.setText("")
      }
    })

    buttonPanel.add(pushBackButton)
  }

  def printList(): Unit = {
    printButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        list.printTextForTextArea(textAreaResult)
      }
    })
    buttonPanel.add(printButton)
  }

  def get(): Unit = {
    getButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        textAreaResult.setText(list.get(textArea.getText().toInt).toString)
        textArea.setText("")
      }
    })

    buttonPanel.add(getButton)
  }

  def insert(): Unit = {

    insertButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        var per = textArea.getText().toString.split(",")

        list.insert(per(0).toInt, per(1).toInt)
        textArea.setText("")
      }
    })
    buttonPanel.add(insertButton)
  }

  def removeIndex(): Unit = {
    removeButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        list.removeIndex(textArea.getText().toInt)
        textArea.setText("")
      }
    })
    buttonPanel.add(removeButton)
  }

  def sort(): Unit = {
    sortButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        list.sort()
      }
    })
    buttonPanel.add(sortButton)
  }

  def save():Unit={
    saveButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        data.serializeToBinary(list,"saveDataWin.txt")
      }
    })
    buttonPanel.add(saveButton)
  }

  def loading():Unit={
    loadingButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent): Unit = {
        var obj = data.deserializeFromBinary("saveDataWin.txt")
        list = obj.asInstanceOf[myList[Integer]]
      }
    })
    buttonPanel.add(loadingButton)
  }

  def run():Unit = {
    frame.setVisible(true)
  }

}
