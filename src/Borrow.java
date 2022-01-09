package src;

import java.time.LocalDate;

public class Borrow {
    public Reader reader;
    public Book book;
    public LocalDate dateBorrow;
    public LocalDate dateReturn;
    public boolean isReturned;

    Borrow(){
        
    }
    Borrow(Book book, Reader reader, String dateBorrow, String dateReturn, boolean isReturned){
        this.book = book;
        this.reader = reader;
        this.dateBorrow = LocalDate.parse(dateBorrow);
        this.isReturned = isReturned;
        if(isReturned){
            this.dateReturn = LocalDate.parse(dateReturn);
        }
    }
    public String print(){
        String rs;
        if(isReturned){
            rs = "ID: "+ reader.ID + " Name: " + reader.name + "Book: " + book.name + " Date Borrow: " + dateBorrow.toString() + "Date Return: " + dateReturn.toString(); 
        }
        else{
            rs = "ID: "+ reader.ID + " Name: " + reader.name + "Book: " + book.name + " Date Borrow: " + dateBorrow.toString();
        }
        return rs;
    }
}
