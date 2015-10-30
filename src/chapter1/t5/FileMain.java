/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t5;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author flysy
 */
public class FileMain {
    public static void main(String[] args) {
        
        Thread thread = new FileClock();
        thread.start();
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
