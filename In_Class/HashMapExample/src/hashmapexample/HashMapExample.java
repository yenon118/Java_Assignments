/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author WIN
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        HashMap hm = new HashMap();
        
        hm.put("name", "Mary Smith");
        hm.put("role", "Teacher");
        hm.put("age", "20");
        hm.put("Degree", "CS");
        
        System.out.println(hm);
        System.out.println(" ");
        
        
        for(Object key: hm.keySet()){
            System.out.println(key);
        }
        System.out.println(" ");
        
        for(Object value: hm.values()){
            System.out.println(value);
        }
        
        System.out.println("\nValue : " + hm.getOrDefault("Degree", "Teacher"));
        System.out.println("Value from specific key: " + hm.get("role"));
        System.out.println(" ");
        
        for(Object entry: hm.entrySet()){
            HashMap.Entry e = (HashMap.Entry) entry;
            
            Object key = e.getKey();
            Object value = e.getValue();
            
            System.out.println(key + " : " + value);
        }
        
        System.out.println(" ");
        
        
        Iterator it = hm.entrySet().iterator();
        
        while(it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it.next();
            
            System.out.println(pair.getKey() + " : " + pair.getValue());
            
            it.remove();
        }
        
        System.out.println("\n\nAfter removing from iterator");
        
        Iterator it2 = hm.entrySet().iterator();
        while(it2.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it2.next();
            
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
    
}
