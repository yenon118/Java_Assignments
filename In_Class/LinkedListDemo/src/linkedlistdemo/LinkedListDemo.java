/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistdemo;

import java.util.LinkedList;

/**
 *
 * @author WIN
 */
public class LinkedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList<String> ll = new LinkedList<>();
        
        ll.add("Banana");
        ll.add("Cherry");
        ll.add("Strawberry");
        ll.add("Raspberry");
        ll.add(1, "Lemon");
        
        System.out.println("Contents of ll : " + ll);
        
        System.out.println("\n\nIterate through list and print items");
        for (String item : ll){
            System.out.println(item);
        }
        
        ll.remove("Cherry");
        System.out.println("\n\nContents of ll : " + ll);
        
        ll.remove(0);
        System.out.println("\n\nContents of ll : " + ll);
        
        ll.removeFirst();
        System.out.println("\n\nContents of ll : " + ll);
        
        ll.removeLast();
        System.out.println("\n\nContents of ll : " + ll);
        
        ll.add("Mangosteen");
        ll.add("Durian");
        ll.add("Blackberry");
        ll.add("Orange");
        System.out.println("\n\nContents of ll : " + ll);
        
        Object val = ll.get(0);
        ll.set(0, (String) val + " Changed");
        System.out.println("\n\nContents of ll : " + ll);
        
        System.out.println("ll Class : " + ll.get(0).getClass());
        
        
    }
    
}
