package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderController{
    public int readerSize = 0;
    public ArrayList<Reader> readers = new ArrayList<Reader>();

    ReaderController() throws FileNotFoundException, IOException{
        this.importData(readers);
    }

    public void importData(ArrayList<Reader> readers) throws FileNotFoundException, IOException{
        String ID;
        String name;
        String createDate;
    
        try(BufferedReader br = new BufferedReader(new FileReader("data/reader.txt"))){
            String line = br.readLine();
            this.readerSize = Integer.parseInt(line);
            while((line = br.readLine())!= null){
                ID = line;
                name = br.readLine();
                createDate = br.readLine();
                readers.add(new Reader(ID, name, createDate));
            }
        }
    }

    public void exportData() throws IOException{
        File file = new File("data/reader.txt");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(Integer.toString(this.readerSize));
            bw.newLine();

            for (Reader reader : readers) {
                bw.write(reader.ID);
                bw.newLine();
                bw.write(reader.name);
                bw.newLine();
                bw.write(reader.createDate.toString());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // For testing only, refactor when building UI frame
    public Reader create(String name) throws IOException{
        Reader reader = new Reader();
        reader.CreateReader(name, LocalDate.now());
        this.readers.add(reader);
        this.readerSize+= 1;
        this.exportData();

        return reader;
    }
    public Reader find(String ID){
        for (Reader reader : readers) {
            if(reader.ID.compareTo(ID) == 0){
                return reader;
            }
        }
        return null;
    }
    public void adjustReader(String ID, String name) throws IOException{
        Reader reader = find(ID);
        if(reader != null){
            reader.name = name;
            this.exportData();
        }
    }
    public void removeReader(String ID) throws IOException{
        Reader reader = find(ID);
        if(reader != null){
            readers.remove(reader);
            this.exportData();
        }
    }
}
