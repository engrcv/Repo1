package java1_rwTextFiles;
 
import java.io.FileWriter;
import java.io.IOException;
 
//To write characters to a text file.

public class WriteFile {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("OutFile.txt", true);
            writer.write("Hello!");
            writer.write("\r\n");   // write new line
            writer.write("Here I write your new OutFile...");
            writer.close();
            System.out.print("Writing to OutFile completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}