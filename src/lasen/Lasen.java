/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
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
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        media = new Media(getClass().getResource("/sounds/click.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media); 
//        mediaPlayer.setAutoPlay(true); 
//        mediaPlayer.setOnEndOfMedia(new Runnable() {
//        public void run() {
//         mediaPlayer.seek(Duration.ZERO);
//       }
//      });
        

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
