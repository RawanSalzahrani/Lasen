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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import static lasen.Lasen.mediaPlayer;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Main_pageController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button sign_in_bt;
    @FXML
    private Button sign_up_bt;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void minimize_sign_in(MouseEvent event) {
        sign_in_bt.setPrefHeight(sign_in_bt.getPrefHeight()-5);
        sign_in_bt.setPrefWidth(sign_in_bt.getPrefWidth()-5);
        sign_in_bt.setTranslateX(sign_in_bt.getTranslateX()+5);
    }

    @FXML
    private void enlarge_sign_in(MouseEvent event) {
        sign_in_bt.setPrefHeight(sign_in_bt.getPrefHeight()+5);
        sign_in_bt.setPrefWidth(sign_in_bt.getPrefWidth()+5);
        sign_in_bt.setTranslateX(sign_in_bt.getTranslateX()-5);
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
    private void minimize_sign_up(MouseEvent event) {
        sign_up_bt.setPrefHeight(sign_up_bt.getPrefHeight()-5);
        sign_up_bt.setPrefWidth(sign_up_bt.getPrefWidth()-5);
        sign_up_bt.setTranslateX(sign_up_bt.getTranslateX()+5);
    }

    @FXML
    private void enlarge_sign_up(MouseEvent event) {
        sign_up_bt.setPrefHeight(sign_up_bt.getPrefHeight()+5);
        sign_up_bt.setPrefWidth(sign_up_bt.getPrefWidth()+5);
        sign_up_bt.setTranslateX(sign_up_bt.getTranslateX()-5);
    }

    @FXML
    private void to_sign_up(ActionEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    
}
