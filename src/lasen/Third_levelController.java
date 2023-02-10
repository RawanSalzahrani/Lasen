/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import static lasen.Lasen.getRandomStringCorr;
import static lasen.Lasen.getRandomStringInCorr;
import static lasen.Lasen.media3;
import static lasen.Lasen.media4;
import static lasen.Lasen.media5;
import static lasen.Lasen.mediaPlayer;
import static lasen.Lasen.mediaPlayer2;
import static lasen.Lasen.mediaPlayer3;
import static lasen.Lasen.mediaPlayer4;
import static lasen.Lasen.mediaPlayer5;
import static lasen.MemoryGame_3.fill_button3;
import static lasen.userSignInNow.decreaseUserCurrrentBalance;
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
public class Third_levelController implements Initializable {

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
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Pane record_pan;
    @FXML
    private Button refresh_bt;
    @FXML
    private Button micerphone_bt;

    public GridPane gameMatrix;
     
    byte[] photo;
    int w_id;
    int lvl_num;
    String word_text=null;
    List<word> WordList = null; 
    @FXML
    private ImageView sound_img;
    @FXML
    private ImageView music_img;
    
     AudioRecording AudioRecording = new AudioRecording();
    @FXML
    private ImageView character;
    String[] Phoneme;
   @FXML
    private Button button5;
    private ImageView imageView_0;
    private ImageView imageView_1;
    private ImageView imageView_2;
    
    FileInputStream unmuteFile_back;
    FileInputStream unable_refresh;
    FileInputStream unable_character;
    FileInputStream refresh;
    FileInputStream get_help;
    
    private boolean firstButtonClicked = false;
    private int firstButtonIndex;
    private int secondButtonIndex;
    private boolean match;
    String image_value;
    private ImageView imageDispaly;
    
    ImageView view_background_0 ;
    ImageView view_background_1;
    ImageView view_background_2 ;
    ImageView view_background_3;
    ImageView view_background_4 ;
    ImageView view_background_5;
    ImageView view_background_6 ;
    ImageView view_background_7;
    boolean[] button_match={false,false,false,false,false,false,false,false};
    ImageView view_background_close0 ;
    ImageView view_background_close1;
    ImageView view_background_close2 ;
    ImageView view_background_close3;
    ImageView view_background_close4 ;
    ImageView view_background_close5;  
    ImageView view_background_close6 ;
    ImageView view_background_close7;     
    
