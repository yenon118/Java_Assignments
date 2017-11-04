/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

import pets.Bird;
import pets.Cat;
import pets.Dog;
import pets.Gender;
import pets.Pet;
import pets.Snake;

/**
 *
 * @author Professor Wergeles
 */
public class PetstoreUML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog(Gender.FEMALE, "Maggie", 5);
        dog.assignRegistration();
        String bark = dog.bark(3);
        dog.playWithToy("Frisbee");
        dog.goForASwim();
        System.out.println("Is my dog swimming? -> " + dog.getIsSwimming());
        dog.finishSwimming();
        System.out.println(bark);
        System.out.println(dog);
        System.out.println("Is my dog happy? -> " + dog.getIsHappy()); 
        
        Cat cat = new Cat(Gender.FEMALE, "Whiskey", 2);
        cat.assignRegistration();
        cat.playWithCat("Ball");
        System.out.println(cat);
        System.out.println("Is my cat happy? -> " + cat.getIsHappy()); 
        cat.declawCat(Boolean.TRUE);
        System.out.println("Is my cat still happy? -> " +cat.getIsHappy()); 
        
        System.out.println(Pet.getCounts());
        
        
        Snake snake = new Snake(Gender.MALE, "Mike", 1, "Pythonidae", false); 
        snake.birthday(); 
        snake.setGenus("Python");
        System.out.println(snake.toString()); 
        
        System.out.println(Pet.getCounts());
        
        Bird bird = new Bird(Gender.FEMALE, "Bong", 2); 
        bird.setTypeOfBird("Blue Jay");
        bird.setGenusOfBird("Cyanocitta");
        System.out.println(bird.toString());
        
        System.out.println(Pet.getCounts());
        
    }
}