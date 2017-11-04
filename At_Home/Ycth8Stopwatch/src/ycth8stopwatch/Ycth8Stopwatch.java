/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8stopwatch;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class Ycth8Stopwatch extends Application {
    
    public String title = "Ycth8Stopwatch";
    
    //double width = 400;
    //double height = 600;
    
    public Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        Stopwatch analogStopwatch = new Stopwatch();
        
        Scene scene = new Scene(analogStopwatch.getStackPane(), analogStopwatch.getWidth(), analogStopwatch.getHeight()+300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
