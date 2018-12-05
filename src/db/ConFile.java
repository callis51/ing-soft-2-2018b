package db; 
import java.io.File;
import java.io.IOException;
import java.util.Scanner; 

public class ConFile {

    private static File file;

    public ConFile(String namefile){
        this.file = new File(namefile);
    }

    public boolean fileExists() throws IOException {
        return this.file.exists();
    }

    public Db loadfile() throws IOException {

        Db tmp = new Db(); 
        try{
            Scanner sc = new Scanner(this.file); 
            tmp.host = sc.nextLine(); 
            tmp.port = sc.nextLine(); 
            tmp.database = sc.nextLine(); 
            tmp.user = sc.nextLine(); 
            tmp.pass = sc.nextLine(); 

        } catch (java.util.NoSuchElementException e ){
            System.out.println("Error reading : " + file.getAbsolutePath() + " " + e.getMessage());
            return null;
        }
    return tmp;
    }

    public boolean writeFile( Db db) throws IOException {
        return this.file.createNewFile();
    }
}
