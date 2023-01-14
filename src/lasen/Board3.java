/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.util.Random;

/**
 *
 * @author Khulood Alyaf3Y
 */
public class Board3 {
      
    public Cell[][] board = new Cell[2][4];

    public void populateMatrix(){

        board = new Cell[2][4];
        boolean[] index_select ={false,false,false,false,false,false,false,false};
       
        String[] images = {"zucchini","toothpick","school","nail","Mosque","Lion","chair","broom"};
        Random randomGenerator = new Random();
        while(!isBoardFull()){
            
            int randomImageIndex = randomGenerator.nextInt(images.length);
            
             if(index_select[randomImageIndex]==false){
                 
            String randomImageSelected = images[randomImageIndex];

            int randomRow1 = randomGenerator.nextInt(2);
            int randomCol1 = randomGenerator.nextInt(4);
            
            while(board[randomRow1][randomCol1]!=null){
                randomRow1 = randomGenerator.nextInt(2);
                randomCol1 = randomGenerator.nextInt(4);
            }

            int randomRow2 = randomGenerator.nextInt(2);
            int randomCol2 = randomGenerator.nextInt(4);
            
            while((randomRow1 ==randomRow2 && randomCol1 == randomCol2)
                    || board[randomRow2][randomCol2]!=null){
                randomRow2 = randomGenerator.nextInt(2);
                randomCol2 = randomGenerator.nextInt(4);
            }

            board[randomRow1][randomCol1] = new Cell(randomImageSelected,randomRow1, randomCol1);
            board[randomRow2][randomCol2] = new Cell(randomImageSelected,randomRow2, randomCol2);

         index_select[randomImageIndex]=true ;
             
             //  for(int i=0;i< index_select.length;i++){
                //     System.out.println(index_select[i]);}
               //
          //   System.out.println(randomImageIndex);
                }
        }

    }

    private boolean isBoardFull() {
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }

}

    


  
