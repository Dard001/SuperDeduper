/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement; 

/**
 *
 * @author Dard
 */
public class DatabaseConnector {
    //CREATE TABLE folders (id_ IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), parent VARCHAR(255), path VARCHAR(1024))
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/superdeduper";
    static final String USER = "sa"; 
    static final String PASS = "";
    
    public void initializeDB(){
        Connection conn = null; 
        Statement stmt = null;
        try { 
            // STEP 1: Register JDBC driver 
            Class.forName(JDBC_DRIVER); 

            //STEP 2: Open a connection 
            System.out.println("Connecting to database..."); 
            conn = DriverManager.getConnection(DB_URL,USER,PASS);  

            //STEP 3: Execute a query 
            System.out.println("Creating table in given database..."); 
            stmt = conn.createStatement(); 
            String sql =  "CREATE TABLE folders (id_ IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), parent VARCHAR(255), path VARCHAR(1024))";  
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database..."); 
            sql =  "CREATE TABLE files (id_ IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), parent VARCHAR(255), path VARCHAR(1024))";  
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database..."); 

            // STEP 4: Clean-up environment 
            stmt.close(); 
            conn.close(); 
        } catch(SQLException se) { 
            //Handle errors for JDBC 
            se.printStackTrace(); 
        } catch(Exception e) { 
            //Handle errors for Class.forName 
            e.printStackTrace(); 
        } finally { 
            //finally block used to close resources 
            try{ 
               if(stmt!=null) stmt.close(); 
            } catch(SQLException se2) { 
            } // nothing we can do 
            try { 
               if(conn!=null) conn.close(); 
            } catch(SQLException se){ 
               se.printStackTrace(); 
            } //end finally try 
        } //end try 
        System.out.println("Goodbye!");
    }
}
