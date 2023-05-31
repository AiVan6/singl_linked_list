package com.company;

import java.io.*;

public class DataSerializable<E extends Comparable<E>> {

    public void serializeToBinary(myList<E> data, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(data);
        oos.close();
    }

    public static Object deserializeFromBinary(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        Object data = ois.readObject();
        ois.close();
        return data;
    }

}
