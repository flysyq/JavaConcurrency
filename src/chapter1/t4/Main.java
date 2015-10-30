/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t4;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author flysy
 */
public class Main {
    public static void main(String[] args) {
        String initPath = "C:/";
        String fileName = "idle";
        FileSearch searcher = new FileSearch(initPath,fileName);
        
        Thread thread = new Thread(searcher);
        thread.start();
        
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
 
}
