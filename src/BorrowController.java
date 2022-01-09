package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.management.relation.RelationServiceNotRegisteredException;

import java.io.OutputStreamWriter;
import java.time.LocalDate;


public class BorrowController {
    public ArrayList<Borrow> borrowData = new ArrayList<>();
    ReaderController readerController;
    BookController bookController;

    BorrowController(ReaderController rc, BookController bc) throws FileNotFoundException, IOException {
        readerController = rc;
        bookController = bc;
        importData();
    }

    public void importData()
            throws FileNotFoundException, IOException {
        String readerID = "";
        String bookID = "";
        String borrowDate = "";
        String isReturned = "";
        String returnedDate = "";

        try (BufferedReader br = new BufferedReader(new FileReader("data/borrowdata.txt"))) {
            String line= "";
            while ((line = br.readLine()) != null) {
                readerID = line;
                bookID = br.readLine();
                borrowDate = br.readLine();
                isReturned = br.readLine();
                if (isReturned == "true") {
                    returnedDate = br.readLine();
                }
                Reader reader = readerController.find(readerID);
                Book book = bookController.find(bookID);
                if (reader != null && book != null) {
                    Borrow borrow = new Borrow(book, reader, borrowDate, returnedDate,
                            Boolean.parseBoolean(isReturned));
                    borrowData.add(borrow);
                }
            }
        }
    }

    public void exportData() throws IOException{
        File file = new File("data/borrowdata.txt");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Borrow borrow: borrowData) {
                bw.write(borrow.reader.ID);
                bw.newLine();
                bw.write(borrow.book.ID);
                bw.newLine();
                bw.write(borrow.dateBorrow.toString());
                bw.newLine();
                bw.write(Boolean.toString(borrow.isReturned));
                bw.newLine();
                if(borrow.isReturned){
                    bw.write(borrow.dateReturn.toString());
                    bw.newLine();
                }
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void borrow(String readerID, String bookID) throws IOException{
        Reader reader = readerController.find(readerID);
        Book book = bookController.find(bookID);
        
        // Create record
        Borrow record = new Borrow();
        record.reader = reader;
        record.book = book;
        record.isReturned = false;
        record.dateBorrow = LocalDate.now();
        // Recaculate book number
        book.numberAvaiable--;
        // Save data
        borrowData.add(record);
        exportData();
        bookController.exportData();
    }
    public void returnBook(String readerID, String bookID, String dateBorrow) throws IOException{
        Reader reader = readerController.find(readerID);
        Book book = bookController.find(bookID);
        LocalDate date = LocalDate.parse(dateBorrow);

        for (Borrow borrow : borrowData) {
            if(borrow.reader == reader && borrow.book == book && borrow.dateBorrow.equals(date) && borrow.isReturned == false){
                borrow.isReturned = true;
                borrow.dateReturn = LocalDate.now();

                // Recaculate book number
                book.numberAvaiable++;
                exportData();
                bookController.exportData();
            }
        }
    }
    // Kiểm tra xem người dùng đang mượn những cuốn sách nào
    public ArrayList<Borrow> showBookBorrowed(String readerID){
        Reader reader = readerController.find(readerID);
        ArrayList<Borrow> list = new ArrayList<Borrow>();

        for (Borrow borrow : borrowData) {
            if(borrow.reader == reader){
                list.add(borrow);
            }
        }
        return list;
    }

    // Kiểm tra xem sách đang được những ai mượn
    public ArrayList<Borrow> showReaderBorrowed(String bookID){
        Book book = bookController.find(bookID);
        ArrayList<Borrow> list = new ArrayList<Borrow>();
        
        for (Borrow borrow : borrowData) {
            if(borrow.book == book){
                list.add(borrow);
            }
        }
        return list;
    }

    // Xem các sách đang được mượn
    public ArrayList<Borrow> showBorrowingBook(){
        ArrayList<Borrow> list = new ArrayList<Borrow>();
        for (Borrow borrow : borrowData) {
            if(!borrow.isReturned) list.add(borrow);
        }
        return list;
    }
    // Xem các sách được mượn đã trả
    public ArrayList<Borrow> showReturnedBook(){
        ArrayList<Borrow> list = new ArrayList<Borrow>();
        for (Borrow borrow : borrowData) {
            if(borrow.isReturned) list.add(borrow);
        }
        return list;
    }
}