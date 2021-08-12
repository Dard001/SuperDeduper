/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dard
 */
public class UI extends JFrame{
    
    public JPanel checkboxPanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JPanel textPanel = new JPanel();
    
    
    public JCheckBox CBwindowsFolder = new JCheckBox("Windows Folder");
    public JCheckBox CBprogramFilesFolder = new JCheckBox("Program Files Folders");
    public JCheckBox CBhiddenFolders = new JCheckBox("Standard Hidden Folders");
    public JCheckBox CBrecycleBin = new JCheckBox("Recycle Bin");
    public JCheckBox CBusersFolder = new JCheckBox("Users Folder");
    
    public JButton startFolderScan = new JButton("Start Folder Scan");
    public JButton startFileScan = new JButton("Start File Scan");
    public JButton stopScans = new JButton("Stop All Scans");
    
    public UI(){
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SuperDeduper");
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon().getImage()); //materials.io
        this.setResizable(false);
        this.setLayout(new GridLayout(3,3));
                
        startFolderScan.setSize(100, 45);
        startFileScan.setSize(100, 45);
        stopScans.setSize(100, 45);
        
        checkboxPanel.add(CBwindowsFolder);
        checkboxPanel.add(CBprogramFilesFolder);
        checkboxPanel.add(CBhiddenFolders);
        checkboxPanel.add(CBrecycleBin);
        checkboxPanel.add(CBusersFolder); 
        buttonPanel.add(startFolderScan);
        buttonPanel.add(startFileScan);
        buttonPanel.add(stopScans);
        
        this.add(checkboxPanel);
        this.add(buttonPanel);
        this.add(textPanel);
        
        this.setVisible(true);
    }
}
