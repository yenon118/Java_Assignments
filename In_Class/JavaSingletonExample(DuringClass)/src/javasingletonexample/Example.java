/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasingletonexample;

/**
 *
 * @author Professor Wergeles
 */
public class Example {
    
    public SingleThing s3;
    
    public Example(){
        s3 = SingleThing.getInstance();
    }
}