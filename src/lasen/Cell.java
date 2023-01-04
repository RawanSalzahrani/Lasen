/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

/**
 *
 * @author Khulood Alyaf3Y
 */
public class Cell {
    
  public String value;
    public int row;
    public int col;
    public boolean wasGuessed;

    Cell(String value,int row,int col){
        this.value = value;
        this.row = row;
        this.col = col;
        this.wasGuessed = false;
    }
}

