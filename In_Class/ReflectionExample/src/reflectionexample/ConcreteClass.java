/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflectionexample;

/**
 *
 * @author Professor Wergeles
 */
public class ConcreteClass extends BaseClass implements BaseInterface {
    public int publicInt;
    private String privateString="private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int i){
        this.publicInt=i;
    }

    @Override
    public void method1() {
        System.out.println("Method1 impl.");
    }

    @Override
    public int method2(String str) {
        System.out.println("Method2 impl.");
        return 0;
    }

    @Override
    public int method4(){
        System.out.println("Method4 overriden.");
        return 0;
    }

    public int method5(int i){
        System.out.println("Method4 overriden.");
        return 0;
    }
}
