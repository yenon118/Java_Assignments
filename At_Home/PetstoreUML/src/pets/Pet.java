/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

/**
 *
 * @author Professor Wergeles
 */
public abstract class Pet {
    
    private static int count = 0;
    private String name;
    private int age;
    private String type;
    private Gender gender;
    
    public Pet() {
        count++;
    }
    
    public Pet(String type, Gender gender, String name, int age) {
        this();
        this.type = type;
        this.gender = gender;
        this.name = name;
        this.age = age;
    }
    
    public static int getCounts() {
        return count;
    }
    
    public abstract int getNumberOfLegs(); 
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public Gender getGender(){
        return gender;
    }
    
    public void setGender(Gender gender){
        this.gender = gender;
    } 
    
    public int birthday() {
        age++;
        return age;
    }
    
    public abstract boolean hasTail(); 
    
    public abstract boolean canFly(); 
    
    public abstract boolean canSwim(); 
    
    @Override
    public String toString() {
        return String.format("Type: %s, Name: %s, Age: %d, Gender: " + gender, type, name, age); 
    }   
}