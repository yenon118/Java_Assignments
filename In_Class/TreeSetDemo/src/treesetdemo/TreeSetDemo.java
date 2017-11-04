/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesetdemo;

import java.util.TreeSet;

/**
 *
 * @author WIN
 */
public class TreeSetDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TreeSet<String> ts = new TreeSet<>();
        
        ts.add("Orange");
        ts.add("Apple");
        ts.add("Mango");
        ts.add("Durian");
        ts.add("Papaya");
        ts.add("Lychee");
        
        System.out.println("Contents of ts" + ts);
        
        
        System.out.println("\n\nIterate the TreeSet: ");
        for(String item : ts){
            System.out.println(item);
        }
        
        
        
        
        
        
        
        
        
    }
    
}
