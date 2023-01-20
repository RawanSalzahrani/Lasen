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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Third_levelController implements Initializable {

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
    private Button get_helo_bt;
    @FXML
    private Button micerphone_bt;

   @FXML
    public GridPane gameMatrix;
     
     byte[] photo;
     
      Board3 board = new Board3();
     
    Cell firstCard = null;
    Cell secondCard = null;
    @FXML
    private ImageView sound_img;
    @FXML
    private ImageView music_img;
    
     AudioRecording AudioRecording = new AudioRecording();
    @FXML
    private ImageView character;
    String[] Phoneme;
    /**
     * Initializes the controller class.
     */
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
       
         board.populateMatrix();
            
         FileInputStream input;
                
        try {
            
       
        for (int row = 0; row <2; row++) {
            for (int col = 0; col <4; col++) {
               input = new FileInputStream(
                       "src\\lasen\\image\\background.png");
                 
               Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(155);
                imageView.setFitHeight(120);
                imageView.setUserData(row+","+col);
                
                imageView.setOnMouseClicked(event -> {
                    try {
                        cardListener(event);}
                    
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }});
                
                gameMatrix.add(imageView,row, col);
            }}
        
        
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(First_levelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         Session session = HibernateUtil.getSessionFactory().openSession();
        List<word> sList = null;
        String queryStr = "from word WHERE level_no=3";
        Query query = session.createQuery(queryStr);
        sList = query.list();       
        session.close();
        Phoneme = new String[sList.size()];
        int i=0;
        for(word u: sList){             
            Phoneme[i]=u.getPhoneme();
            i++;
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
    
    public void cardListener(MouseEvent event) throws FileNotFoundException {
        mediaPlayer.seek(Duration.seconds(0));
        mediaPlayer.play();
        
        Node sourceComponent = (Node) event.getSource();
        String rowAndColumn = (String)sourceComponent.getUserData();

        int rowSelected = Integer.parseInt(rowAndColumn.split(",")[0]);
        int colSelected = Integer.parseInt(rowAndColumn.split(",")[1]);

        String image = board.board[rowSelected][colSelected].value;

      Session session1 = HibernateUtil.getSessionFactory().openSession();
       
         List<word> word_list = null;
          String queryStr = "from word";
          Query query = session1.createQuery(queryStr);
          word_list =  query.list();
          session1.close();
          
           for(int i=0; i< word_list.size();i++){
        if(word_list.get(i).getText().equals(image)){
           
           photo=word_list.get(i).getImg();
           
          break;}
        }
        Image selectedImage = new Image(new ByteArrayInputStream(photo));
        
        
        ((ImageView)sourceComponent).setImage(selectedImage);
        checkIfMatchingPairWasFound(rowSelected,colSelected);

    }
     
     
      public void checkIfMatchingPairWasFound(int rowSelected, int colSelected) throws FileNotFoundException {

        if(firstCard == null){
            firstCard = board.board[rowSelected][colSelected];
        }else if(secondCard ==null){
            secondCard = board.board[rowSelected][colSelected];
        }else {
            if(firstCard.value.equals(secondCard.value)){
                //matching pair
                board.board[firstCard.row][firstCard.col].wasGuessed = true;
                board.board[secondCard.row][secondCard.col].wasGuessed = true;
                record_pan.setVisible(true);
            } else {
                int indexFirstCardInList = (firstCard.row *4) + firstCard.col;

                FileInputStream questionFile = new FileInputStream("src\\lasen\\image\\background.png");
                
                Image questionImage = new Image(questionFile);
                ((ImageView)gameMatrix.getChildren().get(indexFirstCardInList)).setImage(questionImage);

                int indexSecondCardInList = (secondCard.row * 4) + secondCard.col;
                ((ImageView)gameMatrix.getChildren().get(indexSecondCardInList)).setImage(questionImage);
            }

            firstCard= board.board[rowSelected][colSelected];
            secondCard = null;

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
