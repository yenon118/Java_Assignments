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
public class Bird extends Pet {
    
    private String genusOfBird;
    private String typeOfBird; 
    private Integer numberOfLegs;
    private boolean hasTail;
    private boolean canFly;
    private String colorOfBird;
    
    public Bird(Gender gender, String name, int age){
        super("Bird", gender, name, age); 
    }
    
    public String getGenusOfBird(){
        return genusOfBird; 
    }
    
    public void setGenusOfBird(String genusOfBird){
        this.genusOfBird = genusOfBird; 
    }
    
    public String getTypeOfBird(){
        return typeOfBird; 
    }
    
    public void setTypeOfBird(String typeOfBird){
        this.typeOfBird = typeOfBird; 
    }
    
    @Override
    public int getNumberOfLegs() {
        return numberOfLegs; 
    }
    
    public void setNumberOfLegs(int numberOfLegs){
        this.numberOfLegs = numberOfLegs; 
    }
    
    public String getColorOfBird() {
        return this.colorOfBird;
    }
    
    public void setColorOfBird(String colorOfBird) {
        this.colorOfBird = colorOfBird;
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
        return canFly; 
    }
    
    public void setCanFly(boolean canFly){
        this.canFly = canFly; 
    }

    @Override
    public boolean canSwim() {
        return false; 
    } 
     
    @Override
    public String toString() {
       String info = super.toString();
        
       String updatedInfo =  String.format("%s, Type: %s, Genus: %s", info, typeOfBird, genusOfBird);
       
       return updatedInfo;
    }
}