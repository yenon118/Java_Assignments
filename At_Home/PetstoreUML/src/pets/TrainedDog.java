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
public interface TrainedDog {
    void sit();
    void standPretty();
    String speak();
    String bark(int numBarks);
    void playFetch();
    void goForASwim();
    void finishSwimming();
}