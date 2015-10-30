/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t1;

/**
 *
 * @author flysy
 */
public class Main {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
