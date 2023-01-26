/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javax.sound.sampled.LineUnavailableException;
import static lasen.Lasen.getRandomStringCorr;
import static lasen.Lasen.getRandomStringInCorr;
import static lasen.Lasen.media3;
import static lasen.Lasen.media4;
import static lasen.Lasen.mediaPlayer;
import static lasen.Lasen.mediaPlayer2;
import static lasen.Lasen.mediaPlayer3;
import static lasen.Lasen.mediaPlayer4;
import static lasen.userSignInNow.getCurrrentBalance;
import static lasen.userSignInNow.getDimonds;
import static lasen.userSignInNow.increaseUserCurrrentBalance;
import static lasen.userSignInNow.increaseUserDimonds;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    private Text dimonds;
    @FXML
    private Text coins;
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
    @FXML
    private Pane record_pan;
    @FXML
    private Button refresh_bt;
    @FXML
    private Button get_help_bt;
    @FXML
    private Button micerphone_bt;
    @FXML
    private ImageView character;
    @FXML
    private ImageView sound_img;
    @FXML
    private ImageView music_img;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private ImageView image_recod_pane;
     
    
    private ImageView imageView_0;
    private ImageView imageView_1;
    private ImageView imageView_2;
    FileInputStream unmuteFile_back;
    private boolean firstButtonClicked = false;
    private int firstButtonIndex;
    private int secondButtonIndex;
    private boolean match;
    String image_value;
    private ImageView imageDispaly;
    
    ImageView view_background_0 ;
    ImageView view_background_1;
    ImageView view_background_2 ;
    ImageView view_background_3;; 
    ImageView view_background_close0 ;
    ImageView view_background_close1;
    ImageView view_background_close2 ;
    ImageView view_background_close3;    
    
    MemoryGame memoryGame = new MemoryGame();
    FileInputStream unmuteFile_background;
    
    boolean[] button_match={false,false, false ,false};
   
    
   ArrayList<Button> buttons = new ArrayList<>();
   ArrayList<ImageView> images = new ArrayList<>();

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> hideButtons()));
    //    Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(3.5), e ->shwoRecord()));
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    boolean voice_pane=false;
    byte[] photo;
    public static int w_id;
    public static int lvl_num;
    String word_text=null;
    List<word> WordList = null; 
    AudioRecording AudioRecording = new AudioRecording();
    int Ismatch=0; 
    @FXML
    private Circle recording;
   
    

        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     
        dimonds.setText(getDimonds());
        coins.setText(getCurrrentBalance());
        
        sound_slider.setValue(mediaPlayer.getVolume()*100);
        sound_slider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable) 
            {
              mediaPlayer.setVolume(sound_slider.getValue()/100);
            }
        });
        
        music_slider.setValue(mediaPlayer2.getVolume()*400);
        music_slider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable) 
            {
              mediaPlayer2.setVolume(music_slider.getValue()/100);
            }
        });
        
        buttons.addAll(Arrays.asList(button0, button1, button2, button3));
        images.addAll(Arrays.asList( imageView_0,imageView_1,imageView_2,imageView_2));
        
        try 
        {
           unmuteFile_back = new FileInputStream("src\\lasen\\image\\background.png");
        } 
        catch (FileNotFoundException ex)
        {
           Logger.getLogger(First_levelController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           Image img = new Image(unmuteFile_back);
           
           view_background_0 = new ImageView(img);   
           view_background_0.setFitWidth(160);
           view_background_0.setFitHeight(160); 
          // view_background_0.setPreserveRatio(true);
          
           view_background_1 = new ImageView(img);   
           view_background_1.setFitWidth(160);
           view_background_1.setFitHeight(160); 
          
           view_background_2 = new ImageView(img);   
           view_background_2.setFitWidth(160);
           view_background_2.setFitHeight(160);  
           
           view_background_3 = new ImageView(img);   
           view_background_3.setFitWidth(160);
           view_background_3.setFitHeight(160); 
           
           view_background_close0 = new ImageView(img);   
           view_background_close0.setFitWidth(160);
           view_background_close0.setFitHeight(160);
           
           view_background_close1 = new ImageView(img);   
           view_background_close1.setFitWidth(160);
           view_background_close1.setFitHeight(160);
           
           view_background_close2 = new ImageView(img);   
           view_background_close2.setFitWidth(160);
           view_background_close2.setFitHeight(160); 
           
           view_background_close3 = new ImageView(img);   
           view_background_close3.setFitWidth(160);
           view_background_close3.setFitHeight(160); 
          
           buttons.get(0).setGraphic(view_background_0);
           buttons.get(1).setGraphic(view_background_1);
           buttons.get(2).setGraphic(view_background_2);
           buttons.get(3).setGraphic(view_background_3);
           
           memoryGame.setupGame(); 
    
        Session session = HibernateUtil.getSessionFactory().openSession();
        WordList = null;
        String queryStr = "from word WHERE level_no=1";
        Query query = session.createQuery(queryStr);
        WordList = query.list();       
        session.close();
                             
    }
    
    @FXML
    void buttonClickedCard(ActionEvent event) throws FileNotFoundException 
    {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        if(!firstButtonClicked)
        {
                //If next turn is started before old buttons are hidden

                 // timeline2.play();
            if(!match)
            {
                hideButtons();
                timeline.stop();
            }

            match = false;
            firstButtonClicked = true;

            //Get clicked button memory letter
            String buttonId = ((Control)event.getSource()).getId();
            firstButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
            System.out.println(" the  "+firstButtonIndex);
            String Image_value=memoryGame.getOptionAtIndex(firstButtonIndex);
            System.out.println("it is "+Image_value);                  

            for(int i=0; i< WordList.size();i++)
            {
                if(WordList.get(i).getText().equals(Image_value))
                {
                    photo=WordList.get(i).getImg();
                    w_id=WordList.get(i).getWord_id();
                    lvl_num=WordList.get(i).getLevel_no();
                    word_text=WordList.get(i).getText();
                    System.out.println(word_text);
                    break;
                }
            }

            Image selectedImage = new Image(new ByteArrayInputStream(photo)); 
            ImageView view = new ImageView(selectedImage);
            view.setFitWidth(160);
            view.setFitHeight(160);
            buttons.get(firstButtonIndex).setGraphic(view);
            System.out.println(", thre button is : "+buttonId);
            return;

        }

        //Get clicked button memory letter
        String buttonId = ((Control)event.getSource()).getId();
        secondButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
        System.out.println(" the2  "+secondButtonIndex);       
        String Image_value=memoryGame.getOptionAtIndex(secondButtonIndex);
        System.out.println("it is "+Image_value);

        for(int i=0; i< WordList.size();i++)
        {
            if(WordList.get(i).getText().equals(Image_value))
            {
                photo=WordList.get(i).getImg();
                w_id=WordList.get(i).getWord_id();
                lvl_num=WordList.get(i).getLevel_no();
                word_text=WordList.get(i).getText();
                System.out.println(word_text);
                break;
            }
        }

        Image selectedImage = new Image(new ByteArrayInputStream(photo)); 
        ImageView view = new ImageView(selectedImage);
        view.setFitWidth(160);
        view.setFitHeight(160);
        buttons.get(secondButtonIndex).setGraphic(view);
 
        System.out.println("value of secand card "+image_value );
        System.out.println(" thre button is :"+buttonId);
        firstButtonClicked = false;

         //Check if the two clicked button match

        if(memoryGame.checkTwoPositions(firstButtonIndex,secondButtonIndex))
        {
            System.out.println("Match");
            button_match[firstButtonIndex]=true;
            button_match[secondButtonIndex]=true;
            match = true;
            image_recod_pane.setImage(selectedImage);
            shwoRecord();
            image_recod_pane.setVisible(true);
            // timeline2.stop();
            return;
        }

        timeline.play();

    }
    
    private void shwoRecord()
    {
         
         record_pan.setVisible(true);
    }

    private void hideButtons()
    {    
        if(firstButtonIndex==0){ buttons.get(firstButtonIndex).setGraphic(view_background_close0); }      
        if(firstButtonIndex==1){ buttons.get(firstButtonIndex).setGraphic(view_background_close1); }
        if(firstButtonIndex==2){ buttons.get(firstButtonIndex).setGraphic(view_background_close2); }
        if(firstButtonIndex==3){ buttons.get(firstButtonIndex).setGraphic(view_background_close3); }      
        if(secondButtonIndex==0){ buttons.get(secondButtonIndex).setGraphic(view_background_close0); }
        if(secondButtonIndex==1){ buttons.get(secondButtonIndex).setGraphic(view_background_close1); }
        if(secondButtonIndex==2){ buttons.get(secondButtonIndex).setGraphic(view_background_close2); }
        if(secondButtonIndex==3){ buttons.get(secondButtonIndex).setGraphic(view_background_close3); }  
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
        Lasen.mediaPlayer.play();
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
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        mediaPlayer2.play();
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
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
        mediaPlayer2.play();
        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void refresh_cards(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
    }

    @FXML
    private void get_help(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
    }

    boolean StartORStop=true;        
    @FXML
    private void record_sound(ActionEvent event) throws LineUnavailableException, IOException {
        
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
       
        if(StartORStop)
        {
            StartORStop=false;
            AudioRecording.startRecording();
            recording.setVisible(true);

        }
        else
        {            
           String result = AudioRecording.stopRecording();
           recording.setVisible(false);
           System.out.print(result);
           
           Session session = HibernateUtil.getSessionFactory().openSession();      
            List<user_pronounce_word> record_list = null;
            String queryStr = "from user_pronounce_word";
            Query query = session.createQuery(queryStr);
            record_list =  query.list();
            session.close();
           
           int Distance=0;
           StartORStop=true;            
           for(int i=0; i<WordList.size(); i++)
            {
                if(WordList.get(i).getText().equals(word_text))
                {
                    LevenshteinDistanceDP LevenshteinDistanceDP = new LevenshteinDistanceDP();        
                    Distance = LevenshteinDistanceDP.compute_Levenshtein_distanceDP(WordList.get(i).getPhoneme(), result);                                                
                    System.out.print(Distance);
                    if(Distance==0)
                    {   
                        for(user_pronounce_word u: record_list){
                if (w_id == u.getWord_id() && userSignInNow.userSignIn.equals(u.getEmail())){
                    if(u.getCorrect_count()==0){
                        Session session5 = HibernateUtil.getSessionFactory().openSession();
                        session5.beginTransaction();
                        u.setCorrect_count(1);
                        session5.update(u);
                        session5.getTransaction().commit();
                        session5.close(); 
                        System.out.println("yes row updated");
                    }else {
                    System.out.println("yes row updated");
                    }
                }else {
                    increaseUserDimonds();
                    user_pronounce_word w = new user_pronounce_word();
                    w.setWord_id(w_id);
                    w.setLevel_no(lvl_num);
                    w.setEmail(userSignInNow.userSignIn);
                    w.setCorrect_count(1);
                    w.setIncorrect_count(w.getIncorrect_count());               
                    Session session3 = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session3.beginTransaction();
                    session3.save(w);
                    tx.commit();
                    session3.close();                
                    System.out.println("new row recorded");    
                }
            break;    
           }
                        media3 = new Media(getClass().getResource(getRandomStringCorr()).toExternalForm());
                        mediaPlayer3 = new MediaPlayer(media3);
                        mediaPlayer3.seek(Duration.seconds(0));
                        Lasen.mediaPlayer3.play();
                        record_pan.setVisible(false);
                        image_recod_pane.setVisible(false);
                        dimonds.setText(getDimonds());                         
                    } 
                }
            }
            if(Distance!=0)
            {
                for(user_pronounce_word x: record_list){
                if (w_id == x.getWord_id() && userSignInNow.userSignIn.equals(x.getEmail())){
                    Session session5 = HibernateUtil.getSessionFactory().openSession();
                    session5.beginTransaction();
                    x.setIncorrect_count(x.getIncorrect_count()+1);
                    session5.update(x);
                    session5.getTransaction().commit();
                    session5.close(); 
                    System.out.println("yes row updated");
                    
                }else{
                    if (w_id != x.getWord_id() && userSignInNow.userSignIn.equals(x.getEmail())){
                    user_pronounce_word w = new user_pronounce_word();
                    w.setWord_id(w_id);
                    w.setLevel_no(lvl_num);
                    w.setEmail(userSignInNow.userSignIn);
                    w.setCorrect_count(w.getCorrect_count());
                    w.setIncorrect_count(w.getIncorrect_count()+1);               
                    Session session6 = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session6.beginTransaction();
                    session6.save(w);
                    tx.commit();
                    session6.close();                
                    System.out.println("new row recorded");
                    }
                }
            break;   
            } 
                media4 = new Media(getClass().getResource(getRandomStringInCorr()).toExternalForm());
                mediaPlayer4 = new MediaPlayer(media4);
                mediaPlayer4.seek(Duration.seconds(0));
                Lasen.mediaPlayer4.play(); 
                increaseUserCurrrentBalance();
                coins.setText(getCurrrentBalance());
            }
        }      
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
