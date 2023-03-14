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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static lasen.Lasen.mediaPlayer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Sign_upController implements Initializable {

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
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private Button sign_up_bt;
    
    String password;
    String password2;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Text sign_in;
    @FXML
    private Label label1;

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
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        txt_show_passwod.setVisible(false);
        openEye.setVisible(false);
        closeEye.setVisible(true);
        txt_hide_Password.setVisible(true);
    }

    @FXML
    private void open_Eye_ClickOnAction2(MouseEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        txt_show_passwod2.setVisible(false);
        openEye2.setVisible(false);
        closeEye2.setVisible(true);
        txt_hide_Password2.setVisible(true);
    }

    @FXML
    private void close_Eye_Click_OnAction(MouseEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        txt_show_passwod.setVisible(true);
        openEye.setVisible(true);
        closeEye.setVisible(false);
        txt_hide_Password.setVisible(false);
    }

    @FXML
    private void close_Eye_Click_OnAction2(MouseEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        txt_show_passwod2.setVisible(true);
        openEye2.setVisible(true);
        closeEye2.setVisible(false);
        txt_hide_Password2.setVisible(false);
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
    private void changeColor2(MouseEvent event) {
        sign_in.setFill(Color.rgb(84, 51, 21));
    }

    @FXML
    private void changeColor(MouseEvent event) {
        sign_in.setFill(Color.rgb(255, 93, 93));
    }

    @FXML
    private void to_sign_in2(MouseEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sign_up(MouseEvent event) throws IOException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        password = txt_hide_Password.getText();
        password2 = txt_hide_Password2.getText();
        String domain = "";
        
        try {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<user> user_list = null;
        String queryStr = "from user";
        Query query = session1.createQuery(queryStr);
        user_list =  query.list();
        session1.close();
        
        //chick if the email has already been used:
        for (user u : user_list) {
           if(u.getEmail().equals(email.getText())){
               label1.setText("البريد الإلكتروني مسجل مسبقا");
               label1.setVisible(true);
               return;
           }
            
        }
        //check if fields are empty:        
        if ( name.getText().isEmpty() || email.getText().isEmpty() || age.getText().isEmpty() || txt_hide_Password.getText().isEmpty() || txt_hide_Password2.getText().isEmpty() ){
            label1.setVisible(true);
        }else if ( password.length() < 8 )
            {
                label1.setText("يجب أن تحتوي كلمة المرور على 8 أرقام أو أكثر");
                label1.setVisible(true);
                return;
            }else if ( Integer.valueOf(age.getText()) < 5 ) {
                label1.setText("يجب أن يكون عمر الطفل 5 سنوات فأكثر");
                label1.setVisible(true);
                return;
        }
            
        //check if email is valid or display alert:
        int index=1;
        if (email.getText().contains("@")) {
        index = email.getText().indexOf("@");
        domain = email.getText().substring(index);
        }   
        boolean invalidDomain=!(domain.equals("@gmail.com")) && !(domain.equals("@yahoo.com")) && !(domain.equals("@outlook.com")) && !(domain.equals("@hotmail.com")) && !(domain.equals("@st.uqu.edu.sa"));   
        if ((invalidDomain && !email.getText().equals("")) || (index-1 <0)) { //index-1= -1 when email like @hotmail.com without name 
           label1.setText("الرجاء إدخال بريد إلكتروني صحيح");
           label1.setVisible(true);
        }
        
        //Check if the password and password verification match:
        boolean dontMatch=!(txt_hide_Password.getText().equals(txt_hide_Password2.getText()));
        if (dontMatch &&  !txt_hide_Password.getText().equals("") && !txt_hide_Password2.getText().equals("")) {
            label1.setText("كلمة المرور ليست متطابقة");
            label1.setVisible(true);
        }
        
        if (email.getText().equals("") || name.getText().equals("") || age.getText().equals("") || txt_hide_Password.getText().equals("")|| txt_hide_Password2.getText().equals("")|| invalidDomain || dontMatch ||(index-1 <0))
            return;

        //save the new user information in database:
        user us = new user();
        us.setEmail(email.getText());
        us.setName(name.getText());
        us.setAge(Integer.valueOf(age.getText()));
        us.setPassword(txt_hide_Password.getText());
        us.setCurrent_balance(5);
        us.setDimonds(us.getDimonds());
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session2.beginTransaction();
        session2.save(us);
        tx.commit();
        session2.close(); 
        
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        }
        catch (HibernateException e){label1.setVisible(true);}
    }
    
}
