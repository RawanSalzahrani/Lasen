/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import static lasen.Lasen.mediaPlayer;
import static lasen.Lasen.mediaPlayer2;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Home_pageController implements Initializable {

    @FXML
    private Button dimonds;
    @FXML
    private Button coins;
    @FXML
    private Button certification;
    @FXML
    private Button setting;
    @FXML
    private Button instructions;
    @FXML
    private Button first_level;
    @FXML
    private Button second_level;
    @FXML
    private Button third_level;
    @FXML
    private ImageView mark;
    @FXML
    private Pane pop_wind;
    @FXML
    private Button exit;
    @FXML
    private Slider music_slider;
    @FXML
    private Button profile;
    @FXML
    private Button sign_out;
    @FXML
    private Slider sound_slider;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView sound_img;
    @FXML
    private ImageView music_img;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO                           
        sound_slider.setValue(mediaPlayer.getVolume()*100);
        sound_slider.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer.setVolume(sound_slider.getValue()/100);
            }
        });
        
        music_slider.setValue(mediaPlayer2.getVolume()*400);
        music_slider.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer2.setVolume(music_slider.getValue()/100);
            }
        });        
    }

    @FXML
    private void minimize_certification(MouseEvent event) {
        certification.setPrefHeight(certification.getPrefHeight()-5);
        certification.setPrefWidth(certification.getPrefWidth()-5);
        certification.setTranslateX(certification.getTranslateX()+5);
    }

    @FXML
    private void enlarge_certification(MouseEvent event) {
        certification.setPrefHeight(certification.getPrefHeight()+5);
        certification.setPrefWidth(certification.getPrefWidth()+5);
        certification.setTranslateX(certification.getTranslateX()-5);
    }

    @FXML
    private void to_show_certification(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
    }

    @FXML
    private void minimize_setting(MouseEvent event) {
        setting.setPrefHeight(setting.getPrefHeight()-5);
        setting.setPrefWidth(setting.getPrefWidth()-5);
        setting.setTranslateX(setting.getTranslateX()+5);
    }

    @FXML
    private void enlarge_setting(MouseEvent event) {
        setting.setPrefHeight(setting.getPrefHeight()+5);
        setting.setPrefWidth(setting.getPrefWidth()+5);
        setting.setTranslateX(setting.getTranslateX()-5);
    }

    @FXML
    private void to_setting_page(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        pop_wind.setVisible(true);
        
    }

    @FXML
    private void minimize_instructions(MouseEvent event) {
        instructions.setPrefHeight(instructions.getPrefHeight()-5);
        instructions.setPrefWidth(instructions.getPrefWidth()-5);
        instructions.setTranslateX(instructions.getTranslateX()+5);
    }

    @FXML
    private void enlarge_instructions(MouseEvent event) {
        instructions.setPrefHeight(instructions.getPrefHeight()+5);
        instructions.setPrefWidth(instructions.getPrefWidth()+5);
        instructions.setTranslateX(instructions.getTranslateX()-5);
    }

    @FXML
    private void to_instructions(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("instructions.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void minimize_first(MouseEvent event) {
        first_level.setPrefHeight(first_level.getPrefHeight()-5);
        first_level.setPrefWidth(first_level.getPrefWidth()-5);
        first_level.setTranslateX(first_level.getTranslateX()+5);
    }

    @FXML
    private void enlarge_first(MouseEvent event) {
        first_level.setPrefHeight(first_level.getPrefHeight()+5);
        first_level.setPrefWidth(first_level.getPrefWidth()+5);
        first_level.setTranslateX(first_level.getTranslateX()-5);
    }

    @FXML
    private void to_first_level(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Lasen.mediaPlayer2.pause();
        Parent root = FXMLLoader.load(getClass().getResource("first_level.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void minimize_second(MouseEvent event) {
        second_level.setPrefHeight(second_level.getPrefHeight()-5);
        second_level.setPrefWidth(second_level.getPrefWidth()-5);
        second_level.setTranslateX(second_level.getTranslateX()+5);
    }

    @FXML
    private void enlarge_second(MouseEvent event) {
        second_level.setPrefHeight(second_level.getPrefHeight()+5);
        second_level.setPrefWidth(second_level.getPrefWidth()+5);
        second_level.setTranslateX(second_level.getTranslateX()-5);
    }

    @FXML
    private void to_second_level(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Lasen.mediaPlayer2.pause();
        Parent root = FXMLLoader.load(getClass().getResource("second_level.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void minimize_third(MouseEvent event) {
        third_level.setPrefHeight(third_level.getPrefHeight()-5);
        third_level.setPrefWidth(third_level.getPrefWidth()-5);
        third_level.setTranslateX(third_level.getTranslateX()+5);
    }

    @FXML
    private void enlarge_third(MouseEvent event) {
        third_level.setPrefHeight(third_level.getPrefHeight()+5);
        third_level.setPrefWidth(third_level.getPrefWidth()+5);
        third_level.setTranslateX(third_level.getTranslateX()-5);
    }

    @FXML
    private void to_third_level(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Lasen.mediaPlayer2.pause();
        Parent root = FXMLLoader.load(getClass().getResource("third_level.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void unvisiable(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        pop_wind.setVisible(false);
    }

    @FXML
    private void to_profile(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("profile_setting.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void to_sign_in(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void change_music_img(MouseEvent event) {
        try {
            FileInputStream muteFile = new FileInputStream("src\\lasen\\image\\blocked_music.png");
            Image muteImage = new Image(muteFile);
            if (music_slider.getValue()== 0){                  
                music_img.setImage(muteImage);                 
              }else {
                FileInputStream unmuteFile = new FileInputStream("src\\lasen\\image\\music2.png");
                Image unmuteImage = new Image(unmuteFile);
                music_img.setImage(unmuteImage);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void change_sound_img(MouseEvent event) {
        try {
            FileInputStream muteFile = new FileInputStream("src\\lasen\\image\\blocked_sound.png");
            Image muteImage = new Image(muteFile);
            if (sound_slider.getValue()== 0){                  
                sound_img.setImage(muteImage);                 
              }else {
                FileInputStream unmuteFile = new FileInputStream("src\\lasen\\image\\sound2.png");
                Image unmuteImage = new Image(unmuteFile);
                sound_img.setImage(unmuteImage);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
