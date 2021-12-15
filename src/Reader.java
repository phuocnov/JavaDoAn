package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

// import javax.naming.directory.InitialDirContext;

public class Reader {
    public String ID;
    public String name;
    public LocalDate createDate;
    // Constructor used for create new Reader
    public Reader(){
        
    }
    public Reader(String ID, String name, String creaDate){
        this.ID = ID;
        this.name = name;
        this.createDate = LocalDate.parse(creaDate);
    }

    public void CreateReader(String name, LocalDate createDate) throws IOException{
        this.ID = generateID(name);
        this.name = name;
        this.createDate = createDate;
    }

    private String generateID(String name) throws IOException{
        String ID = "";
        File file = new File("data/reader.txt");
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String strLine;
            if((strLine = br.readLine())!= null){
                ID =  String.valueOf(name.charAt(0)).toUpperCase()  + String.valueOf(name.charAt(name.length() - 1)).toUpperCase() + strLine;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ID;
    }

    public String print(){
        String result = new String("Name: "+ this.name + " ID: "+ this.ID + " Created at: "+ this.createDate);
        System.out.println(result);
        return result;
    }
    
}
