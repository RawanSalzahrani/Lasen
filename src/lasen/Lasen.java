/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author horre
 */
public class Lasen extends Application {
    //for click sound
    public static Media media;
    public static  MediaPlayer mediaPlayer;
    //background sound
    public static Media media2;
    public static  MediaPlayer mediaPlayer2;
    
    public static Media media3;
    public static  MediaPlayer mediaPlayer3;
    
    public static Media media4;
    public static  MediaPlayer mediaPlayer4;
    
    public static Media media5;
    public static  MediaPlayer mediaPlayer5;

       
    public static String getRandomStringCorr(){
        int r = (int) (Math.random()*4);
        String Correct_sound = new String [] {"/sounds/Corr_1.mp3","/sounds/Corr_2.mp3","/sounds/Corr_3.mp3","/sounds/Corr_4.mp3"}[r];
        return Correct_sound;
    }
    
    public static String getRandomStringInCorr(){
        int r = (int) (Math.random()*4);
        String Incorrect_sound = new String [] {"/sounds/Incor_1.mp3","/sounds/Incor_2.mp3","/sounds/Incor_3.mp3","/sounds/Incor_4.mp3"}[r];
        return Incorrect_sound;
    }
//    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        media = new Media(getClass().getResource("/sounds/click.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media); 

        media2 = new Media(getClass().getResource("/sounds/birds.mp3").toExternalForm());
        mediaPlayer2 = new MediaPlayer(media2);  
        mediaPlayer2.setAutoPlay(true); 
        mediaPlayer2.setOnEndOfMedia(new Runnable() {
        public void run() {
         mediaPlayer2.seek(Duration.ZERO);
       }
      });

        //view main page                
        Parent root = FXMLLoader.load(getClass().getResource("main_page.fxml"));              
	Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lasen");     
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
