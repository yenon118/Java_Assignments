/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author Professor Wergeles
 */
public class Dog extends Pet implements RegisteredPet, VaccinatedPet, TrainedDog {
    
    public static final String GENUS = "canis";
    private String typeOfDog; 
    private Boolean isHappy = false;
    private Boolean isSitting = false;
    private LocalDateTime whenRegistered;
    private String favoriteToy; 
    private int numberOfLegs;
    private boolean hasTail;
    private boolean canSwim;
    private boolean isSwimming;
    
    
    public Dog(Gender gender, String name, int age) {
        super("Dog", gender, name, age);
        favoriteToy = null; 
    }
    
    public String getTypeOfDog(){
        return typeOfDog; 
    }
    
    public void setTypeOfDog(String typeOfDog){
        this.typeOfDog = typeOfDog; 
    }
    
    public void petDog() {
        isHappy = true;
    }
    
    public void praiseDog() {
        isHappy = true;
    }
    
    public void yellAtDog() {
        isHappy = false;
    }
    
    public void kickDog(){
        isHappy = false; 
    }
    
    public void playWithToy(String favoriteToy){
        this.favoriteToy = favoriteToy; 
        isHappy = true; 
    }
    
    public Boolean getIsHappy() {
        return isHappy;
    }
    
    public String getIsHappyAsString() {
        if (isHappy) {
            return "happy";
        } else {
            return "sad";
        }
    } 
    
    public boolean getIsSwimming(){
        return this.isSwimming;
    }  
    
    @Override
    public String[] getNecessaryVacs() {
        
        String[] coreVaccines = {
            "Rabies 1-year",
            "Rabies 3-year",
            "Distemper",
            "Parvovirus",
            "Adenovirus"
        };
        
        return coreVaccines;
    }
    
    @Override
    public String[] getNonnecessaryVacs() {
        
        String[] nonCoreVaccines = {
            "Parainfluenza",
            "Bordetella bronchiseptica",
            "Lyme disease",
            "Leptospirosis",
            "Canine influenza"
        };
        
        return nonCoreVaccines;
    }

    @Override
    public Boolean isRegistered() {
        return whenRegistered != null;
    }

    @Override
    public void assignRegistration() {
        whenRegistered = LocalDateTime.now();
    }

    @Override
    public LocalDateTime whenRegistered() {
        return whenRegistered;
    }

    @Override
    public void sit() {
        isSitting = true;
    }
    
    @Override
    public void standPretty() {
        isSitting = false;
    }

    @Override
    public String speak() {
        return "Yawyahwer";
    }

    @Override
    public String bark(int numBarks) {
       String barks = "";
       for (int i = 0; i < numBarks; i++) {
           barks += "bark!";
       }
       
       return barks;
    }
    
    @Override
    public String toString() {
        String info = super.toString();
        
       String updatedInfo =  String.format("%s, isHappy: %s", info, isHappy);
       
       if (whenRegistered != null) {
           updatedInfo +=  ", whenRegistered: " + whenRegistered;
       }
       
       return updatedInfo;
    }
    
    @Override
    public int getNumberOfLegs() {
        return numberOfLegs; 
    }
    
    public void setNumberOfLegs(int numberOfLegs){
        this.numberOfLegs = numberOfLegs; 
    }

    @Override
    public boolean hasTail() {
        return hasTail; 
    }
    
    public void setHasTail(boolean hasTail){
        this.hasTail = hasTail;
    }

    @Override
    public boolean canFly() {
        return false; 
    }
    
    @Override
    public boolean canSwim() {
        return canSwim; 
    }
    
    public void setCanSwim(boolean canSwim){
        this.canSwim = canSwim; 
    }

    @Override
    public void playFetch() {
        this.isHappy = true;
    }

    @Override
    public void goForASwim() {
        this.isSwimming = true;
    }

    @Override
    public void finishSwimming() {
        this.isSwimming = false;
    } 
}