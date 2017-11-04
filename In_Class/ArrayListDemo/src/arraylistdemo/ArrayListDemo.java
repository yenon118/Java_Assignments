/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistdemo;

import java.util.ArrayList;

/**
 *
 * @author WIN
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> al = new ArrayList<>();
        
        al.add("Apple");
        al.add("Banana");
        al.add("Papaya");
        al.add("Durian");
        al.add("Mangosteen");
        al.add("Mango");
        
        System.out.println("Contents of al : " + al);
        
        al.add(1, "Apricot");
        System.out.println("\n\nContents of al : " + al);
        System.out.println("Size of al : " + al.size());
        
        System.out.println("\n\nIterate though the list and print items");
        for(String item:al){
            System.out.println(item);
        }
        
        al.remove("Banana");
        System.out.println("\n\nContents of al : " + al);
        
        al.remove(1);
        System.out.println("\n\nContents of al : " + al);
        
        String first = (String) al.get(0);
        System.out.println("\n\nContents of first : " + first);
        System.out.println("Class of al.get(0) : " + al.get(0).getClass());
        
        String second = (String) al.get(2);
        System.out.println("\n\nContents of second : " + second);
        System.out.println("Class of al.get(2) : " + al.get(2).getClass());
    }
    
}
