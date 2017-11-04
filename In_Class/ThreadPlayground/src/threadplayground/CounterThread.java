/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import javafx.scene.control.TextArea;

/**
 *
 * @author WIN
 */
public class CounterThread extends Thread{
    
    public Boolean stop = false;
    
    public Integer countTo = 0;
    
//    public TextArea textArea;

    public CounterThread(Integer countTo, TextArea textArea) {
        this.countTo = countTo;
//        this.textArea = textArea;
    }
    
    
    @Override
    public void run(){
        for(int i=0; i<countTo; i++){
            System.out.println("Counter Thread: " + i);
            
//            textArea.appendText("Counter Thread: " + i + '\n');
        }
        
        if(stop){
            return;
        }
    }
    
}
