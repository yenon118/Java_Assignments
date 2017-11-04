/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetTypes;

import java.time.LocalDateTime;
import lesson_2.Gender;
import lesson_2.LicensedPet;
import lesson_2.Pet;

/**
 *
 * @author WIN
 */
public class Dog extends Pet implements LicensedPet{
    
    public static String test = "Testing...";
    
    private int id = 0;
    private static int numberOfDogCreated = 0;
    
    private static final String GENUS = "Canis";
    
    private String position = "Lying";
    
    public Dog(String name, int age, Gender gender){
        super("dog", name, age, gender);
        id = ++numberOfDogCreated;
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
    
    
    public void birthday(){
        age+=7;
    }

    public static String getGENUS() {
        return GENUS;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfDogCreated() {
        return numberOfDogCreated;
    }
    
    // method overloading 
    public void bark(int num){
        for(int i=0; i<num; i++){
            System.out.println("Bark!");
        }
    }
    
    public void bark(){
        bark(1);
    }

    // Not allowed; static method are not allowed to access instant variables
//    public static String getPosition() {
//        return position;
//    }
    
    public void stand(){
        position = "Stand";
    }
    
    public void sit(){
        position = "Sit";
    }

    public String getPosition() {
        return position;
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
