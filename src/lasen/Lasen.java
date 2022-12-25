/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author horre
 */
public class Lasen extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
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
