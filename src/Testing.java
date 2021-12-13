package src;

import java.util.ArrayList;

public class Testing {
    public static void printReaders(ArrayList<Reader> readers, int readerSize){
        System.out.println("Reader Size: " + readerSize);
        for (Reader reader : readers) {
            reader.print();
        }
    }
}
