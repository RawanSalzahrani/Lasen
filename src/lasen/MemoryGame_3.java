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
public class MemoryGame_3 {
    private int turns = 0;
    private int points = 0;
   // private final int boardLength =2;
    private final int boardSize = 2*4;
    private final Random random = new Random();
    private final ArrayList<String> memoryBoard = new ArrayList<>(Arrays.asList("","","","","","","",""));
    private final String[] image_value = {"MADRASA","MASJID","ASAD","MAKNASA","MISWAK","MISMAR","KURSI","KUSA"};
    boolean[] index_select ={false,false,false,false,false,false,false,false};
    
    String[] phonemes = {"KUSA[K,UW,Z,AH]","MISWAK[M,IH,S,W,AE,K]","MADRASA[M,AE,D,R,AH,S,AH]","MISMAR[M,IH,S,M,AA,R]","MASJID[M,AE,Z,JH,AH,D]","ASAD[AH,S,AE,D]","KURSI[K,AH,R,S,IY]","MAKNASA[M,AE,K,N,AH,S,AH]"};
    String[] phonemes2 = {"KUSA[K,UW,S,AH]","MISWAK[M,IH,S,W,AE,K]","MADRASA[M,AE,D,R,AH,S,AH]","MISMAR[M,IH,S,M,AA,R]","MASJID[M,AE,S,JH,AH,D]","ASAD[AH,S,AE,D]","KURSI[K,AH,R,S,IY]","MAKNASA[M,AE,K,N,AH,S,AH]"};
    public static String[] fill_button3 = {"", "", "", "","","","",""};    
    
    
    public void setupGame(){
        setupMemoryBoard();
        System.out.println(memoryBoard);
    }

    public String getOptionAtIndex(int index){
        return memoryBoard.get(index);
    }

   
    private void setupMemoryBoard(){
        
        for (int i = 0; i < 4; i++) {
            
             int random_image=random.nextInt(image_value.length);

            
             while(index_select[random_image]){
             
               random_image=random.nextInt(image_value.length);
             }
              System.out.println(random_image);
             index_select[random_image]=true;
             
           
             String memoryOption = image_value[random_image];
           
             
            int position = random.nextInt(boardSize);
              fill_button3[position]=memoryOption;
            while (!Objects.equals(memoryBoard.get(position),"")){
                position = random.nextInt(boardSize );
            }
            
             memoryBoard.set(position, memoryOption);
             
            int position2 = random.nextInt(boardSize);
            fill_button3[position2]=memoryOption;

            while (!Objects.equals(memoryBoard.get(position2),"")){
                position2 = random.nextInt(boardSize );
            }
             memoryBoard.set(position2, memoryOption);
             
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

