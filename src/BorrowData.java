package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class BorrowData {
    String ID;
    String readerID;
    String readerName;
    String bookID;
    String bookName;

    LocalDate borrowDate;
    LocalDate returnDate;

    BorrowData(String readerID, String readerName, String bookID, String bookName, LocalDate borrowDate) throws IOException{
        this.ID = createID();
        this.readerID = readerID;
        this.readerName = readerName;
        this.bookID = bookID;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
    }

    private String createID() throws IOException{
        String ID = "";
        File file = new File("data/borrowdata.txt");
        try{
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String strLine;
            if((strLine = br.readLine())!= null){
                ID = String.valueOf(readerName.charAt(0)).toUpperCase() + String.valueOf(readerName.charAt(readerName.length()-1)).toUpperCase() + String.valueOf(bookName.charAt(0)).toUpperCase() + String.valueOf(readerName.charAt(readerName.length()-1)).toUpperCase() + strLine;
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return ID;
    }
}
