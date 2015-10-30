/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author flysy
 */
public class FileClock extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.printf("%s : %s\n", i, new Date());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.printf("The FileClock has been interrupted\n");
        }

    }

}
