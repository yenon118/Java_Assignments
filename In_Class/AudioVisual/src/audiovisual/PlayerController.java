/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiovisual;

import java.lang.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles
 */
public class PlayerController implements Initializable {
    
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
    
    @FXML
    private Text magText1;
    
    @FXML
    private Text magText2;
    
    @FXML
    private Text magText3;
    
    @FXML
    private Text magText4;
    
    @FXML
    private Text phaseText1;
    
    @FXML
    private Text phaseText2;
    
    @FXML
    private Text phaseText3;
    
    @FXML
    private Text phaseText4;
    
    @FXML
    private Ellipse ellipse1;
    
    @FXML
    private Ellipse ellipse2;
    
    @FXML
    private Ellipse ellipse3;
    
    @FXML
    private Ellipse ellipse4;
    
    @FXML
    private ImageView c; 
    
    @FXML
    private ImageView o1;
    
    @FXML
    private ImageView o2;
    
    @FXML
    private ImageView l;
    
    Media media;
    MediaPlayer mediaPlayer;
    int x = 0;

    
    String[] songs = {  "Sublime - Scarlet Begonias.mp3",
                        "Audio Adrenaline - Beautiful.mp3",
                        "Slightly Stoopid - Closer to the Sun.mp3",
                        "James Hersey - Miss You.mp3",
                        "Are You In.mp3",
                        "Flake - Jack Johnson.mp3", 
                        "bensound-scifi.mp3"
    };

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void handlePlay() {
        setupUI(songs[x]);
        mediaPlayer.play();
    }
    
    @FXML
    private void handlePause() {
        if(isRunning()){
            mediaPlayer.pause();
        }
    }
    
    @FXML
    private void handleStop() {
        if(isRunning()){
            mediaPlayer.stop();
        }
    }
    
    @FXML
    private void handleNext(){
        if(isRunning()){
            mediaPlayer.stop();
        }
        
        x++;
        if(x>6){x=0;}
        handlePlay();
    }
    
    private void setupUI(String song){
        media = new Media(this.getClass().getResource(song).toExternalForm());
        
        mediaPlayer = new MediaPlayer(media);
        
        mediaPlayer.setAutoPlay(true);
        
        mediaPlayer.setAudioSpectrumNumBands(10);
        mediaPlayer.setAudioSpectrumInterval(0.01);
        
        mediaPlayer.setAudioSpectrumListener((double timestamp, double duration, float[] magnitudes, float[] phases) ->{
            if(magnitudes.length >= 4 && phases.length >= 4){
                System.out.println("Timestamp: " + timestamp);
                System.out.println("Duration: " + duration);
                System.out.println("Magnitudes: " + magnitudes[0] + ", " + magnitudes[1] + ", " + magnitudes[2] + ", " + magnitudes[3]);
                System.out.println("Phases: " + phases[0] + ", " + phases[1] + ", " + phases[2] + ", " + phases[3]);
                
                magText1.setText(String.valueOf(magnitudes[0]));
                magText2.setText(String.valueOf(magnitudes[1]));
                magText3.setText(String.valueOf(magnitudes[2]));
                magText4.setText(String.valueOf(magnitudes[3]));
                
                phaseText1.setText(String.valueOf(phases[0]));
                phaseText2.setText(String.valueOf(phases[1]));
                phaseText3.setText(String.valueOf(phases[2]));
                phaseText4.setText(String.valueOf(phases[3]));
                
                ellipse1.setRadiusX(Math.abs(magnitudes[0]));
                ellipse1.setRadiusY(Math.abs(magnitudes[0]));
                
                ellipse2.setRadiusX(Math.abs(magnitudes[1]));
                ellipse2.setRadiusY(Math.abs(magnitudes[1]));
                
                ellipse3.setRadiusX(Math.abs(magnitudes[2]));
                ellipse3.setRadiusY(Math.abs(magnitudes[2]));
                
                ellipse4.setRadiusX(Math.abs(magnitudes[3]));
                ellipse4.setRadiusY(Math.abs(magnitudes[3]));
                
                c.setRotate(phases[0]);
                o1.setRotate(phases[1]);
                o2.setRotate(phases[2]);
                l.setRotate(phases[3]);
                
            }
        });
    }
    
    public boolean isRunning(){
        if(mediaPlayer.getAudioSpectrumListener() != null){
            if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                return true;
            }
        }
        
        return false;
        
    }
    
    
    
}