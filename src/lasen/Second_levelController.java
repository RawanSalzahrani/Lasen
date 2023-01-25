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
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import static lasen.Lasen.mediaPlayer;
import static lasen.Lasen.mediaPlayer2;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class Second_levelController implements Initializable {
    
    

    @FXML
    private Button setting;
    @FXML
    private Button home;
    @FXML
    private Button dimonds;
    @FXML
    private Button coins;
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
    private Button get_help_bt;
    @FXML
    private Button micerphone_bt;
    public GridPane gameMatrix;
    boolean voice_pane=false;
    byte[] photo;
    int w_id;
    int lvl_num;
    String word_text=null;
    List<word> WordList = null; 
    AudioRecording AudioRecording = new AudioRecording();
    int Ismatch=0; 
    @FXML
    private ImageView image_recod_pane;
    Cell firstCard = null;
    Cell secondCard = null;
    @FXML
    private ImageView music_img;
    @FXML
    private ImageView sound_img;
    
    @FXML
    private ImageView character;
    String[] Phoneme;
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
    private Button button5;
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
    ImageView view_background_3;
    ImageView view_background_4 ;
    ImageView view_background_5;
    ImageView view_background_close0 ;
    ImageView view_background_close1;
    ImageView view_background_close2 ;
    ImageView view_background_close3;
    ImageView view_background_close4 ;
    ImageView view_background_close5;  
    
    
    MemoryGame_2 memoryGame = new MemoryGame_2();
    FileInputStream unmuteFile_background;
    
    boolean[] button_match={false,false,false,false,false ,false};
   
    
   ArrayList<Button> buttons = new ArrayList<>();
   ArrayList<ImageView> images = new ArrayList<>();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> hideButtons()));
    //    Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(3.5), e ->shwoRecord()));
   
    
     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        sound_slider.setValue(mediaPlayer.getVolume()*100);
        sound_slider.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer.setVolume(sound_slider.getValue()/100);
            }
        });
        
        music_slider.setValue(mediaPlayer2.getVolume()*400);
        music_slider.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
              mediaPlayer2.setVolume(music_slider.getValue()/100);
            }
        });
       
         
         Session session = HibernateUtil.getSessionFactory().openSession();
        List<word> sList = null;
        String queryStr = "from word WHERE level_no=2";
        Query query = session.createQuery(queryStr);
        sList = query.list();       
        session.close();
        Phoneme = new String[sList.size()];
        int i=0;
        for(word u: sList){             
            Phoneme[i]=u.getPhoneme();
            i++;
        }
        buttons.addAll(Arrays.asList(button0, button1, button2, button3,button4,button5));
        images.addAll(Arrays.asList( imageView_0,imageView_1,imageView_2,imageView_2));
        
        try {
           unmuteFile_back = new FileInputStream("C:\\Users\\Khulood  Alyaf3Y\\Documents\\GitHub\\Lasen\\src\\lasen\\image\\background.png");
       } catch (FileNotFoundException ex) {
           Logger.getLogger(First_levelController.class.getName()).log(Level.SEVERE, null, ex);
       }
           
           Image img = new Image(unmuteFile_back);
           
           view_background_0 = new ImageView(img);   
           view_background_0.setFitWidth(130);
           view_background_0.setFitHeight(140); 
          // view_background_0.setPreserveRatio(true);
          
           view_background_1 = new ImageView(img);   
           view_background_1.setFitWidth(130);
           view_background_1.setFitHeight(140); 
          
           view_background_2 = new ImageView(img);   
           view_background_2.setFitWidth(130);
           view_background_2.setFitHeight(140);  
           
           view_background_3 = new ImageView(img);   
           view_background_3.setFitWidth(130);
           view_background_3.setFitHeight(140); 
           
           view_background_4 = new ImageView(img);   
           view_background_4.setFitWidth(130);
           view_background_4.setFitHeight(140); 
            
           view_background_5 = new ImageView(img);   
           view_background_5.setFitWidth(130);
           view_background_5.setFitHeight(140); 
           
           view_background_close0 = new ImageView(img);   
           view_background_close0.setFitWidth(130);
           view_background_close0.setFitHeight(140);
           
           view_background_close1 = new ImageView(img);   
           view_background_close1.setFitWidth(130);
           view_background_close1.setFitHeight(140);
           
           view_background_close2 = new ImageView(img);   
           view_background_close2.setFitWidth(130);
           view_background_close2.setFitHeight(140); 
           
           view_background_close3 = new ImageView(img);   
           view_background_close3.setFitWidth(130);
           view_background_close3.setFitHeight(140); 
           
           view_background_close4 = new ImageView(img);   
           view_background_close4.setFitWidth(130);
           view_background_close4.setFitHeight(140); 
          
           view_background_close5 = new ImageView(img);   
           view_background_close5.setFitWidth(130);
           view_background_close5.setFitHeight(140); 
          
            buttons.get(0).setGraphic(view_background_0);
            buttons.get(1).setGraphic(view_background_1);
            buttons.get(2).setGraphic(view_background_2);
            buttons.get(3).setGraphic(view_background_3);
            buttons.get(4).setGraphic(view_background_4);
            buttons.get(5).setGraphic(view_background_5);
            
       
        memoryGame.setupGame(); 
    }
    
    @FXML
    void buttonClickedCard(ActionEvent event) throws FileNotFoundException {if(!firstButtonClicked){
            //If next turn is started before old buttons are hidden
            
             // timeline2.play();
            if(!match){
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
           
            Session session1 = HibernateUtil.getSessionFactory().openSession();      
       
              List<word> word_list = null;
              String queryStr = "from word";
              Query query = session1.createQuery(queryStr);
              word_list =  query.list();
              session1.close();
        
          for(int i=0; i< word_list.size();i++)
           {
             if(word_list.get(i).getText().equals(Image_value))
             {
                photo=word_list.get(i).getImg();
                w_id=word_list.get(i).getWord_id();
                lvl_num=word_list.get(i).getLevel_no();
                word_text=word_list.get(i).getText();
                System.out.println(word_text);
                break;
             }
        }
       
           Image selectedImage = new Image(new ByteArrayInputStream(photo)); 
           ImageView view = new ImageView(selectedImage);
           view.setFitWidth(130);
           view.setFitHeight(150);
           buttons.get(firstButtonIndex).setGraphic(view);
           
           System.out.println("value of first card "+ word_text);
           System.out.println(", thre button is : "+buttonId);
           return;
        
        }

        //Get clicked button memory letter
        String buttonId = ((Control)event.getSource()).getId();
        secondButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
        System.out.println(" the2  "+secondButtonIndex);
        
                       
            String Image_value=memoryGame.getOptionAtIndex(secondButtonIndex);
            System.out.println("it is "+Image_value);
           
            Session session1 = HibernateUtil.getSessionFactory().openSession();      
       
              List<word> word_list = null;
              String queryStr = "from word";
              Query query = session1.createQuery(queryStr);
              word_list =  query.list();
              session1.close();
        
          for(int i=0; i< word_list.size();i++)
           {
             if(word_list.get(i).getText().equals(Image_value))
             {
                photo=word_list.get(i).getImg();
                w_id=word_list.get(i).getWord_id();
                lvl_num=word_list.get(i).getLevel_no();
                word_text=word_list.get(i).getText();
                System.out.println(word_text);
                break;
             }
        }
       
           Image selectedImage = new Image(new ByteArrayInputStream(photo)); 
           ImageView view = new ImageView(selectedImage);
           view.setFitWidth(130);
           view.setFitHeight(150);
           buttons.get(secondButtonIndex).setGraphic(view);
 
       
       
        
        System.out.println("value of secand card "+ word_text);
        System.out.println(" thre button is :"+buttonId);
        
        firstButtonClicked = false;

        
        
        //Check if the two clicked button match
        
        if(memoryGame.checkTwoPositions(firstButtonIndex,secondButtonIndex)){
            System.out.println("Match");
            
             button_match[firstButtonIndex]=true;
             button_match[secondButtonIndex]=true;
             match = true;
           
            image_recod_pane.setImage(selectedImage);
            record_pan.setVisible(true);
            image_recod_pane.setVisible(true);
           // timeline2.stop();
            return;
        }

        timeline.play();
      
    }
    
   
    private void hideButtons(){

             
        if(firstButtonIndex==0){
        buttons.get(firstButtonIndex).setGraphic(view_background_close0);}
       
       if(firstButtonIndex==1){
       buttons.get(firstButtonIndex).setGraphic(view_background_close1);
       }
       if(firstButtonIndex==2){
        buttons.get(firstButtonIndex).setGraphic(view_background_close2);}
       
       if(firstButtonIndex==3){
       buttons.get(firstButtonIndex).setGraphic(view_background_close3);
       }
       if(firstButtonIndex==4){
        buttons.get(firstButtonIndex).setGraphic(view_background_close4);}
       
       if(firstButtonIndex==5){
       buttons.get(firstButtonIndex).setGraphic(view_background_close5);
       }
       
       
       if(secondButtonIndex==0){
        buttons.get(secondButtonIndex).setGraphic(view_background_close0);
       }
       if(secondButtonIndex==1){
        buttons.get(secondButtonIndex).setGraphic(view_background_close1);
       }
       if(secondButtonIndex==2){
        buttons.get(secondButtonIndex).setGraphic(view_background_close2);
       }
       if(secondButtonIndex==3){
        buttons.get(secondButtonIndex).setGraphic(view_background_close3);
       }
       
       if(secondButtonIndex==4){
        buttons.get(secondButtonIndex).setGraphic(view_background_close4);
       }
       if(secondButtonIndex==5){
        buttons.get(secondButtonIndex).setGraphic(view_background_close5);
       }
    
       
       
       
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
    private void refresh_cards(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
    }

    @FXML
    private void get_help(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
    }

    boolean x=true;
    @FXML
    private void record_sound(ActionEvent event) throws LineUnavailableException, IOException  {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        
        if(x)
        {
            x=false;
            AudioRecording.startRecording();
        }
        else
        {           
            String result = AudioRecording.stopRecording();
            x=true;
            for(int i=0; i<Phoneme.length; i++){
                LevenshteinDistanceDP LevenshteinDistanceDP = new LevenshteinDistanceDP();        
                int Distance = LevenshteinDistanceDP.compute_Levenshtein_distanceDP(Phoneme[i], result);
                if(Distance==0)
                {
                    character.setVisible(true);
                    break;
                }
               
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
