/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javax.mail.MessagingException;
import static lasen.Lasen.mediaPlayer;
import org.hibernate.Query;


/**
 * FXML Controller class
 *
 * @author horre
 */
public class Forget_passwordController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField email;
    @FXML
    private Button sent_bt;
    @FXML
    private Label label1;
    
    static String recepientEmail;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void minimize_send_bt(MouseEvent event) {
        sent_bt.setPrefHeight(sent_bt.getPrefHeight()-5);
        sent_bt.setPrefWidth(sent_bt.getPrefWidth()-5);
        sent_bt.setTranslateX(sent_bt.getTranslateX()+5);
    }

    @FXML
    private void enlarge_send_bt(MouseEvent event) {
        sent_bt.setPrefHeight(sent_bt.getPrefHeight()+5);
        sent_bt.setPrefWidth(sent_bt.getPrefWidth()+5);
        sent_bt.setTranslateX(sent_bt.getTranslateX()-5);
    }

    @FXML
    private void to_verification_page(ActionEvent event) throws IOException, MessagingException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        recepientEmail = email.getText();
        
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
        List<user> sList = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        
        int index=1;
        String domain = "";
        if (email.getText().contains("@")) {
        index = email.getText().indexOf("@");
        domain = email.getText().substring(index);
        }   
        boolean invalidDomain=!(domain.equals("@gmail.com")) && !(domain.equals("@yahoo.com")) && !(domain.equals("@outlook.com")) && !(domain.equals("@hotmail.com")) && !(domain.equals("@st.uqu.edu.sa"));   
        if ((invalidDomain && !email.getText().equals("")) || (index-1 <0)) { //index-1= -1 when email like @hotmail.com without name 
           label1.setText("الرجاء إدخال بريد إلكتروني صحيح");
           label1.setVisible(true);
           return;
        }else if (email.getText().equals("")){
            label1.setVisible(true);
        }         
             //now check if email is in the database and if password and email are correct
                        else{
                            boolean flag = false;
                            for(user u: sList){
                                //if user found 
                                if(u.getEmail().equals(email.getText())){ flag =true;
                                JavaMailUtil.sendMail(recepientEmail);
                                Parent root = FXMLLoader.load(getClass().getResource("varification.fxml"));
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();                                    
                                }
                            }
                            if (flag == false){
                                label1.setText("البريد الإلكتروني غير مسجل, فضلا قم بإنشاء حساب أولا ");
                                label1.setVisible(true);
                            }
                        
                        }  
    }
    
}
