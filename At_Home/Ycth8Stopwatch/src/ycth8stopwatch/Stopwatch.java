/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8stopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class Stopwatch {
    
    private final double tickTimeSeconds = 0.01;
    private final double tickTimeHundredthsOfASeconds = 1;
    private final double analogDeltaPerSeconds = 6.0;
    private final double analogDeltaPerHundredthsOfASeconds = 3.6;
    private double secondsElapsed;
    private double hundredthsOfASecondsElapsed;
    
    private int previousHundredthsOfASeconds = 0;
    private int previousMilliseconds = 0;
    private int previousSeconds = 0;
    private int previousMinutes = 0;
    private int previousHours = 0;
    
    private int currentHundredthsOfASeconds;
    private int currentMilliseconds;
    private int currentSeconds;
    private int currentMinutes;
    private int currentHours;
    
    private int tempHundredthsOfASeconds;
    private int tempMilliseconds;
    private int tempSeconds;
    private int tempMinutes;
    private int tempHours;
    
    private int hundredthsOfASeconds;
    private int milliseconds;
    private int seconds;
    private int minutes;
    private int hours;
    private String timeString;
    private int lapCount;
    
    private Timeline timeline;
    private KeyFrame keyFrame;

    private StackPane rootContainer;
    private StackPane stackPane;
    
    private ImageView dialImageView;
    private ImageView handImageView;
    private ImageView minuteHandImageView;
    private ImageView hourHandImageView;
    private ImageView nanosecondHandImageView;
    
    private Image dialImage;
    private Image handImage;
    private Image minuteHandImage;
    private Image hourHandImage;
    private Image nanosecondHandImage;
    
    VBox verticalBox;
    HBox controlButtons;
    
    Label digitalDisplay;
    
    Button leftButton;
    Button rightButton;
    Button timeStringButton;
    
    private final String dialImageName = "clockface.png";
    private final String handImageName = "hand.png";
    private final String minuteHandImageName = "minuteHand.png";
    private final String hourHandImageName = "hourHand.png";
    private final String nanosecondHandImageName = "nanosecondHand.png";
    public final String fontStyle = "Comic";
    
    public Stopwatch() {
        setupUI();
        setupTimer();
    }
    
    private void setupUI(){
        stackPane = new StackPane();
        rootContainer = new StackPane();
        
        verticalBox = new VBox();
        digitalDisplay = new Label();
        controlButtons = new HBox();
        leftButton = new Button("Lap");
        rightButton = new Button("Start");
        timeStringButton = new Button("Hundredths Of A Second");
        
        dialImageView = new ImageView();
        handImageView = new ImageView();
        minuteHandImageView = new ImageView();
        hourHandImageView = new ImageView();
        nanosecondHandImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        minuteHandImage = new Image(getClass().getResourceAsStream(minuteHandImageName));
        hourHandImage = new Image(getClass().getResourceAsStream(hourHandImageName));
        nanosecondHandImage = new Image(getClass().getResourceAsStream(nanosecondHandImageName));
        
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        minuteHandImageView.setImage(minuteHandImage);
        hourHandImageView.setImage(hourHandImage);
        nanosecondHandImageView.setImage(nanosecondHandImage);
        
        stackPane.getChildren().addAll(dialImageView, hourHandImageView, minuteHandImageView, nanosecondHandImageView, handImageView);
        verticalBox.getChildren().add(stackPane);
        
        digitalDisplay.setFont(Font.font(fontStyle, FontWeight.NORMAL, 24));
        digitalDisplay.setPadding(new Insets(25,25,25,25)); 
        verticalBox.setAlignment(Pos.CENTER);
        
        verticalBox.getChildren().add(digitalDisplay);
        verticalBox.getChildren().add(timeStringButton);
        
        leftButton.setStyle("-fx-base: #E7E7B6;");
        leftButton.setMaxWidth(Double.MAX_VALUE);
        rightButton.setStyle("-fx-base: #b6e7c9;");
        rightButton.setMaxWidth(Double.MAX_VALUE);
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        
        controlButtons.getChildren().addAll(leftButton, rightButton);
        verticalBox.getChildren().add(controlButtons);
        rootContainer.getChildren().add(verticalBox);
        
        timeStringButton.setOnAction((ActionEvent event)->{
            if(timeStringButton.getText().equals("Hundredths Of A Second")){
                timeStringButton.setText("Milliseconds");
            }
            else if(timeStringButton.getText().equals("Milliseconds")){
                timeStringButton.setText("Hundredths Of A Second");
            }
        });
        
        rightButton.setOnAction((ActionEvent event)->{
            if(rightButton.getText().equals("Start")){
                timeline.play();
                rightButton.setText("Stop");
                rightButton.setStyle("-fx-base: #E7CFB6;");
                leftButton.setText("Lap");
                leftButton.setStyle("-fx-base: #E7E7B6;");
            }
            else if(rightButton.getText().equals("Stop")){
                //timeline.stop();
                timeline.pause();
                leftButton.setText("Reset");
                leftButton.setStyle("-fx-base: #E7BAB6;");
                
                rightButton.setText("Start");
                rightButton.setStyle("-fx-base: #b6e7c9;");
                
            }
        });
        
        leftButton.setOnAction((ActionEvent event)->{
            if(leftButton.getText().equals("Lap")){
                if(secondsElapsed != 0.0){
                    ++lapCount;
                    
                    tempHundredthsOfASeconds = hundredthsOfASeconds;
                    tempMilliseconds = milliseconds;
                    tempSeconds = seconds;
                    tempMinutes = minutes;
                    tempHours = hours;
                    
                    currentHundredthsOfASeconds = hundredthsOfASeconds;
                    currentMilliseconds = milliseconds;
                    currentSeconds = seconds;
                    currentMinutes = minutes;
                    currentHours = hours;
                    
                    if(timeStringButton.getText().equals("Hundredths Of A Second")){
                        if(tempHundredthsOfASeconds < previousHundredthsOfASeconds){
                            tempSeconds = tempSeconds - 1;
                            tempHundredthsOfASeconds = tempHundredthsOfASeconds + 100;
                            tempHundredthsOfASeconds = tempHundredthsOfASeconds - previousHundredthsOfASeconds;
                        }
                        else{
                            tempHundredthsOfASeconds = tempHundredthsOfASeconds - previousHundredthsOfASeconds;
                        }
                    }
                    else if(timeStringButton.getText().equals("Milliseconds")){
                        if(tempMilliseconds < previousMilliseconds){
                            tempSeconds = tempSeconds - 1;
                            tempMilliseconds = tempMilliseconds + 1000;
                            tempMilliseconds = tempMilliseconds - previousMilliseconds;
                        }
                        else{
                            tempMilliseconds = tempMilliseconds - previousMilliseconds;
                        }
                    }
                    
                    if(tempSeconds < previousSeconds){
                        tempMinutes = tempMinutes - 1;
                        tempSeconds = tempSeconds + 60;
                        tempSeconds = tempSeconds - previousSeconds;
                    }
                    else{
                        tempSeconds = tempSeconds - previousSeconds;
                    }
                    
                    if(tempMinutes < previousMinutes){
                        tempHours = tempHours - 1;
                        tempMinutes = tempMinutes + 60;
                        tempMinutes = tempMinutes - previousMinutes;
                    }
                    else{
                        tempMinutes = tempMinutes - previousMinutes;
                    }
                    
                    tempHours = tempHours - previousHours;
                    
                    if(timeStringButton.getText().equals("Hundredths Of A Second")){
                        System.out.println("Lap " + Integer.toString(lapCount) + " -> " + String.format("%02d", tempHours) + " : " + String.format("%02d", tempMinutes) + " : " + String.format("%02d", tempSeconds) + " . " + String.format("%02d", tempHundredthsOfASeconds));
                    }
                    else if(timeStringButton.getText().equals("Milliseconds")){
                        System.out.println("Lap " + Integer.toString(lapCount) + " -> " + String.format("%02d", tempHours) + " : " + String.format("%02d", tempMinutes) + " : " + String.format("%02d", tempSeconds) + " . " + String.format("%03d", tempMilliseconds));
                    }
                    
                    previousHundredthsOfASeconds = currentHundredthsOfASeconds;
                    previousMilliseconds = currentMilliseconds;
                    previousSeconds = currentSeconds;
                    previousMinutes = currentMinutes;
                    previousHours = currentHours;
                    
                }
            }
            else if(leftButton.getText().equals("Reset")){
                timeline.stop();

                handImageView.setRotate(0);
                minuteHandImageView.setRotate(0);
                hourHandImageView.setRotate(0);
                nanosecondHandImageView.setRotate(0);
                
                secondsElapsed = 0;
                hundredthsOfASeconds = 0;
                
                milliseconds = 0;
                seconds = 0;
                minutes = 0;
                hours = 0;
                
                if(timeStringButton.getText().equals("Hundredths Of A Second")){
                    timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%02d", hundredthsOfASeconds);
                }
                else if(timeStringButton.getText().equals("Milliseconds")){
                    timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%03d", milliseconds);
                }
                
                digitalDisplay.setText(timeString);

                lapCount = 0;
                
                leftButton.setText("Lap");
                leftButton.setStyle("-fx-base: #E7E7B6;");
                rightButton.setText("Start");
                rightButton.setStyle("-fx-base: #b6e7c9;");
            }
        });
        
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

        hundredthsOfASecondsElapsed += tickTimeHundredthsOfASeconds;
        rotation = hundredthsOfASecondsElapsed * analogDeltaPerHundredthsOfASeconds;
        nanosecondHandImageView.setRotate(rotation);

        hundredthsOfASeconds = (int) hundredthsOfASecondsElapsed % 100;
        milliseconds = (int) (secondsElapsed * 1000) % 1000;
        seconds = (int) secondsElapsed % 60;
        minutes = (int) (secondsElapsed / 60) % 60;
        hours = (int) secondsElapsed / 3600;

        rotation = minutes * analogDeltaPerSeconds;
        minuteHandImageView.setRotate(rotation);

        rotation = hours * analogDeltaPerSeconds;
        hourHandImageView.setRotate(rotation);
        
        if(timeStringButton.getText().equals("Hundredths Of A Second")){
            timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%02d", hundredthsOfASeconds);
        }
        else if(timeStringButton.getText().equals("Milliseconds")){
            timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%03d", milliseconds);
        }

        digitalDisplay.setText(timeString);
    }
    
    public StackPane getStackPane() {
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
    
}
