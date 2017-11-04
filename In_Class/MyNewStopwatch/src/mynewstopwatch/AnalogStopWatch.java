/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class AnalogStopWatch {
    
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
    
    private boolean tickButtonPressed = false;
    
    public AnalogStopWatch() {
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
        
        //rootContainer.getChildren().addAll(dialImageView, handImageView);
        
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        //Button tickButton = new Button("Tick");
        Button start = new Button("Start");
        buttonBox.getChildren().add(start);
        
        rootContainer.getChildren().addAll(buttonBox, dialImageView, handImageView);
        
        buttonBox.toFront();
        
//        tickButton.setOnAction((ActionEvent event)->{
//            System.out.println("Yo");
//            
////            if(tickButtonPressed){
////                setTickTimeSeconds(0.01);
////                tickButtonPressed = false;
////            }else{
////                setTickTimeSeconds(1.0);
////                tickButtonPressed = true;
////            }
//
//           if(tickTimeSeconds == 0.01){
//               setTickTimeSeconds(1.0);
//           }
//           else if(tickTimeSeconds == 1.0){
//               setTickTimeSeconds(0.01);
//           }
//           else{
//               setTickTimeSeconds(1.0);
//           }
//            
//        });
        
        start.setOnAction((ActionEvent event)->{
            if(isRunning()){
                stop();
            }else{
                start();
            }
        });
        
        
    }
    
    private void setupTimer(){
        if(isRunning()){
            timeline.stop();
        }
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeSeconds*1000), (ActionEvent)->{
            update();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private boolean isRunning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING)
                return true;
        }
        return false;
    }
    
    private void update(){
        secondsElapsed += tickTimeSeconds;
        double rotation = secondsElapsed * analogDeltaPerSeconds;
        handImageView.setRotate(rotation);
    }
    
    public void start(){
        timeline.play();
    }

    public void stop(){
        timeline.stop();
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
        this.tickTimeSeconds = tickTimeSeconds;
        setupTimer();
        
        if(!isRunning()){
            timeline.play();
        }
    }
    
}
