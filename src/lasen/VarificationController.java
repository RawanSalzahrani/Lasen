/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Session; //handles configuration setting and authentication
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message; //creating a message that will be sent
import javax.mail.Transport; //a message transport mechanism (will use the SMTP protocol to send the messages)
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import static lasen.Lasen.mediaPlayer;

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
    @FXML
    private Label label1;

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
    private void send(MouseEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        if (code_txt.getText().isEmpty()) {
            label1.setText("الرجاء إدخال رمز التحقق");
            label1.setVisible(true);
        }else if (Integer.parseInt(code_txt.getText()) == JavaMailUtil.random){
            Parent root = FXMLLoader.load(getClass().getResource("reset_password.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            label1.setVisible(true);
        }
    }
    
}
