/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8mvcstopwatchfxml;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class DigitalStopwatchModal {

    
    private final double tickTimeSeconds = 0.01;
    private final double tickTimeHundredthsOfASeconds = 1;
    private double secondsElapsed;
    private double hundredthsOfASecondsElapsed;
    
    private int hundredthsOfASeconds;
    private int milliseconds;
    private int seconds;
    private int minutes;
    private int hours;
    private String hundredthsOfASecondsString;
    private String millisecondsString;
    
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
    
    private String lapString;
    private int lapCount;
    
    private final Label digitalDisplay;
    private final Button timeStringButton;
    
    private final KeyFrame keyFrame;
    private final Timeline timeline;

    public DigitalStopwatchModal(Label digitalDisplay, Button timeStringButton) {
        this.digitalDisplay = digitalDisplay;
        this.timeStringButton = timeStringButton;
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeSeconds*1000), (ActionEvent)->{
            updateTimer();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    
    public void updateTimer(){
        secondsElapsed += tickTimeSeconds;

        hundredthsOfASecondsElapsed += tickTimeHundredthsOfASeconds;

        hundredthsOfASeconds = (int) hundredthsOfASecondsElapsed % 100;
        milliseconds = (int) (secondsElapsed * 1000) % 1000;
        seconds = (int) secondsElapsed % 60;
        minutes = (int) (secondsElapsed / 60) % 60;
        hours = (int) secondsElapsed / 3600;
        
        if(timeStringButton.getText().equals("Hundredths Of A Second")){
            hundredthsOfASecondsString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%02d", hundredthsOfASeconds);
            digitalDisplay.setText(hundredthsOfASecondsString);
        }
        else if(timeStringButton.getText().equals("Milliseconds")){
            millisecondsString = String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds) + " . " + String.format("%03d", milliseconds);
            digitalDisplay.setText(millisecondsString);
        }
    }
    
    public void resetTimer(){
        secondsElapsed = 0;
        hundredthsOfASecondsElapsed = 0;
        
        hundredthsOfASeconds = 0;
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        
        previousHundredthsOfASeconds = 0;
        previousMilliseconds = 0;
        previousSeconds = 0;
        previousMinutes = 0;
        previousHours = 0;

        currentHundredthsOfASeconds = 0;
        currentMilliseconds = 0;
        currentSeconds = 0;
        currentMinutes = 0;
        currentHours = 0;

        tempHundredthsOfASeconds = 0;
        tempMilliseconds = 0;
        tempSeconds = 0;
        tempMinutes = 0;
        tempHours = 0;
        
        lapCount = 0;
        
        if(timeStringButton.getText().equals("Hundredths Of A Second")){
            digitalDisplay.setText("00 : 00 : 00 . 00");
        }
        else if(timeStringButton.getText().equals("Milliseconds")){
            digitalDisplay.setText("00 : 00 : 00 . 000");
        }
        
        hundredthsOfASecondsString = "";
        millisecondsString = "";
    }
    
    public String calculateLap(String string){
        ++lapCount;

        tempHundredthsOfASeconds = hundredthsOfASeconds;
        tempMilliseconds = milliseconds;
        tempSeconds = seconds;
        tempMinutes = minutes;
        tempHours = hours;

        currentHundredthsOfASeconds = tempHundredthsOfASeconds;
        currentMilliseconds = tempMilliseconds;
        currentSeconds = tempSeconds;
        currentMinutes = tempMinutes;
        currentHours = tempHours;

        if(string.equals("Hundredths Of A Second")){
            if(tempHundredthsOfASeconds < previousHundredthsOfASeconds){
                tempSeconds = tempSeconds - 1;
                tempHundredthsOfASeconds = tempHundredthsOfASeconds + 100;
                tempHundredthsOfASeconds = tempHundredthsOfASeconds - previousHundredthsOfASeconds;
            }
            else{
                tempHundredthsOfASeconds = tempHundredthsOfASeconds - previousHundredthsOfASeconds;
            }
        }
        else if(string.equals("Milliseconds")){
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

        if(string.equals("Hundredths Of A Second")){
            lapString = "Lap " + Integer.toString(lapCount) + " -> " + String.format("%02d", tempHours) + " : " + String.format("%02d", tempMinutes) + " : " + String.format("%02d", tempSeconds) + " . " + String.format("%02d", tempHundredthsOfASeconds);
        }
        else if(string.equals("Milliseconds")){
            lapString = "Lap " + Integer.toString(lapCount) + " -> " + String.format("%02d", tempHours) + " : " + String.format("%02d", tempMinutes) + " : " + String.format("%02d", tempSeconds) + " . " + String.format("%03d", tempMilliseconds);
        }

        previousHundredthsOfASeconds = currentHundredthsOfASeconds;
        previousMilliseconds = currentMilliseconds;
        previousSeconds = currentSeconds;
        previousMinutes = currentMinutes;
        previousHours = currentHours;
        
        return lapString;
    }
    
    public void startTimeline(){
        timeline.play();
    }
    
    public void pauseTimeline(){
        timeline.pause();
    }
    
    public void stopTimeline(){
        timeline.stop();
    }

    public double getSecondsElapsed() {
        return secondsElapsed;
    }
    
}
