/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossword;

/**
 *
 * @author WIN
 */
public class Crossword extends Puzzle implements Solvable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        Crossword cw = new Crossword(10, 20);
        
        Solvable x = new Crossword(10, 20);
//        cw = new Puzzle();
        p = cw;
        p = new Crossword(10, 20);
        
//        Integer i = 4.5;
//        Long i = 4.5;
        Object i = 4.5;
        
        
    }

    public Crossword(int number1, int number2) {
        System.out.print(number1 + " \t " + number2 + "\n");
    }

    @Override
    public void showSolution() {
        System.out.println("Implement interface methods");
    }
    
}
