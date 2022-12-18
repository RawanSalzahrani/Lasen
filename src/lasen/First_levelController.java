/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class First_levelController implements Initializable {

    @FXML
    private Button setting;
    @FXML
    private Button home;
    @FXML
    private Button dimonds;
    @FXML
    private Button coins;
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
    private Pane record_pan;
    @FXML
    private Button refresh_bt;
    @FXML
    private Button get_help_bt;
    @FXML
    private Button micerphone_bt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        pop_wind.setVisible(true);
        
    }

    @FXML
    private void minimize_home(MouseEvent event) {
        home.setPrefHeight(home.getPrefHeight()-5);
        home.setPrefWidth(home.getPrefWidth()-5);
        home.setTranslateX(home.getTranslateX()+5);
    }

    @FXML
    private void enlarge_home(MouseEvent event) {
        home.setPrefHeight(home.getPrefHeight()+5);
        home.setPrefWidth(home.getPrefWidth()+5);
        home.setTranslateX(home.getTranslateX()-5);
    }

    @FXML
    private void to_home_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void unvisiable(ActionEvent event) {
        pop_wind.setVisible(false);
    }

    @FXML
    private void to_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile_setting.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void to_sign_in(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void refresh_cards(ActionEvent event) {
    }

    @FXML
    private void get_help(ActionEvent event) {
    }

    @FXML
    private void record_sound(ActionEvent event) {
    }
    
}
