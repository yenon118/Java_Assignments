/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thready;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 * 
 * @references
 *      1)  http://www.javamex.com/tutorials/synchronization_volatile.shtml
 *      2)  http://stackoverflow.com/questions/3535754/netbeans-java-new-hint-thread-sleep-called-in-loop
 */
public class UserInterfaceController implements Initializable {
    
    private Stage stage;

    @FXML
    private TextArea textArea1;
    
    @FXML
    private TextArea textArea2;
    
    @FXML
    private TextArea textArea3;
    
    @FXML
    private TextArea textArea4;
    
    private Thread thread1, thread2;
    private CounterThread2 thread3;
    private Thread thread4;
    
    private CounterRunnable counterRunnable;
    
    private Boolean exiting = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void ready(Stage stage) {
        this.stage = stage;
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Stage is closing.");
                
                exiting = true;
                
                if(thread1 != null){
//                    thread1.stop();
                }
            }
            
        });
    }
    
    @FXML
    private void handleStart1(ActionEvent event) {
        thread1 = new Thread(()->{
            for(int i = 0; i< 100000; i++){
                System.out.println("Thread 1: " + i);
                if(exiting){
                    return;
                }
            }
        });
        
        thread1.start();
    }
    
    @FXML
    private void handlePause1(ActionEvent event) {
        System.out.println("Pause button was pressed"); 
    }
    
    @FXML
    private void handleStop1(ActionEvent event) {
        System.out.println("Stop button was pressed"); 
    }
    
    @FXML
    private void handleStart2(ActionEvent event) {
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j = 0; j< 100000; j++){
                    System.out.println("Thread 2: " + j);
                    String message = "Thread 2: " + j;
                    
                    Platform.runLater(()->{
                        textArea2.appendText( message + "\n");
                    });
                    
                    if(exiting){
                        return;
                    }
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }); 
        
        thread2.start();
    }
    
    @FXML
    private void handlePause2(ActionEvent event) {
        System.out.println("Pause button was pressed");
    }
    
    @FXML
    private void handleStop2(ActionEvent event) {
        System.out.println("Stop button was pressed"); 
    }
    
    @FXML
    private void handleStart3(ActionEvent event) {
         if(thread3 != null){
             return;
         }
         
         thread3 = new CounterThread2(1000000, textArea3);
         thread3.start();
    }
    
    @FXML
    private void handlePause3(ActionEvent event) {
        System.out.println("Pause button was pressed");
    }
    
    @FXML
    private void handleStop3(ActionEvent event) {
        if(thread3 != null){
            thread3.stop = true;
            thread3 = null;
            
        }
    }
    
    @FXML
    private void handleStart4(ActionEvent event) {
        if(thread4 != null){
             return;
         }
        counterRunnable = new CounterRunnable(100000, textArea4);
        thread4 = new Thread(counterRunnable);
        thread4.start();
    }
    
    @FXML
    private void handlePause4(ActionEvent event) {
        System.out.println("Pause button was pressed"); 
    }
    
    @FXML
    private void handleStop4(ActionEvent event) {
        System.out.println("Stop button was pressed"); 
        
        if(counterRunnable == null){
             return;
        }
        
        counterRunnable.stop = true;
        thread4 = null;
        counterRunnable = null;
        
        
    }   
    
}
