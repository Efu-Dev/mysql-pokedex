package com.mycompany.pokedex.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
   private final String base = "Pokedex";
   private final String user = "root";
   private final String password = "12345asd";
   private final String url = "jdbc:mysql://localhost:3306/";
   private Connection con = null;
   
   public Connection makeConnection()
   {
       try {
           con = DriverManager.getConnection(url+base, user, password);
           System.out.println(con.toString());
       } catch (SQLException ex) {
           //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println(ex.getMessage());
       } 
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return con;
   }
}
