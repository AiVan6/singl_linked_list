package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSerializable<E extends Comparable<E>> {

    public void serializeToBinary(myList<E> data, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(data);
        oos.close();
    }

}
