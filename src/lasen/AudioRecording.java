/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author Rawan
 */
public class AudioRecording {
   
  
  
    TargetDataLine targetLine;  // the line from which audio data is captured
    AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
    DataLine.Info dataInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
    String fileName;
    
    
    public void startRecording() throws IOException, LineUnavailableException{
        
        if(!AudioSystem.isLineSupported(dataInfo))
             System.out.println("Not supported");        
        targetLine = (TargetDataLine)AudioSystem.getLine(dataInfo);    
        targetLine.open();    
        targetLine.start();
         
        try
        {         
           Thread audioRecorderThread = new Thread()
           {
               @Override public void run()
               {
                  AudioInputStream recordingStream = new AudioInputStream(targetLine);
                  fileName = userSignInNow.userName + "_" +First_levelController.word_text+".wav";
                  File outputFile = new File(fileName); // path of the wav file
                  
                  try
                  {
                      AudioSystem.write(recordingStream, AudioFileFormat.Type.WAVE, outputFile); // start recording
                  }
                  catch (IOException ex)
                  {
                      System.out.println(ex);
                  }
                  System.out.println("Stopped recording");        
               }
            };
        audioRecorderThread.start();          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }      
    }
    
    
    public String stopRecording() throws IOException, LineUnavailableException{
        
        targetLine.stop();
        targetLine.close(); // Closes the target data line to finish capturing and recording
        
        CMUSphinx spinx =new CMUSphinx();
        return spinx.getHypotesis(fileName);
  
    }

}
    
    

