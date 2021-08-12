/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dard
 */
public class FolderScanner implements Runnable{

    public final String path = "C:/";
    public String workingPath = path;
    public int depth = 20;
    public static String[] omittedDirs = OmitDirs.folders;
    
    @Override
    public void run() {
        System.out.println("Folder Scanner Thread Running");
        ArrayList dirs = new ArrayList();
        ArrayList workingDirs = dirs;
        dirs.add(path);
        
        for(int i = 0; i < depth; i++){
            System.out.println("Iteration Depth: " + i);
            workingDirs = listFolders(workingDirs);
            dirs.addAll(workingDirs);
        }
        
        for(int x = 0; x < dirs.size(); x++){
            System.out.println(dirs.get(x));
        }
    }
    
    public ArrayList listFolders(ArrayList list){
        ArrayList dirs = new ArrayList();
        
        for(int x = 0; x < list.size(); x++){
            System.out.println(list.get(x));
        }
        
        for(int x = 0; x < list.size(); x++){
            File currentDir = new File(list.get(x).toString());
            File[] files = new File[]{};
            
            
            try {
                files = currentDir.listFiles();
                //System.out.println("CurrentDir: " + currentDir.toString());
                
                for(int i = 0; i < files.length; i++){

                    try{
                        File file = files[i]; 
                        if (file.isDirectory() && allowed(file)) {
                            dirs.add(file.getCanonicalPath()); 
                        } else {

                        }
                    } catch (IOException e){
                        System.out.println("Something broke on this file: " + files[i].toString());
                    }
                }
                
                for(File file : files){


                }
            } catch (Exception e){

            }
        }
        return dirs;
    } 
    
    public boolean allowed(File file){
        boolean allowed = true;
        
        for(int i = 0; i < omittedDirs.length; i++){
           
            if(file.toString().equals(omittedDirs[i])){
                allowed = false;
                System.out.println("Omitted Found: " + omittedDirs[i]);
            }
        }
        
        
        return allowed;
    }
}
