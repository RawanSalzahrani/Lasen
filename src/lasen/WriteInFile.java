/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

/**
 *
 * @author Rawan
 */
public class WriteInFile {
    
    public static void writeFile(String name,String word_text, String phonem, String result, int Distance){
       try {
      FileWriter myWriter = new FileWriter("test.txt",true);
      myWriter.write("Neme:"+name+" wordText="+word_text+" phonem:"+phonem+" result="+result+" Distance="+Distance+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
}
