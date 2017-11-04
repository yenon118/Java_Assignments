/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author WIN
 */
public class MyStopwatch extends Application {
    
    public String title = "My Stopwatch";
//    public int width = 800;
//    public int height = 700;
//    double seconds=0;
    
    public double secondsElapsed = 0.0;
    public double tickTimeInSecond = 1;
    public double angleDeltaPerSecond = 6.0;
    
    Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        StackPane root = new StackPane();
        
//        ImageView testImageView = new ImageView();
//        root.getChildren().add(testImageView);
//        
//        Image testImage = new Image(getClass().getResourceAsStream("shakeIt.gif"));
//        testImageView.setImage(testImage);
        
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        root.getChildren().addAll(dialImageView, handImageView);
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox controlButtons = new HBox();
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        
        controlButtons.getChildren().addAll(stop, reset, start);
        root.getChildren().add(controlButtons);
        
        stop.setOnAction((ActionEvent event)->{
            //timeline.stop();
            timeline.pause();
        });
        
        start.setOnAction((ActionEvent event)->{
            timeline.play();
        });
        
        reset.setOnAction((ActionEvent event)->{
            timeline.stop();
            handImageView.setRotate(0);
            
            secondsElapsed = 0;
        });
        
        double width = dialImage.getWidth();
        double height = dialImage.getHeight();
        
        Scene scene = new Scene(root, width, height+150);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent actionEvent)->{
            //handImageView.setRotate((++seconds%60)*360/60);
            
            secondsElapsed += tickTimeInSecond;
            double rotation = secondsElapsed * angleDeltaPerSecond;
            handImageView.setRotate(rotation);
            
            //System.out.println("Timeline event!");
        }));
        
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
