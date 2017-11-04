/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycth8helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author WIN
 */
public class Ycth8HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        invokeMe();
        System.out.println("Hello World!");
    }
    
    public static void invokeMe(){
        String myPawPrint = "Ycth8";
        
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        
        System.out.println("My PawPrint is \"" + myPawPrint + "\"");
        System.out.println("Today's date is " + currentDate.format(dateFormatter));
    }
    
    
    
}
