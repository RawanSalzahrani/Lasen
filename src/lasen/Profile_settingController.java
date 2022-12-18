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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Profile_settingController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private ComboBox<?> age;
    @FXML
    private TextField txt_show_passwod;
    @FXML
    private PasswordField txt_hide_Password;
    @FXML
    private TextField txt_show_passwod2;
    @FXML
    private PasswordField txt_hide_Password2;
    @FXML
    private ImageView openEye;
    @FXML
    private ImageView openEye2;
    @FXML
    private ImageView closeEye;
    @FXML
    private ImageView closeEye2;
    @FXML
    private Button save_bt;
    
    String password;
    String password2;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public  void initialize(){
        txt_show_passwod.setVisible(false);
        openEye.setVisible(false);
    }
    public  void initialize2(){
        txt_show_passwod2.setVisible(false);
        openEye2.setVisible(false);
    }

    @FXML
    private void showPasswordOnAction(KeyEvent event) {
        password=txt_show_passwod.getText();
        txt_hide_Password.setText(password);
    }

    @FXML
    private void hidePasswordOnAction(KeyEvent event) {
        password=txt_hide_Password.getText();
        txt_show_passwod.setText(password);
    }

    @FXML
    private void showPasswordOnAction2(KeyEvent event) {
        password2=txt_show_passwod2.getText();
        txt_hide_Password2.setText(password2);
    }

    @FXML
    private void hidePasswordOnAction2(KeyEvent event) {
        password2=txt_hide_Password2.getText();
        txt_show_passwod2.setText(password2);
    }

    @FXML
    private void open_Eye_ClickOnAction(MouseEvent event) {
        txt_show_passwod.setVisible(false);
        openEye.setVisible(false);
        closeEye.setVisible(true);
        txt_hide_Password.setVisible(true);
    }

    @FXML
    private void open_Eye_ClickOnAction2(MouseEvent event) {
        txt_show_passwod2.setVisible(false);
        openEye2.setVisible(false);
        closeEye2.setVisible(true);
        txt_hide_Password2.setVisible(true);
    }

    @FXML
    private void close_Eye_Click_OnAction(MouseEvent event) {
        txt_show_passwod.setVisible(true);
        openEye.setVisible(true);
        closeEye.setVisible(false);
        txt_hide_Password.setVisible(false);
    }

    @FXML
    private void close_Eye_Click_OnAction2(MouseEvent event) {
        txt_show_passwod2.setVisible(true);
        openEye2.setVisible(true);
        closeEye2.setVisible(false);
        txt_hide_Password2.setVisible(false);
    }

    @FXML
    private void minimize_save(MouseEvent event) {
        save_bt.setPrefHeight(save_bt.getPrefHeight()-5);
        save_bt.setPrefWidth(save_bt.getPrefWidth()-5);
        save_bt.setTranslateX(save_bt.getTranslateX()+5);
    }

    @FXML
    private void enlarge_save(MouseEvent event) {
        save_bt.setPrefHeight(save_bt.getPrefHeight()+5);
        save_bt.setPrefWidth(save_bt.getPrefWidth()+5);
        save_bt.setTranslateX(save_bt.getTranslateX()-5);
    }

    @FXML
    private void to_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
