package lasen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khulood  Alyaf3Y
 */
public class MemoryGame {
    
     private int turns = 0;
    private int points = 0;
   // private final int boardLength =2;
    private final int boardSize = 2*2;
    private final Random random = new Random();
    private final ArrayList<String> memoryBoard = new ArrayList<>(Arrays.asList("", "", "", ""));
    private final String[] image_value = {"SAYAARA","SIFINA","SAMAKA","SIN","SENJAB","SAYF"};
    boolean[] index_select ={false,false,false,false,false,false};
    String[] phonemes = {"S EY AH R AH","S IH F AH N AH","S AE M AH K AH","S IH N","S EH N JH AE B","S EY F"};
    public static String[] fill_button = {"", "", "", ""};

    
    
    public void setupGame(){
        setupMemoryBoard();
        System.out.println(memoryBoard);
    }

    public String getOptionAtIndex(int index){
        return memoryBoard.get(index);
    }

   
    private void setupMemoryBoard(){
        
        for (int i = 0; i < 2; i++) {
            
             int random_image=random.nextInt(image_value.length);
             
             
            
             while(index_select[random_image]){
             
               random_image=random.nextInt(image_value.length);
             }
              System.out.println(random_image);
             index_select[random_image]=true;
             
           
             String memoryOption = image_value[random_image];
           
             
            int position = random.nextInt(boardSize);
        
            while (!Objects.equals(memoryBoard.get(position),"")){
                position = random.nextInt(boardSize );
            }
            
             memoryBoard.set(position, memoryOption);
             fill_button[position]=memoryOption;
             System.out.println(fill_button[position]);
             
            int position2 = random.nextInt(boardSize);
            
        
            while (!Objects.equals(memoryBoard.get(position2),"")){
                position2 = random.nextInt(boardSize );
            }
             memoryBoard.set(position2, memoryOption);
             fill_button[position2]=memoryOption;
             
            System.out.println(fill_button[position2]);
            
            
           
          
        }
//          for(int j=0;j<index_select.length;j++)
//             {
//                 System.out.print(" "+index_select[j]);
//                 
//             }
//          System.out.println("");
          
          
    }         
        
        
    

    public boolean checkTwoPositions(int firstIndex, int secondIndex){
       return memoryBoard.get(firstIndex).equals(memoryBoard.get(secondIndex));
    }
    
    
}


    

