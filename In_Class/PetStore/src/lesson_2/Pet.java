/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_2;

/**
 *
 * @author WIN
 */
public abstract class Pet {
    
    public String type;
    private String name;
    public int age;
    
    // capital "G", that references an object
    public Gender gender;
    
    public abstract String[] getCoreVaccines(); 
    public abstract String[] getNonCoreVaccines(); 
    
    // default constructor. It is used to create an instance of a class
    public Pet(){
        
    }
    
    public Pet(String type, String name){
        this();
        this.type = type;
        this.name = name;
    }
    
    public Pet(String type, String name, int age, Gender gender){
        this(type, name);
        this.age = age;
        this.gender = gender;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void birthday(){
        age++;
    }
    
    public int getAge(){
        return age;
    }
    
    
    
    
    
}
