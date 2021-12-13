package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

enum Category{
    SACH_GIAO_KHOA,
    TRIET_HOC_TAM_LY,
    TON_GIAO,
    KHOA_HOC_TU_NHIEN,
    CONG_NGHE,
    NGHE_THUAT,
    VAN_HOC,
    DIA_LY_LICH_SU
}

public class Book {
    String ID;
    String name;
    Category category;
    Position position;
    int number;
    int numberAvaiable;

    // Use constructor for import data from file
    Book(String ID, String name, Category category, Position position, int number, int numberAvaiable){
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.position= position;
        this.number = number;
        this.numberAvaiable = numberAvaiable;
    }

    // Use this for create new book with auto-genagrated ID
    public void createNewbook(String name, Category category, Position position, int number, int numberAvaiable){
        this.ID = generateID();
    }
    private String generateID(){
        // String ID = "";
        File file = new File("data/book.txt");
        try{
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String strLine;
            if((strLine = br.readLine())!= null){
                ID = String.valueOf(this.name.charAt(0)+ String.valueOf(this.name.charAt(this.name.length() - 1)) + strLine);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return ID;
    }

    public void print(){
        System.out.println("ID: " + this.ID + "Name");
    }
}
