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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class VarificationController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField code_txt;
    @FXML
    private Button varification_bt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void minimize_varification_bt(MouseEvent event) {
        varification_bt.setPrefHeight(varification_bt.getPrefHeight()-5);
        varification_bt.setPrefWidth(varification_bt.getPrefWidth()-5);
        varification_bt.setTranslateX(varification_bt.getTranslateX()+5);
    }

    @FXML
    private void enlarge_varification_bt(MouseEvent event) {
        varification_bt.setPrefHeight(varification_bt.getPrefHeight()+5);
        varification_bt.setPrefWidth(varification_bt.getPrefWidth()+5);
        varification_bt.setTranslateX(varification_bt.getTranslateX()-5);
    }

    @FXML
    private void to_sign_in(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
