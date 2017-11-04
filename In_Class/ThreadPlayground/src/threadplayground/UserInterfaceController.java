/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 * 
 * @references
 *      1)  http://www.javamex.com/tutorials/synchronization_volatile.shtml
 *      2)  http://stackoverflow.com/questions/3535754/netbeans-java-new-hint-thread-sleep-called-in-loop
 * 
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
    
    private Boolean exiting = false;
    
    private CounterThread thread1;
    private CounterThread2 thread2;
    private Thread thread3;
    private Thread thread4;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void ready(Stage stage) {
        this.stage = stage;

    }
    
    @FXML
    private void handleStart1(ActionEvent event) {
        System.out.println("Start button was pressed"); 
        
        thread1 = new CounterThread(1000, textArea1);
        
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
        thread2 = new CounterThread2(1000, textArea2);
        
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
         System.out.println("Start button was pressed"); 
         
         thread3 =  new Thread(()->{
            for(int i=0; i<1000; i++){
                
                System.out.println("Counter Thread 3: " + i);
            }
         });
         
         thread3.start();
    }
    
    @FXML
    private void handlePause3(ActionEvent event) {
        System.out.println("Pause button was pressed");
    }
    
    @FXML
    private void handleStop3(ActionEvent event) {
        System.out.println("Stop button was pressed"); 
    }
    
    @FXML
    private void handleStart4(ActionEvent event) {
        System.out.println("Start button was pressed"); 
        
        thread4 = new Thread(new Runnable() {
            
            
            @Override
            public void run() {
                for(int i=0; i<1000; i++){

                    System.out.println("Counter Thread 4: " + i);
                }
            }
        
        
        });
        
        
        thread4.start();
    }
    
    @FXML
    private void handlePause4(ActionEvent event) {
        System.out.println("Pause button was pressed"); 
    }
    
    @FXML
    private void handleStop4(ActionEvent event) {
        System.out.println("Stop button was pressed"); 
    }
}
