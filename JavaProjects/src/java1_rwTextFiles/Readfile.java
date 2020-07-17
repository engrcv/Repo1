package java1_rwTextFiles;
 
import java.io.FileReader;
import java.io.IOException;
 
//To read characters from a text file.

public class Readfile {
 
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("InFile.txt");
            int character;
 
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}