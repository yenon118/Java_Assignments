/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationexamples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import taskers.*;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 * 
 * 2147483647, 1000000
 */
public class NotificationsUIController implements Initializable, Notifiable {

    @FXML
    private TextArea textArea;
    
    private Task1 task1;
    private Task2 task2;
    private Task3 task3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

            @Override
            public void handle(WindowEvent event) {
                if(task1 != null) task1.end();
                if(task2 != null) task2.end();
                if(task3 != null) task3.end();
            }
            
        });
    }
    
    @FXML
    public void startTask1(ActionEvent event) {
        System.out.println("start task 1");
        
        if(task1 == null){
            task1 = new Task1(2147483647, 1000000);
            task1.setNotificationTarget(this);
            task1.start();
            
        }
        
    }
        
    @FXML
    public void startTask2(ActionEvent event) {
        System.out.println("start task 2");
        
        if(task2 == null){
            task2 = new Task2(2147483647, 1000000);
            task2.setOnNotification(new Notification(){
                @Override
                public void handle(String message){
                    textArea.appendText(message + "\n");
                }
            });
        task2.start();
        }
        
    }
    
    @FXML
    public void startTask3(ActionEvent event) {
        System.out.println("start task 3");
        
        if(task3 == null){
            task3 = new Task3(2147483647, 1000000);
            task3.addPropertyChangeListener(new PropertyChangeListener(){
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    textArea.appendText((String)e.getNewValue() + "\n");
                }
                
            });
            task3.start();
        }
        
    } 

    @Override
    public void notify(String message) {
        textArea.appendText(message + "\n");
    }
}