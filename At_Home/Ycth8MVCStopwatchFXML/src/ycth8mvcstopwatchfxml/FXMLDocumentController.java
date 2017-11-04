/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8mvcstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author WIN
 */
public class FXMLDocumentController implements Initializable {
    
    private DigitalStopwatchModal digitalStopwatch;
    private AnalogStopwatchModal analogStopwatch;
    
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

    private void setupTimer(){
        digitalStopwatch = new DigitalStopwatchModal(digitalDisplay, timeStringButton);
        analogStopwatch = new AnalogStopwatchModal(hourHand, minuteHand, secondHand, nanosecondHand);
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
            
            digitalStopwatch.startTimeline();
            analogStopwatch.startTimeline();
            
            rightButton.setText("Stop");
            rightButton.setStyle("-fx-background-color: #E7CFB6;");
            leftButton.setText("Lap");
            leftButton.setStyle("-fx-background-color: #E7E7B6;");
        }
        else if(rightButton.getText().equals("Stop")){

            digitalStopwatch.pauseTimeline();
            analogStopwatch.pauseTimeline();
            
            leftButton.setText("Reset");
            leftButton.setStyle("-fx-background-color: #E7BAB6;");

            rightButton.setText("Start");
            rightButton.setStyle("-fx-background-color: #b6e7c9;");

        }
    }
    
    @FXML
    private void clickLeft(ActionEvent event) {
        if(leftButton.getText().equals("Lap")){
            if(digitalStopwatch.getSecondsElapsed() != 0 && analogStopwatch.getSecondsElapsed() != 0){

                if(timeStringButton.getText().equals("Hundredths Of A Second")){
                    System.out.println(digitalStopwatch.calculateLap(timeStringButton.getText()));
                }
                else if(timeStringButton.getText().equals("Milliseconds")){
                    System.out.println(digitalStopwatch.calculateLap(timeStringButton.getText()));
                }

            }
        }
        else if(leftButton.getText().equals("Reset")){
            
            digitalStopwatch.stopTimeline();
            analogStopwatch.stopTimeline();

            digitalStopwatch.resetTimer();
            analogStopwatch.resetTimer();

            leftButton.setText("Lap");
            leftButton.setStyle("-fx-background-color: #E7E7B6;");
            rightButton.setText("Start");
            rightButton.setStyle("-fx-background-color: #b6e7c9;");
        }
    }

    
}
