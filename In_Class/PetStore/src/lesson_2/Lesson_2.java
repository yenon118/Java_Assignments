/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_2;

import PetTypes.Dog;
import static lesson_2.Gender.*;

/**
 *
 * @author WIN
 */
public class Lesson_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // new keyword, creates an instance of class pet
        // A place in memory is made available to store states and behaviors
//        Pet pet = new Pet();
//        
//        pet.setName("Jackie");
//        pet.age = 3;
//        pet.gender = FEMALE;
//        
//        Pet pet2 = new Pet("cat", "Kitty", 1, FEMALE);
//        
//        System.out.println("Pet 1: " + pet.getName());
//        System.out.println("Pet 2: " + pet2.getName() + "\n\n");
        
        
        Dog dog = new Dog("Fido", 3, MALE);
        System.out.println(dog.getName() + " is " +dog.getAge() + " years old. ");
        
        dog.birthday();
        System.out.println(dog.getName() + " is " +dog.getAge() + " years old. ");
        
        Dog dog2 = new Dog("Halo", 2, FEMALE);
        System.out.println(dog2.getName() + " is " +dog2.getAge() + " years old. ");
        
        dog2.birthday();
        System.out.println(dog2.getName() + " is " +dog2.getAge() + " years old. \n\n");
        
        Cat cat = new Cat("Susan", 2, FEMALE);
        System.out.println(cat.getName() + " is " + cat.getAge() + "years old. \n\n");
        cat.meow();
        cat.meow(7);
        
        //implicit cast, because the compiler knows all cats are pets
        //  how does it know?
        //  because we had the extends keyword defined on the Cat class
        //  which tells the compiler the Pet class is a super class to cat
        Pet pet3 = cat;
        
        // This is the same as putting:
        //  Pet pet4 = new Cat("Susan", 7, FEMALE);
        
        //  This is explicit cast
        Cat cat2 = (Cat) pet3;
        
        //  Not all pets are cats
        
        System.out.println("\n\n");
        
        if(pet3 instanceof Cat){
            Cat cat3 = (Cat) pet3;
            cat3.meow();
            System.out.println("\n\n");
        }
        
        System.out.println("\n\n");
        cat.meow();
        System.out.println("Break");
        cat.meow(3);
                
        
        System.out.println("Testing : " + Dog.test);
        
        Dog dog3 = new Dog("Test", 21, MALE);
        System.out.println("Static test from dog : " + dog3.test);
        
        Dog.test = "Changed";
        System.out.println("Static test from dog : " + Dog.test);
        
        Dog dog4 = new Dog("Test2", 21, FEMALE);
        System.out.println("Static test from dog : " + dog4.test);
        
        // correct wayto reference static variable in a class
        System.out.println("test: " + Dog.test);
        
        Dog dog5 = new Dog("whatever", 100, MALE);
        
        System.out.println("Dog: " + dog5.getName() + "\nID: " + dog5.getId()+ "\nDog number: " 
                + Dog.getNumberOfDogCreated()+ "\nDog genus: " + Dog.getGENUS());
        
        
    }
    
}
