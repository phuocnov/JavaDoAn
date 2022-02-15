package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Book {
    String ID;
    String name;
    String author;
    String category;
    Position position;
    int number;
    int numberAvaiable;

    // Use constructor for import data from file
    Book(String ID, String name, String author, String category, Position position, int number, int numberAvaiable){
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.category = category;
        this.position= position;
        this.number = number;
        this.numberAvaiable = numberAvaiable;
    }
    Book(){

    }

    // Use this for create new book with auto-genagrated ID
    public void createNewbook(String name, String author, String category, Position position, int number, int numberAvaiable){
        this.name = name;
        this.author = author;
        this.category = category;
        this.position = position;
        this.number = number;
        this.numberAvaiable = numberAvaiable;
        this.ID = generateID();
    }
    private String generateID(){
        String rs = "";
        File file = new File("data/book.txt");
        try{
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String strLine;
            if((strLine = br.readLine())!= null){
                rs = String.valueOf(this.name.charAt(0)).toUpperCase()+ String.valueOf(this.name.charAt(this.name.length() - 1)).toUpperCase() + strLine;
                System.out.println("ID" + rs);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return rs;
    }

    public String print(){
        String rs = "|ID: " + this.ID + " | Name: " + this.name + " | Author: " + this.author + " | Category: " + this.category + " | Shelve: " + this.position.shelve + " | Floor: " + this.position.floor + " | Available: " + this.numberAvaiable + "/" + this.number;
        System.out.println(rs);

        return rs;
    }
}
