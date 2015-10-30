/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.t4;

import java.io.File;

/**
 *
 * @author flysy
 */
public class FileSearch implements Runnable{

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }    
    
    @Override
    public void run() {
       File file = new File(initPath);
       
       if(file.isDirectory()){
           try{
               directoryProcess(file);
           }catch(InterruptedException e){
               System.out.printf("%s: The search has been interrupted\n", Thread.currentThread().getName());
           }
       }
    }

    private void directoryProcess(File file) throws InterruptedException{
        File list[] = file.listFiles();
        if(list != null){
            for(int i=0;i<list.length;i++){
                if(list[i].isDirectory()){
                    directoryProcess(list[i]);
                }else{
                    fileProcess(list[i]);
                }
            }
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().contains(fileName)){
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
    
}
