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
public class Cat extends Pet implements RegisteredPet, VaccinatedPet {
     
    public final static String GENUS = "Felis";
    private String typeOfCat; 
    private int numberOfLegs; 
    private boolean hasTail; 
    private LocalDateTime whenRegistered;
    private Boolean isHappy = false;
    private Boolean isPurring = false;
    private String catToy; 
    private Boolean declawed;
    private Boolean hungry = false;
    
    public Cat(Gender gender, String name, int age) {
        super("Cat", gender, name, age);
        catToy = null; 
        declawed = false; 
    }
    
    public Boolean getHungry() {
        return hungry;
    }

    public Boolean getDeclawed() {
        return declawed;
    }
    
    public String getTypeOfCat(){
        return typeOfCat; 
    }
    
    public void setTypeOfCat(String typeOfCat){
        this.typeOfCat = typeOfCat; 
    }
    
    @Override
    public String[] getNecessaryVacs() {    
        
        String[] coreVaccines = {
            "Rabies",
            "Feline Distemper",
            "Feline Herpesvirus",
            "Calicivirus"
        };
        
        return coreVaccines;   
    }

    @Override
    public String[] getNonnecessaryVacs() {
        
        String[] nonCoreVaccines = {
            "Feline Leukemia Virus",
            "Bordetella"
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
    public String toString() {
       String info = super.toString();
       
       if (whenRegistered != null) {
           info +=  ", whenRegistered: " + whenRegistered;
       }
       
       return info;
    }
    
    public void petCat() {
        isHappy = true;
    }
    
    public void praiseCat() {
        isHappy = true;
    }
    
    public void yellAtCat() {
        isHappy = false;
    }
    
    public void kickCat(){
        isHappy = false; 
    }
    
    public void playWithCat(String catToy){
        this.catToy = catToy; 
        isHappy = true; 
    }

    public String getCatToy() {
        return catToy;
    }
    
    public Boolean getIsHappy() {
        return isHappy;
    } 
    
    public void declawCat(Boolean declawed){
        this.declawed = declawed; 
        isHappy = false; 
    }
    
    public String meow(int numMeows){
        String meows = ""; 
        for(int i = 0; i < numMeows; i++){
            meows += "meow!\n"; 
        }
        return meows; 
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
        return false; 
    } 
}