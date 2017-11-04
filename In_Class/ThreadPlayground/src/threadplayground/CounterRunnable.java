/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author WIN
 */
public class CounterRunnable implements Runnable{

    public Boolean stop = false;
    
    public Integer countTo = 0;
    
    public TextArea textArea;
    
    public CounterRunnable(Integer countTo, TextArea textArea) {
        this.countTo = countTo;
        this.textArea = textArea;
    }
    
    
    @Override
    public void run() {
        for(int i=0; i<countTo; i++){
            String message = "i = " + i;
            
            Platform.runLater(()->{
                textArea.appendText(message + "\n");
            });
            
        }
        
        if(stop){
            return;
        }
        
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ex){
            Logger.getLogger(CounterThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
