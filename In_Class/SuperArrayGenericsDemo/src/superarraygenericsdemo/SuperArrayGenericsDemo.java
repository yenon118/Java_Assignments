/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superarraygenericsdemo;

/**
 *
 * @author Professor Wergeles
 */
public class SuperArrayGenericsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        Integer[] integerArray = {5, 4, 3, 2, 1};
        
        Double[] doubleArray = {2.3, 4.5, 1.7, 8.9, 4.6, 7.3};
        
        SuperArray<Integer> sIntegerArray = new SuperArray<>(integerArray);
        System.out.println(sIntegerArray);
        sIntegerArray.displayArray();
        
        System.out.println(" ");
        SuperArray<Double> sDoubleArray = new SuperArray<>(doubleArray);
        System.out.println(sDoubleArray);
        sDoubleArray.displayArray();
        
        Character[] cArray = {'I', 'M', 'K', 'Q', 'Y'};
        String[] sArray = {"one", "two", "three"};
        
        System.out.println(" ");
        SuperArray<Character> sCharacterArray = new SuperArray<>(cArray);
        System.out.println(sCharacterArray);
        sCharacterArray.displayArray();
        
        System.out.println(" ");
        SuperArray<String> sStringArray = new SuperArray<>(sArray);
        System.out.println(sStringArray);
        sStringArray.displayArray();
        
        Thing[] thingArray = {
            new Thing("Tweety", "Bord"),
            new Thing("Roxys", "Downtown"),
            new Thing("Sams", "Club"),
            new Thing("Maggie", "Dog")
        };
        
        System.out.println(" ");
        SuperArray<Thing> sThingArray = new SuperArray<>(thingArray);
        sThingArray.displayArray();
        
        
    }
    
}
