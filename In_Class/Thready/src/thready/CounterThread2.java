/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thready;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author Professor Wergeles
 * 
 * @references
 *      1)  https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 *      2)  http://www.programcreek.com/2009/02/notify-and-wait-example/
 */
public class CounterThread2 extends Thread {
    
    public Boolean stop = false;
    
    private Integer countTo = 0;
    private TextArea textArea;
    
    public CounterThread2(Integer countTo, TextArea textArea) {
        this.countTo = countTo;
        this.textArea = textArea;
    }
    
    @Override
    public void run() {
        for (int k = 0; k < countTo; k++) {
            String message = "k = " + k;
            Platform.runLater(() -> {
                textArea.appendText(message + "\n");
            });

            if (stop) {
                return;
            }
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(CounterThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
