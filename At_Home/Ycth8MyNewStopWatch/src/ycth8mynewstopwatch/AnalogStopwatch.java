/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class AnalogStopwatch {
    
    private double tickTimeSeconds = 0.01;
    private final double analogDeltaPerSeconds = 6.0;
    private double secondsElapsed;
    
    private Timeline timeline;
    private KeyFrame keyFrame;

    private StackPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private final String dialImageName = "clockface.png";
    private final String handImageName = "hand.png";
    
    public AnalogStopwatch() {
        setupUI();
        
        setupTimer();
    }
    
    private void setupUI(){
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        rootContainer.getChildren().addAll(dialImageView, handImageView);
        
    }
    
    private void setupTimer(){
        keyFrame = new KeyFrame(Duration.millis(tickTimeSeconds*1000), (ActionEvent)->{
            update();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private void update(){
        secondsElapsed += tickTimeSeconds;
        double rotation = secondsElapsed * analogDeltaPerSeconds;
        handImageView.setRotate(rotation);
    }
    
    public void start(){
        timeline.play();
    }

    public StackPane getRootContainer() {
        return rootContainer;
    }

    public Double getWidth(){
        if(dialImage != null){
            return dialImage.getWidth();
        }
        else{
            return 0.0;
        }
    }
    
    public Double getHeight(){
        if(dialImage != null){
            return dialImage.getHeight();
        }
        else{
            return 0.0;
        }
    }
    
    public void setTickTimeSeconds(Double tickTimeSeconds){
        timeline.stop();
        this.tickTimeSeconds = tickTimeSeconds;
        setupTimer();
        //timeline.getKeyFrames().clear();
        //timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    
}
