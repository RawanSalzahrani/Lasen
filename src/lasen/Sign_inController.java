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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Sign_inController implements Initializable {

    @FXML
    private Button sign_in_bt;
    @FXML
    private TextField txt_show_passwod;
    @FXML
    private PasswordField txt_hide_Password;
    @FXML
    private ImageView openEye;
    @FXML
    private ImageView closeEye;
    
    String password;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Text sign_up;
    @FXML
    private Text forget_pass;
    @FXML
    private TextField email;
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
    private void open_Eye_ClickOnAction(MouseEvent event) {
        txt_show_passwod.setVisible(false);
        openEye.setVisible(false);
        closeEye.setVisible(true);
        txt_hide_Password.setVisible(true);
    }

    @FXML
    private void close_Eye_Click_OnAction(MouseEvent event) {
        txt_show_passwod.setVisible(true);
        openEye.setVisible(true);
        closeEye.setVisible(false);
        txt_hide_Password.setVisible(false);
    }

    @FXML
    private void to_home_page(ActionEvent event) throws IOException {
        

        Session session = HibernateUtil.getSessionFactory().openSession();
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
        }else //check if fields are empty
        if (email.getText().equals("") || txt_hide_Password.getText().equals("")){
            label1.setVisible(true);
        }

            
             //now check if email is in the database and if password and email are correct
                        else{
                            boolean flag = false;
                            for(user u: sList){
                                //if user found 
                                if(u.getEmail().equals(email.getText())){ flag =true;
                                    
                                    if(u.getPassword().equals(txt_hide_Password.getText())){                                        
                                        userSignInNow.userSignIn = email.getText();
                                        
                                        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
                                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        scene = new Scene(root);
                                        stage.setScene(scene);
                                        stage.show();
                                        }
                                    else {
                                        label1.setText("كلمة المرور غير صحيحة");
                                        label1.setVisible(true); 
                                        }  
                                }
                            }
                            if (flag == false){
                                label1.setText("البريد الإلكتروني غير مسجل, فضلا قم بإنشاء حساب أولا ");
                                label1.setVisible(true);
                            }
                        
                        }
        
    }

    @FXML
    private void changeColor4(MouseEvent event) {
        forget_pass.setFill(Color.rgb(84, 51, 21));
    }

    @FXML
    private void changeColor3(MouseEvent event) {
        forget_pass.setFill(Color.rgb(255, 93, 93));
    }

    @FXML
    private void to_sign_up(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void changeColor2(MouseEvent event) {
        sign_up.setFill(Color.rgb(84, 51, 21));
    }

    @FXML
    private void changeColor(MouseEvent event) {
        sign_up.setFill(Color.rgb(255, 93, 93));
    }

    @FXML
    private void to_forget_pass(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forget_password.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
