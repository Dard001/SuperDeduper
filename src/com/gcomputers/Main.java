/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers;

/**
 *
 * @author Dard
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new UI();
        
        Thread foScanT = new Thread(new FolderScanner());
        Thread fiScanT = new Thread(new FileScanner());
        Thread bT = new Thread(new Buffers());
        
        UI ui = new UI();
        FolderScanner folderScanner = new FolderScanner();
        FileScanner fileScanner = new FileScanner();
        Buffers buffers = new Buffers();
        
        foScanT.start();
        fiScanT.start();
        bT.start();
        
        //DatabaseConnector dbconn = new DatabaseConnector();
        //dbconn.initializeDB();
        

    }
    
}