    MemoryGame_3 memoryGame = new MemoryGame_3();
    FileInputStream unmuteFile_background;
    
    
   ArrayList<Button> buttons = new ArrayList<>();
   ArrayList<ImageView> images = new ArrayList<>();

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> hideButtons()));
    Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(4), e ->hideRecord()));
    Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(10), e ->hideRecord()));
   
    private final Random random = new Random();
    private final String[] image_name =  {"MADRASA","MASJID","ASAD","MAKNASA","MISWAK","MISMAR","KURSI","KUSA"};
    boolean[] select ={false,false,false,false,false,false,false,false};
    int index_image;
         
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private ImageView image_recod_pane;
    @FXML
    private Circle recording;
    @FXML
    private Button get_help_bt;
    @FXML
    private ImageView refresh_img;
    @FXML
    private ImageView get_help_img;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        dimonds.setText(getDimonds());
        coins.setText(getCurrrentBalance());
        
        sound_slider.setValue(mediaPlayer.getVolume()*100);
        sound_slider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer.setVolume(sound_slider.getValue()/100);
            }
        });
        
        music_slider.setValue(mediaPlayer2.getVolume()*400);
        music_slider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer2.setVolume(music_slider.getValue()/100);
            }
        });
       
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        WordList = null;
        String queryStr = "from word WHERE level_no=3";
        Query query = session.createQuery(queryStr);
        WordList = query.list();       
        session.close();
        buttons.addAll(Arrays.asList(button0, button1, button2, button3,button4,button5,button6,button7));
       
        
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
           view_background_0.setFitHeight(140); 
        
          
           view_background_1 = new ImageView(img);   
           view_background_1.setFitWidth(160);
           view_background_1.setFitHeight(140); 
          
           view_background_2 = new ImageView(img);   
           view_background_2.setFitWidth(160);
           view_background_2.setFitHeight(140);  
           
           view_background_3 = new ImageView(img);   
           view_background_3.setFitWidth(160);
           view_background_3.setFitHeight(140); 
           
           view_background_4 = new ImageView(img);   
           view_background_4.setFitWidth(160);
           view_background_4.setFitHeight(140); 
            
           view_background_5 = new ImageView(img);   
           view_background_5.setFitWidth(160);
           view_background_5.setFitHeight(140); 
           
           view_background_6 = new ImageView(img);   
           view_background_6.setFitWidth(160);
           view_background_6.setFitHeight(140); 
            
           view_background_7 = new ImageView(img);   
           view_background_7.setFitWidth(160);
           view_background_7.setFitHeight(140);
           
           view_background_close0 = new ImageView(img);   
           view_background_close0.setFitWidth(160);
           view_background_close0.setFitHeight(140);
           
           view_background_close1 = new ImageView(img);   
           view_background_close1.setFitWidth(160);
           view_background_close1.setFitHeight(140);
           
           view_background_close2 = new ImageView(img);   
           view_background_close2.setFitWidth(160);
           view_background_close2.setFitHeight(140); 
           
           view_background_close3 = new ImageView(img);   
           view_background_close3.setFitWidth(160);
           view_background_close3.setFitHeight(140); 
           
           view_background_close4 = new ImageView(img);   
           view_background_close4.setFitWidth(160);
           view_background_close4.setFitHeight(140); 
          
           view_background_close5 = new ImageView(img);   
           view_background_close5.setFitWidth(160);
           view_background_close5.setFitHeight(140); 
            
           view_background_close6= new ImageView(img);   
           view_background_close6.setFitWidth(160);
           view_background_close6.setFitHeight(140); 
           
           view_background_close7 = new ImageView(img);   
           view_background_close7.setFitWidth(160);
           view_background_close7.setFitHeight(140);   
           
            buttons.get(0).setGraphic(view_background_0);
            buttons.get(1).setGraphic(view_background_1);
            buttons.get(2).setGraphic(view_background_2);
            buttons.get(3).setGraphic(view_background_3);
            buttons.get(4).setGraphic(view_background_4);
            buttons.get(5).setGraphic(view_background_5);
            buttons.get(6).setGraphic(view_background_6);
            buttons.get(7).setGraphic(view_background_7);
            
       
        memoryGame.setupGame(); 
    
        for(int p =0; p <image_name.length; p++) {
               for(int h=0;h<fill_button3.length;h++) {

               if(fill_button3[h].equals(image_name[p]))
                {
                           select[p]=true;
                }
          }
          }
    
    
    }
    
    @FXML
    void buttonClickedCard(ActionEvent event) throws FileNotFoundException 
    {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        
        if(!firstButtonClicked)
        {
            //If next turn is started before old buttons are hidden
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
            image_value=memoryGame.getOptionAtIndex(firstButtonIndex);
            System.out.println("it is "+image_value);

           for(int i=0; i< WordList.size();i++)
           {
             if(WordList.get(i).getText().equals(image_value))
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
           view.setFitHeight(140);
           buttons.get(firstButtonIndex).setGraphic(view);

           System.out.println("value of first card "+ word_text);
           System.out.println(", thre button is : "+buttonId);
           return;
        
        }

        //Get clicked button memory letter
        String buttonId = ((Control)event.getSource()).getId();
        secondButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
        System.out.println(" the2  "+secondButtonIndex);
        image_value=memoryGame.getOptionAtIndex(secondButtonIndex);
        System.out.println("it is "+image_value);
           
        for(int i=0; i< WordList.size();i++)
        {
            if(WordList.get(i).getText().equals(image_value))
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
       view.setFitHeight(140);
       buttons.get(secondButtonIndex).setGraphic(view);
  
       System.out.println("value of secand card "+ word_text);
       System.out.println(" thre button is :"+buttonId);
       firstButtonClicked = false;

       //Check if the two clicked button match
        if(memoryGame.checkTwoPositions(firstButtonIndex,secondButtonIndex))
        {
            System.out.println("Match");   
            button_match[firstButtonIndex]=true;
            button_match[secondButtonIndex]=true;
            match = true;  
            
            Session session = HibernateUtil.getSessionFactory().openSession();      
            List<user_pronounce_word> record_list = null;
            String queryStr = "from user_pronounce_word";
            Query query = session.createQuery(queryStr);
            record_list =  query.list();
            session.close();
            for(user_pronounce_word u: record_list){
                if (userSignInNow.userSignIn.equals(u.getEmail()) && w_id == u.getWord_id() ){
                    Session session5 = HibernateUtil.getSessionFactory().openSession();
                        session5.beginTransaction();
                        u.setIncorrect_count(0);
                        session5.update(u);
                        session5.getTransaction().commit();
                        session5.close(); 
                        System.out.println("Now Incorrect count is 0");
                }
            }
           
            for(int k=0 ; k < image_name.length ; k++){
                 
                if(image_value.equals(image_name[k]))
                { 
                    index_image=k;
                }
                 System.out.println("is selet  "+select[k]+ "at index: "+k);
                 System.out.println("");
            }
            image_recod_pane.setImage(selectedImage);
            shwoRecord();
            return;
        }

        timeline.play();
      
    }
    
    private void shwoRecord()
    {         
         record_pan.setVisible(true);
         image_recod_pane.setVisible(true);
    }
    
    private void hideRecord()
    {        
         record_pan.setVisible(false);
         image_recod_pane.setVisible(false);
         character.setVisible(false);
    }
    
   
    private void hideButtons()
    {
       if(firstButtonIndex==0){ buttons.get(firstButtonIndex).setGraphic(view_background_close0); }
       if(firstButtonIndex==1){ buttons.get(firstButtonIndex).setGraphic(view_background_close1); }
       if(firstButtonIndex==2){ buttons.get(firstButtonIndex).setGraphic(view_background_close2); }
       if(firstButtonIndex==3){ buttons.get(firstButtonIndex).setGraphic(view_background_close3); }
       if(firstButtonIndex==4){ buttons.get(firstButtonIndex).setGraphic(view_background_close4); }
       if(firstButtonIndex==5){ buttons.get(firstButtonIndex).setGraphic(view_background_close5); }
       if(firstButtonIndex==6){ buttons.get(firstButtonIndex).setGraphic(view_background_close6); }
       if(firstButtonIndex==7){ buttons.get(firstButtonIndex).setGraphic(view_background_close7); }
       if(secondButtonIndex==0){ buttons.get(secondButtonIndex).setGraphic(view_background_close0); }
       if(secondButtonIndex==1){ buttons.get(secondButtonIndex).setGraphic(view_background_close1); }
       if(secondButtonIndex==2){ buttons.get(secondButtonIndex).setGraphic(view_background_close2); }
       if(secondButtonIndex==3){ buttons.get(secondButtonIndex).setGraphic(view_background_close3); }
       if(secondButtonIndex==4){ buttons.get(secondButtonIndex).setGraphic(view_background_close4); }
       if(secondButtonIndex==5){ buttons.get(secondButtonIndex).setGraphic(view_background_close5); }
       if(secondButtonIndex==6){ buttons.get(secondButtonIndex).setGraphic(view_background_close6); }
       if(secondButtonIndex==7){ buttons.get(secondButtonIndex).setGraphic(view_background_close7); }           
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
        mediaPlayer.play();
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
    private void refresh_cards(ActionEvent event){
        
       select[index_image]=false;
       
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        
        try {           
        unable_refresh = new FileInputStream("src\\lasen\\image\\unable_refresh.png");
        unable_character = new FileInputStream("src\\lasen\\image\\unable_character.png");
        Image disable_refresh = new Image(unable_refresh);
        Image disable_get_help = new Image(unable_character); 
        refresh_img.setImage(disable_refresh);
        get_help_img.setImage(disable_get_help);       
        } catch (FileNotFoundException ex) {
        Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();      
        List<user_pronounce_word> record_list = null;
        String queryStr2 = "from user_pronounce_word";
        Query query2 = session2.createQuery(queryStr2);
        record_list =  query2.list();
        session2.close();
        for(user_pronounce_word u: record_list)
        {
            if (w_id == u.getWord_id() && userSignInNow.userSignIn.equals(u.getEmail()) && u.getIncorrect_count()>=3)
            {                
                index_image =random.nextInt(image_name.length);
                
               while(select[index_image] )
                {
                   index_image=random.nextInt(image_name.length);
                }
                
               for(int k=0 ; k < image_name.length ; k++){
                System.out.println("is selet  "+select[k]+ "at index:  "+k);
            }
               System.out.print(" ///////// " );
                String update_img = image_name[index_image];
                
                for(int i=0; i< WordList.size();i++)
                {
                    if(WordList.get(i).getText().equals(update_img))
                    {
                        photo=WordList.get(i).getImg();
                        w_id=WordList.get(i).getWord_id();
                        lvl_num=WordList.get(i).getLevel_no();
                        word_text=WordList.get(i).getText();
                        System.out.println(word_text);
                        break;
                    }
                }
                
                for(user_pronounce_word v: record_list)
                {
                    if (w_id == v.getWord_id() && userSignInNow.userSignIn.equals(v.getEmail()))
                    {
                        Session session5 = HibernateUtil.getSessionFactory().openSession();
                        session5.beginTransaction();
                        v.setIncorrect_count(0);
                        session5.update(v);
                        session5.getTransaction().commit();
                        session5.close(); 
                        System.out.println("yes row updated");
                        break;         
                    }
                }                
                
                Image selectedImage = new Image(new ByteArrayInputStream(photo)); 
                ImageView view = new ImageView(selectedImage);
                view.setFitWidth(160);
                view.setFitHeight(160);
                ImageView view2 = new ImageView(selectedImage);
                view2.setFitWidth(160);
                view2.setFitHeight(160);
                buttons.get(firstButtonIndex).setGraphic(view);
                buttons.get(secondButtonIndex).setGraphic(view2);
                image_recod_pane.setImage(selectedImage);
            }
        }        
    }

     @FXML
    private void get_help(ActionEvent event) throws LineUnavailableException, IOException{
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        
        try {
            FileInputStream helpChar = new FileInputStream("src\\lasen\\image\\stand_smile.png");
            Image helpCharImage = new Image(helpChar);                 
            character.setImage(helpCharImage);                 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String wav=null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();      
        List<user> current_balance = null;
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        current_balance =  query.list();
        session.close();
        for(user b: current_balance)
        {
            if(userSignInNow.userSignIn.equals(b.getEmail()) && b.getCurrent_balance()>=15)
            {
                Session session2 = HibernateUtil.getSessionFactory().openSession();      
                List<user_pronounce_word> record_list = null;
                String queryStr2 = "from user_pronounce_word";
                Query query2 = session2.createQuery(queryStr2);
                record_list =  query2.list();
                session2.close();
                for(user_pronounce_word u: record_list)
                {
                    if (w_id == u.getWord_id() && userSignInNow.userSignIn.equals(u.getEmail()) && u.getIncorrect_count()>=3)
                    {
                        for(int i=0; i<WordList.size(); i++)
                        {
                            if(WordList.get(i).getText().equals(word_text))
                            {       
                                wav = WordList.get(i).getCorrect_pronounce();
                                break;
                            }
                        } 
                        decreaseUserCurrrentBalance();
                        coins.setText(getCurrrentBalance());
                        character.setVisible(true);
                        timeline3.play();
                        media5 = new Media(getClass().getResource(wav).toExternalForm());
                        mediaPlayer5 = new MediaPlayer(media5);
                        mediaPlayer5.seek(Duration.seconds(0));
                        Lasen.mediaPlayer5.play(); 
                        
                        break;
                    }              
                }
            
            }
        }                    
    }

    private void changeImageToAble(){  
        try {
            refresh = new FileInputStream("src\\lasen\\image\\refresh.png");
            get_help = new FileInputStream("src\\lasen\\image\\get_help.png");
            Image able_refresh = new Image(refresh);
            Image able_get_help = new Image(get_help);
            refresh_img.setImage(able_refresh);
            get_help_img.setImage(able_get_help);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void changeImageToDisable(){
        try {            
            unable_refresh = new FileInputStream("src\\lasen\\image\\unable_refresh.png");
            unable_character = new FileInputStream("src\\lasen\\image\\unable_character.png");
            Image disable_refresh = new Image(unable_refresh);
            Image disable_get_help = new Image(unable_character);
            refresh_img.setImage(disable_refresh);
            get_help_img.setImage(disable_get_help);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    boolean StartORStop=true;        
    @FXML
    private void record_sound(ActionEvent event) throws LineUnavailableException, IOException {
        
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
       
        try {
            FileInputStream happyChar = new FileInputStream("src\\lasen\\image\\jump_laf.png");
            Image happyCharImage = new Image(happyChar);                 
            character.setImage(happyCharImage);                 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
           String ph="null";
           int Distance=0;
           int oldRow=0;
           StartORStop=true;            
           for(int i=0; i<WordList.size(); i++)
            {
                if(WordList.get(i).getText().equals(word_text))
                {
                    Distance = ComputeDistance.compute_distance(WordList.get(i).getPhoneme(), result);                                                
                    System.out.print(Distance);
                     ph=WordList.get(i).getPhoneme();
                    if(Distance==0)
                    {   
                        for(user_pronounce_word u: record_list)
                        {
                            if (w_id == u.getWord_id() && userSignInNow.userSignIn.equals(u.getEmail()))
                            {
                                if(u.getCorrect_count()==0)
                                {
                                    increaseUserDimonds();
                                    Session session5 = HibernateUtil.getSessionFactory().openSession();
                                    session5.beginTransaction();
                                    u.setCorrect_count(1);
                                    session5.update(u);
                                    session5.getTransaction().commit();
                                    session5.close(); 
                                    System.out.println("yes row updated");
                                }
                                else 
                                {                               
                                    System.out.println("yes row updated");
                                }
                                oldRow++;
                                break;
                            }             
                        }
                        if(oldRow==0)
                        {
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
                        select[index_image]=true;
                        character.setVisible(true);
                        media3 = new Media(getClass().getResource(getRandomStringCorr()).toExternalForm());
                        mediaPlayer3 = new MediaPlayer(media3);
                        mediaPlayer3.seek(Duration.seconds(0));
                        Lasen.mediaPlayer3.play();
                        timeline2.play();
                        dimonds.setText(getDimonds());
                    }
                    
                }
            }
            if(Distance>0)
            {
                for(user_pronounce_word x: record_list)
                {
                    if (w_id == x.getWord_id() && userSignInNow.userSignIn.equals(x.getEmail()))
                    {
                        Session session5 = HibernateUtil.getSessionFactory().openSession();
                        session5.beginTransaction();
                        x.setIncorrect_count(x.getIncorrect_count()+1);
                        session5.update(x);
                        session5.getTransaction().commit();
                        session5.close(); 
                        System.out.println("yes row updated");
                        oldRow++;
                        break;
                    }                   
                }
                if(oldRow==0)
                {
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
                media4 = new Media(getClass().getResource(getRandomStringInCorr()).toExternalForm());
                mediaPlayer4 = new MediaPlayer(media4);
                mediaPlayer4.seek(Duration.seconds(0));
                Lasen.mediaPlayer4.play(); 
                increaseUserCurrrentBalance();
                coins.setText(getCurrrentBalance());
            }
            for(user_pronounce_word x: record_list)
                {
                    if (w_id == x.getWord_id() && userSignInNow.userSignIn.equals(x.getEmail()) && x.getIncorrect_count()>=3)
                    {
                        changeImageToAble();                        
                    }else {                        
                        changeImageToDisable();
                        break;
                    }
                    
                }
             WriteInFile.writeFile(userSignInNow.userName,word_text,ph,result,Distance);
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
