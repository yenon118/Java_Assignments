/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8mynewstopwatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class Ycth8MyNewStopWatch extends Application {
    
    public String title = "My New Stopwatch";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        AnalogStopwatch analogStopwatch = new AnalogStopwatch();
        
        Scene scene = new Scene(analogStopwatch.getRootContainer(), analogStopwatch.getWidth(), analogStopwatch.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //analogStopwatch.setTickTimeSeconds(1.0);
        
        analogStopwatch.start();
        
        analogStopwatch.setTickTimeSeconds(1.0/100);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
