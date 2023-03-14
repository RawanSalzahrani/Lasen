/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Khulood Alyaf3Y
 */
public class MemoryGame_2 {
    
 private int turns = 0;
    private int points = 0;
   // private final int boardLength =2;
    private final int boardSize = 2*3;
    private final Random random = new Random();
    private final ArrayList<String> memoryBoard = new ArrayList<>(Arrays.asList("","","","","",""));
    private final String[] image_value = {"SHAMS","QAMOS","NAMOS","QUNDUS","ANANAS","LBAS"};
    boolean[] index_select ={false,false,false,false,false,false};
    String[] phonemes = {"QUNDUS[K,W,N,D,AH,S]","QAMOS[K,AE,M,AH,Z]","LBAS[L,B,AE,Z]","NAMOS[N,AE,M,AH,Z]","ANANAS[AE,N,AH,N,AH,Z]","SHAMS[SH,AE,M,Z]"};
    String[] phonemes2 = {"QUNDUS[K,W,N,D,AH,S]","QAMOS[K,AE,M,AH,Z]","LBAS[L,B,AE,S]","NAMOS[N,AE,M,AH,Z]","ANANAS[AE,N,AH,N,AH,S]","SHAMS[SH,AE,M,Z]"};
    public static String[] fill_button2 = {"", "", "", "","",""};   
    
    
    public void setupGame(){
        setupMemoryBoard();
        System.out.println(memoryBoard);
    }

    public String getOptionAtIndex(int index){
        return memoryBoard.get(index);
    }

   
    private void setupMemoryBoard(){
        
        for (int i = 0; i < 3; i++) {
            
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
             
             fill_button2[position]=memoryOption;
              
            int position2 = random.nextInt(boardSize);
        
            while (!Objects.equals(memoryBoard.get(position2),"")){
                position2 = random.nextInt(boardSize );
            }
             memoryBoard.set(position2, memoryOption);
             
              fill_button2[position2]=memoryOption;
             
            System.out.println(position+","+position2);
            
            
           
          
        }
          for(int j=0;j<index_select.length;j++)
             {
                 System.out.print(" "+index_select[j]);
                 
             }
          System.out.println("");
          
          
    }         
        
        
    

    public boolean checkTwoPositions(int firstIndex, int secondIndex){
       return memoryBoard.get(firstIndex).equals(memoryBoard.get(secondIndex));
    }
}


    


