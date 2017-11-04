/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay3;

/**
 *
 * @author Professor Wergeles
 */
public class IntegerPlay3 {

    /**
     * @notes 
     * 
     *      We have objects, both at the end of the range, both if statements will executes. Why?
     * 
     *      Since we increment -128 into the range (-128 to 127) then the "==" will work.
     *      This happens Object Interning.
     * 
     *      However, it is always not recommended to use "==" to compare object.
     */
    public static void main(String[] args) {
        
        Integer x = -129;
        
        Integer y = -130;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        
        y = y + 1;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        
        if (x == y) {
            System.out.println("They are the same object"); 
        } else {
            System.out.println("They are different objects"); 
        }
        
        
        if (x.equals(y)) {
            System.out.println("They are the same value"); 
        } else {
            System.out.println("They are the different values");
        }
    }
    
}
