/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_2;

import java.time.LocalDateTime;

/**
 *
 * @author WIN
 */
public class Cat extends Pet implements LicensedPet{
    
    public Cat(String name, int age, Gender gender){
        super("Cat", name, age, gender);
    }
    
    @Override
    public String[] getCoreVaccines(){
        String[] vaccinesString= {
            "Some vaccines",
            "Some core vaccines"
        };
        
        return vaccinesString;
    }
    
    @Override
    public String[] getNonCoreVaccines(){
        String[] vaccinesString= {
            "Some vaccines",
            "Some non core vaccines"
        };
        
        return vaccinesString;
    }
    
    
    public void meow(int num){
        for(int i=0; i<num; i++){
            System.out.println("meow.");
        }
    }
    
    public void meow(){
        meow(1);
    }
    
    public String meow(String noise){
        return noise;
    }
    
    // override a function in super class
    @Override
    public int getAge(){
        return age*7;
    }
    
    @Override
    public void assignedLicense(){
        System.out.println("License Number");
    }
    @Override
    public Boolean isLicensed(){
        return true;
    }
    
    @Override
    public LocalDateTime whenLicensed(){
        return LocalDateTime.now();
    }
}
