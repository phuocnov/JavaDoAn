package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class BookController {
    public ArrayList<Book> books = new ArrayList<Book>();
    public int bookSize = 0;

    BookController() throws FileNotFoundException, IOException {
        this.importData();
    }

    public void importData() throws FileNotFoundException, IOException {
        String ID;
        String name;
        String author;
        String category;
        Position position = new Position(-1, -1);
        int number;
        int numberAvaiable;

        try (BufferedReader br = new BufferedReader(new FileReader("data/book.txt"))) {
            String line = br.readLine();
            this.bookSize = Integer.parseInt(line);
            while ((line = br.readLine()) != null) {
                ID = line;
                name = br.readLine();
                author = br.readLine();
                category = br.readLine();
                position.shelve = Integer.parseInt(br.readLine());
                position.floor = Integer.parseInt(br.readLine());
                number = Integer.parseInt(br.readLine());
                numberAvaiable = Integer.parseInt(br.readLine());
                Book book = new Book(ID, name, author, category, position, number, numberAvaiable);
                this.books.add(book);
            }
        }
    }

    public void exportData() throws IOException {
        File file = new File("data/book.txt");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(Integer.toString(this.bookSize));
            bw.newLine();

            for (Book book : books) {
                bw.write(book.ID);
                bw.newLine();
                bw.write(book.name);
                bw.newLine();
                bw.write(book.author);
                bw.newLine();
                bw.write(book.category);
                bw.newLine();;
                bw.write(Integer.toString(book.position.shelve));
                bw.newLine();
                bw.write(Integer.toString(book.position.floor));
                bw.newLine();
                bw.write(Integer.toString(book.number));
                bw.newLine();
                bw.write(Integer.toString(book.numberAvaiable));
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(
            String name,
            String author,
            String category,
            int shelve,
            int floor,
            int number) throws IOException {
                Book book = new Book();
                Position position = new Position(shelve, floor);
                book.createNewbook(name, author, category, position, number, number);
                books.add(book);
                bookSize++;
                exportData();
                printBooks();
    }
    public Book find(String ID){
        for (Book book : books) {
            if(book.ID.equals(ID)){
                return book;
            }
        }
        return null;
    }
    public Book find_name(String name){
        for (Book book : books) {
            if(book.name.compareToIgnoreCase(name) == 0){
                return book;
            }
        }
        return null;
    }
    public Book adjBook(String ID, String name, String author, String category, Position position){
        Book book = find(ID);
        if(book != null){
            if(ID != "") book.ID = ID;
            if(name != "") book.name = name;
            if(author != "") book.author = author;
            if(category != "") book.category = category;
            if(position != null) book.position = position;

            return book;
        }
        else return null;
    }
    public void deleteBook(String ID) throws IOException{
        Book book = find(ID);
        if(book != null){
            books.remove(book);
            exportData();
        }
    }
    public DefaultListModel<String> toDefaultList(){
        DefaultListModel<String> rs = new DefaultListModel<String>();
        for (Book book : books) {
            rs.addElement(book.print());
        }
        return rs;
    }
    public void printBooks(){
        for (Book book : books) {
            book.print();
        }
    }
}
