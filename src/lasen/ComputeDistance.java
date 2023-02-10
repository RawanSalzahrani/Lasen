/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.util.Arrays;

/**
 *
 * @author Rawan
 */
public class ComputeDistance{
   
   
     static int compute_distance(String str1, String str2)
    {
        int d=0;
        int size;
        int size2;

       int count1 = str1.length() - str1.replaceAll("\\ ","").length()+1;
       int count2 = str2.length() - str2.replaceAll("\\ ","").length()+1;
       
       //System.out.print(count1+" "+count2);
       
       String strArray1[] = str1.split(" ");
       String strArray2[] = str2.split(" ");
       
        
       if(count1>count2)
      { size=strArray2.length;
        size2=strArray1.length;
      }
       else
       {size=strArray1.length;
           size2=strArray2.length;
       }
       
        int i;
        for (i=0;i<size; i++) 
        {
            if(!strArray1[i].equals(strArray2[i])){
                d++;
            }
     
        }
        
        d=d+Math.abs(count2-count1);
                
       
        return d;
    }
   
}
