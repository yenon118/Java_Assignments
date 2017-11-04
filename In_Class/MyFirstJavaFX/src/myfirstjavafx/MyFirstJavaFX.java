/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjavafx;

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


// This main class for JavaFX application extends the
// javafx.application.Application class
public class MyFirstJavaFX extends Application {
    
    // The start method is the man entry point for all JavaFX applications
    @Override
    public void start(Stage primaryStage) {
        /*
            A JavaFX app defines the user interface container by means of 
                a stage and a scene
        
            The JavaFX stage class is the top-level JavaFX container
        
            The JavaFX scene class is the container for all content
        
        */
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        /*
            In JavaFX, the content of the scene is represented as a hierarchial
                scene graph of nodes.
        
            In this example, the root node is a StackPane object, which is a 
                resizable layout node.
        
            This means that the root node's size tracks the scene's size and 
                changes when the stage s resized by the user.
        
        */
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        //The root node contains a child node, a button control the text,
        //  plus an event handler to print a message when the button is pressed
        
        
        Scene scene = new Scene(root, 300, 250);
        
        // Create a scene for a specific root node with a specific size
        
        primaryStage.setTitle("Hello World!");
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
