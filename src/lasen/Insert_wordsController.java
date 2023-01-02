/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Insert_wordsController implements Initializable {

    @FXML
    private TextField phoneme;
    @FXML
    private TextField text;
    @FXML
    private TextField lvl_no;
    @FXML
    private Button insert_bt;
    @FXML
    private Label label1;
    @FXML
    private Button img;
    @FXML
    private TextField word_id;
    
    
    private byte[] image;
    private FileChooser filechooser = new FileChooser();
    private File filePath ;
    
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

    @FXML
    private void upload(ActionEvent event) {
        File selectedImage = filechooser.showOpenDialog(stage);
        if (selectedImage != null) {
            image = new byte[(int) selectedImage.length()];
        }
    }
    
    @FXML
    private void insert(ActionEvent event) {
        
                word w = new word();
                w.setWord_id(Integer.valueOf(word_id.getText()));
                w.setLevel_no(Integer.valueOf(lvl_no.getText()));
                w.setText(text.getText());
                w.setPhoneme(phoneme.getText());
                w.setImg(image);
                
                Session session2 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session2.beginTransaction();
                session2.save(w);
                tx.commit();
                session2.close();
                
                System.out.println("The word " + word_id.getText() + "word was inserted. " );
    }   
}
