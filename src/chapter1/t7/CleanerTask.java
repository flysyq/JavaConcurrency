/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t7;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author flysy
 */
public class CleanerTask extends Thread {

    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
                    
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        System.out.println("deque.size()="+deque.size());
        if (deque.size() == 0) {
            return;
        }
        delete = false;

        Event e = deque.getLast();
        difference = date.getTime() - e.getDate().getTime();
        System.out.println("difference=" + difference);
        if (difference > 10000) {
            System.out.printf("Cleaner: %s\n", e.getEvent());
            deque.removeLast();
            delete = true;
        }

        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }

    }

}
