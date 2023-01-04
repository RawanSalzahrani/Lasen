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
      
    public Cell[][] board = new Cell[4][2];

    public void populateMatrix(){

        board = new Cell[4][2];
        
        
        String[] images = {"clock","cup", "honey","lettuce", "potatoes"};
        Random randomGenerator = new Random();
        while(!isBoardFull()){
            
            int randomImageIndex = randomGenerator.nextInt(images.length);
            String randomImageSelected = images[randomImageIndex];

            int randomRow1 = randomGenerator.nextInt(4);
            int randomCol1 = randomGenerator.nextInt(2);
            
            while(board[randomRow1][randomCol1]!=null){
                randomRow1 = randomGenerator.nextInt(4);
                randomCol1 = randomGenerator.nextInt(2);
            }

            int randomRow2 = randomGenerator.nextInt(4);
            int randomCol2 = randomGenerator.nextInt(2);
            
            while((randomRow1 ==randomRow2 && randomCol1 == randomCol2)
                    || board[randomRow2][randomCol2]!=null){
                randomRow2 = randomGenerator.nextInt(4);
                randomCol2 = randomGenerator.nextInt(2);
            }

            board[randomRow1][randomCol1] = new Cell(randomImageSelected,randomRow1, randomCol1);
            board[randomRow2][randomCol2] = new Cell(randomImageSelected,randomRow2, randomCol2);

        }

    }

    private boolean isBoardFull() {
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                if(board[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }

}

    


  
