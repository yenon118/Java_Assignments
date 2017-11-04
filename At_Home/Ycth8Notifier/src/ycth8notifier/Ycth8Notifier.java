/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8notifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author WIN
 */
public class Ycth8Notifier extends Application {
    
    public String title = "Notifier";
    
    public int width = 420;
    public int height = 250;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        VBox vbox = new VBox();
        TextField textField = new TextField();
        Button notify = new Button("Notify");
        Button clear = new Button("Clear");
        Button print = new Button("Print");
        Button alert = new Button("Alert");
        
        notify.setOnAction((ActionEvent event)->{
            
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
            
            invokeMe();
            textField.setText("You have been notified by Ycth8 on " + currentDate.format(dateFormatter));
        });
        
        clear.setOnAction((ActionEvent event)->{
            textField.clear();
        });
        
        print.setOnAction((ActionEvent event)->{
            String displayString = textField.getText();
            System.out.println(displayString);
        });
        
        alert.setOnAction((ActionEvent event)->{
            Alert alertBox = new Alert(AlertType.INFORMATION);
            alertBox.setTitle("Alert");
            alertBox.setHeaderText(null);
            alertBox.setContentText(textField.getText());
            alertBox.showAndWait();
        });
        
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        
        root.add(textField, 0, 0);
        textField.setPrefWidth(350);
        
        vbox.getChildren().addAll(notify, clear, print, alert);
        root.add(vbox, 0, 1);
        
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 0, 10, 0));
        
        notify.setMaxWidth(Double.MAX_VALUE);
        clear.setMaxWidth(Double.MAX_VALUE);
        print.setMaxWidth(Double.MAX_VALUE);
        alert.setMaxWidth(Double.MAX_VALUE);
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void invokeMe(){
        String myPawPrint = "Ycth8";
        
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        
        System.out.println("My PawPrint is \"" + myPawPrint + "\"");
        System.out.println("Today's date is " + currentDate.format(dateFormatter));
    }
    
}
