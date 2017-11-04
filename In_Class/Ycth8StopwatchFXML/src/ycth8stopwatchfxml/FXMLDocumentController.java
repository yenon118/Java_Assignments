/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8stopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class FXMLDocumentController implements Initializable {
    
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
    
    @FXML
    private Label digitalDisplay;
    @FXML
    private ImageView secondHand;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private ImageView hourHand;
    @FXML
    private ImageView minuteHand;
    @FXML
    private ImageView nanosecondHand;
    @FXML
    private Button timeStringButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setupTimer();
    }    

    @FXML
    private void timeStringButton(ActionEvent event) {
        if(timeStringButton.getText().equals("Hundredths Of A Second")){
            timeStringButton.setText("Milliseconds");
        }
        else if(timeStringButton.getText().equals("Milliseconds")){
            timeStringButton.setText("Hundredths Of A Second");
        }
    }
    
    @FXML
    private void clickRight(ActionEvent event) {
        if(rightButton.getText().equals("Start")){
            timeline.play();
            rightButton.setText("Stop");
            rightButton.setStyle("-fx-background-color: #E7CFB6;");
            leftButton.setText("Lap");
            leftButton.setStyle("-fx-background-color: #E7E7B6;");
        }
        else if(rightButton.getText().equals("Stop")){
            //timeline.stop();
            timeline.pause();
            leftButton.setText("Reset");
            leftButton.setStyle("-fx-background-color: #E7BAB6;");

            rightButton.setText("Start");
            rightButton.setStyle("-fx-background-color: #b6e7c9;");

        }
    }
    
    @FXML
    private void clickLeft(ActionEvent event) {
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

            secondHand.setRotate(0);
            minuteHand.setRotate(0);
            hourHand.setRotate(0);
            nanosecondHand.setRotate(0);

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
            leftButton.setStyle("-fx-background-color: #E7E7B6;");
            rightButton.setText("Start");
            rightButton.setStyle("-fx-background-color: #b6e7c9;");
        }
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
        secondHand.setRotate(rotation);

        hundredthsOfASecondsElapsed += tickTimeHundredthsOfASeconds;
        rotation = hundredthsOfASecondsElapsed * analogDeltaPerHundredthsOfASeconds;
        nanosecondHand.setRotate(rotation);

        hundredthsOfASeconds = (int) hundredthsOfASecondsElapsed % 100;
        milliseconds = (int) (secondsElapsed * 1000) % 1000;
        seconds = (int) secondsElapsed % 60;
        minutes = (int) (secondsElapsed / 60) % 60;
        hours = (int) secondsElapsed / 3600;

        rotation = minutes * analogDeltaPerSeconds;
        minuteHand.setRotate(rotation);

        rotation = hours * analogDeltaPerSeconds;
        hourHand.setRotate(rotation);
        
        if(timeStringButton.getText().equals("Hundredths Of A Second")){
            timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%02d", hundredthsOfASeconds);
        }
        else if(timeStringButton.getText().equals("Milliseconds")){
            timeString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%03d", milliseconds);
        }

        digitalDisplay.setText(timeString);
    }


    
}
