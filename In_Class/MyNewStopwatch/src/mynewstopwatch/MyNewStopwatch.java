/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

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
public class MyNewStopwatch extends Application {
    
    public String title = "My New Stopwatch";
    
    //double width = 300;
    //double height = 450;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        AnalogStopWatch analogStopwatch = new AnalogStopWatch();
        
        Scene scene = new Scene(analogStopwatch.getRootContainer(), analogStopwatch.getWidth(), analogStopwatch.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //analogStopwatch.setTickTimeSeconds(1.0);
        
        analogStopwatch.start();
        
        //analogStopwatch.setTickTimeSeconds(1.0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
