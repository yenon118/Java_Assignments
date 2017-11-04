/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcomparison;

/**
 *
 * @author Professor Wergeles
 */
public class StringComparison {

    /**
     * @notes 
     * 
     *      The point of this code is to prove that even two string object that have same values,
     *      could not be equivalent using "==" in some cases.
     * 
     */
    public static void main(String[] args) {
        

        String name = "Nick";
        String name2 = new String("Nick");
  
        System.out.println("name: \"" + name + "\"");
        System.out.println("name2: \"" + name2 + "\"");
        
        
        if (name == "Nick") System.out.println("They are equal!");
        else System.out.println("They are not equal!");   
        
        
        if (name2 == "Nick") System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
        
        if ("Nick".equals(name)) System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
        
        if (name2.equals("Nick") ) System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
        
        if (name == name2) System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
        
        if ("Nick" == "Nick") System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
        
        if(name.equals(name2)) System.out.println("They are equal!");
        else System.out.println("They are not equal!");
        
//        
//        if() System.out.println("They are equal!");
//        else System.out.println("They are not equal!");
//        
//        
//        if() System.out.println("They are equal!");
//        else System.out.println("They are not equal!");
//        
//        
//        if() System.out.println("They are equal!");
//        else System.out.println("They are not equal!");
//        
//        System.out.println("\nname.equals(name2):");
//        
//        if() System.out.println("They are equal!");
//        else System.out.println("They are not equal!");
        
    }
}

