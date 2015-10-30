/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author flysy
 */
public class DataSourcesLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",new Date());
        try{
            TimeUnit.SECONDS.sleep(4);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }
    
}
