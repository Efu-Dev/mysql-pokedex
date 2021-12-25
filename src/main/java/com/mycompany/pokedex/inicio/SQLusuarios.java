package com.mycompany.pokedex.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLusuarios extends Conexion {
    
    public static boolean registrar(Connection con, String genero, String nombreEntrenador, String nombreUsuario, String password)
    {
        String sqlEntrenador = "INSERT INTO entrenador (nombreEntrenador,genero) VALUES(?,?)";
        if(genero.equals("Hombre"))
            genero = "0";
        else
            genero = "1";
        
        String sqlUsuario = "INSERT INTO usuario(nombre,contrasena) VALUES(?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sqlEntrenador);
            ps.setString(1, nombreEntrenador);
            ps.setString(2, genero);
            ps.execute();
            System.out.println("Entrenador registrado!!!");
            
            PreparedStatement ps2 = con.prepareStatement(sqlUsuario);
            ps2.setString(1, nombreUsuario);
            ps2.setString(2, password);
            ps2.execute();
            System.out.println("Usuario registrado!!!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
        public static int login(String usuario, String password) {
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
                
            String sql = "SELECT contrasena FROM usuario WHERE nombre = ?";
            try{
                ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                rs = ps.executeQuery();
                    
                if (rs.next() && password.equals(rs.getString("contrasena"))){
                    Integer id;
                    PreparedStatement ps2 = con.prepareStatement("SELECT Entrenador_idEntrenador FROM usuario WHERE nombre = ?");
                    ps2.setString(1, usuario);
                    rs = ps2.executeQuery();
                    rs.next();
                    id = Integer.parseInt(rs.getString("Entrenador_idEntrenador"));
                    return id;  
                }
                return -1;
           
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                return -1;
            }   
        }
        
        public static String[] getMovimientos(){
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            String sql = "SELECT nombre FROM movimiento ORDER BY nombre";
            String[] movimientos = new String[52];
            
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                Integer i = 0;
                
                while(rs.next()){
                    movimientos[i] = rs.getString("nombre");
                    i++;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return movimientos;
        }
        
        public static String[] getTipos(){
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            String sql = "SELECT nombre FROM tipo ORDER BY idTipo DESC";
            String[] tipos = new String[19];
            
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                Integer i = 0;
                
                while(rs.next()){
                    tipos[i] = rs.getString("nombre");
                    i++;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return tipos;
        }
        
        public static String[] getHabilidades(){
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            String sql = "SELECT nombre FROM habilidad ORDER BY nombre";
            String[] habilidades = new String[25];
            
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                Integer i = 0;
                
                while(rs.next()){
                    habilidades[i] = rs.getString("nombre");
                    i++;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return habilidades;
        }
        
        public static String[] getRegiones(){
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            String sql = "SELECT nombre FROM region";
            String[] region = new String[8];
            
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                Integer i = 0;
                
                while(rs.next()){
                    region[i] = rs.getString("nombre");
                    i++;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return region;
        }
        
        public static boolean registrarPokemon(String nombre, String apodo, String genero,
                Integer id, String habilidad, String region, String tipo1, String tipo2,
                String[] movimientos){
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT idRegion FROM region WHERE nombre = ?");
                ps.setString(1, region);
                ResultSet rs = ps.executeQuery();
                rs.next();
                region = rs.getString("idRegion");

                ps = con.prepareStatement("SELECT idHabilidad FROM habilidad WHERE nombre = ?");
                ps.setString(1, habilidad);
                rs = ps.executeQuery();
                rs.next();
                habilidad = rs.getString("idHabilidad");

                ps = con.prepareStatement("SELECT idTipo FROM tipo WHERE nombre = ?");
                ps.setString(1, tipo1);
                rs = ps.executeQuery();
                rs.next();
                tipo1 = rs.getString("idTipo");

                ps = con.prepareStatement("SELECT idTipo FROM tipo WHERE nombre = ?");
                ps.setString(1, tipo2);
                rs = ps.executeQuery();
                rs.next();
                tipo2 = rs.getString("idTipo");

                for(int i = 0; i < movimientos.length; i++){
                    ps = con.prepareStatement("SELECT idMovimiento FROM movimiento WHERE nombre = ?");
                    ps.setString(1, movimientos[i]);
                    rs = ps.executeQuery();
                    rs.next();
                    movimientos[i] = rs.getString("idMovimiento");
                }

                ps = con.prepareStatement("INSERT INTO pokemon(numeroPokedex,nombre,apodo,genero,Entrenador_idEntrenador,Habilidad_idHabilidad,Region_idRegion)"
                        + "VALUES(?,?,?,?,?,?,?)");
                Integer pkdxnum = (int)(Math.random()*898);
                ps.setString(1, pkdxnum.toString());
                ps.setString(2,nombre);
                ps.setString(3, apodo);
                ps.setString(4, genero);
                ps.setString(5, id.toString());
                ps.setString(6, habilidad);
                ps.setString(7, region);
                ps.execute();
                
                ps = con.prepareStatement("SELECT idPokemon FROM pokemon "
                        + "WHERE numeroPokedex = ? AND apodo = ? AND Habilidad_idHabilidad = ?");
                ps.setString(1, pkdxnum.toString());
                ps.setString(2, apodo);
                ps.setString(3, habilidad);
                rs = ps.executeQuery();
                rs.next();
                String pokemonId = rs.getString("idPokemon");
                
                for(int i = 0; i < movimientos.length; i++){
                    ps = con.prepareStatement("INSERT INTO pokemon_has_movimiento(Pokemon_idPokemon,Movimiento_idMovimiento) "
                        + "VALUES(?,?)");
                    ps.setString(1, pokemonId);
                    ps.setString(2, movimientos[i]);
                    ps.execute();
                }
                
                ps = con.prepareStatement("INSERT INTO pokemon_has_tipo(Pokemon_idPokemon,Tipo_idTipo) "
                        + "VALUES(?,?),(?,?)");
                ps.setString(1, pokemonId);
                ps.setString(2, tipo1);
                ps.setString(3, pokemonId);
                ps.setString(4, tipo2);
                ps.execute();
                return true;
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
        public static String[] getPokemon(Integer id){
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            ArrayList<String> pokemon = new ArrayList<String>();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT nombre FROM pokemon WHERE Entrenador_idEntrenador = ? ORDER BY numeroPokedex");
                ps.setString(1, id.toString());
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    pokemon.add(rs.getString("nombre"));
                }                
            } catch(SQLException ex){
                return null;
            }
            String[] ans = new String[pokemon.size()];
            for(int i = 0; i < ans.length; i++)
                ans[i] = pokemon.get(i);
            
            return ans;
        }
        
        public static String getLista(Integer id){
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            PreparedStatement ps;
            ArrayList<String> pokemon = new ArrayList<String>(); 

            try {
                ps = con.prepareStatement("SELECT numeroPokedex,apodo,nombre FROM pokemon"
                        + " WHERE Entrenador_idEntrenador = ? ORDER BY numeroPokedex");
                ps.setString(1, id.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println("Entré al while.");
                    System.out.println("#"+rs.getString("numeroPokedex") + " - " + rs.getString("apodo")
                    + " - " + rs.getString("nombre") + "\n");
                    pokemon.add("#"+rs.getString("numeroPokedex") + " - " + rs.getString("apodo")
                    + " - " + rs.getString("nombre") + "\n");
                }
                String ans = "";
                for(String s : pokemon)
                    ans = ans.concat(s);
                return ans;
                    
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
        }

    public static void eliminarPokemon(Integer id, String nombrePokemon) {
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            String pokemonId = "";
            PreparedStatement ps = con.prepareStatement("SELECT idPokemon FROM pokemon WHERE nombre = ? AND Entrenador_idEntrenador = ?");
            ps.setString(1, nombrePokemon);
            ps.setString(2, id.toString());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                pokemonId = rs.getString("idPokemon");
            System.out.println(pokemonId);
            
            ps = con.prepareStatement("DELETE FROM pokemon_has_tipo WHERE Pokemon_idPokemon = ?");
            ps.setString(1, pokemonId);
            ps.execute();
            
            ps = con.prepareStatement("DELETE FROM pokemon_has_movimiento WHERE Pokemon_idPokemon = ?");
            ps.setString(1, pokemonId);
            ps.execute();
            
            ps = con.prepareStatement("DELETE FROM pokemon WHERE nombre = ? AND Entrenador_idEntrenador = ?");
            ps.setString(2, id.toString());
            ps.setString(1, nombrePokemon);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] getMovimientosDe(Integer id, String nombre){
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        String[] ans = new String[4];
        try {
            PreparedStatement ps = con.prepareStatement("SELECT idPokemon FROM pokemon "
                    + "WHERE Entrenador_idEntrenador = ? "
                    + "AND nombre = ?");
           ps.setString(1, id.toString());
           ps.setString(2, nombre);
           ResultSet rs1 = ps.executeQuery();
           rs1.next();
           String pokemonId = rs1.getString("idPokemon");
           
            ps = con.prepareStatement("SELECT movimiento.nombre AS mov FROM pokemon_has_movimiento "
                    + "JOIN movimiento ON pokemon_has_movimiento.Pokemon_idPokemon = ? "
                    + "AND pokemon_has_movimiento.Movimiento_idMovimiento = movimiento.idMovimiento;");
            ps.setString(1, pokemonId);
            rs1 = ps.executeQuery();
            int i = 0;
            while(rs1.next()){
                System.out.println(rs1.getString("mov"));
                ans[i] = rs1.getString("mov");
                i++;
            }
            
            return ans;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    static String[] getTiposDe(Integer id, String nombre) {
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        String[] ans = new String[2];
        try {
            PreparedStatement ps = con.prepareStatement("SELECT idPokemon FROM pokemon "
                    + "WHERE Entrenador_idEntrenador = ? "
                    + "AND nombre = ?");
           ps.setString(1, id.toString());
           ps.setString(2, nombre);
           ResultSet rs1 = ps.executeQuery();
           rs1.next();
           String pokemonId = rs1.getString("idPokemon");
           
            ps = con.prepareStatement("SELECT tipo.nombre AS tipo FROM pokemon_has_tipo "
                    + "JOIN tipo ON pokemon_has_tipo.Pokemon_idPokemon = ? "
                    + "AND pokemon_has_tipo.Tipo_idTipo = tipo.idTipo");
            ps.setString(1, pokemonId);
            rs1 = ps.executeQuery();
            int i = 0;
            while(rs1.next()){
                System.out.println(rs1.getString("tipo"));
                ans[i] = rs1.getString("tipo");
                i++;
            }
            
            return ans;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String[] getOtrosDe(Integer id, String nombre) {
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
           PreparedStatement ps = con.prepareStatement("SELECT * FROM pokemon "
                    + "WHERE Entrenador_idEntrenador = ? "
                    + "AND nombre = ?");
           ps.setString(1, id.toString());
           ps.setString(2, nombre);
           ResultSet rs1 = ps.executeQuery();
           rs1.next();
           String region = rs1.getString("Region_idRegion");
           String habilidad = rs1.getString("Habilidad_idHabilidad");
           
            PreparedStatement ps2 = con.prepareStatement("SELECT nombre FROM region WHERE idRegion = ?");
            ps2.setString(1, region);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            region = rs2.getString("nombre");
            
            ps2 = con.prepareStatement("SELECT nombre FROM habilidad WHERE idHabilidad = ?");
            ps2.setString(1, habilidad);
            rs2 = ps2.executeQuery();
            rs2.next();
            habilidad = rs2.getString("nombre");
            String[] ans = {rs1.getString("nombre"), rs1.getString("apodo"), region, habilidad, rs1.getString("genero"), rs1.getString("numeroPokedex")};
            return ans;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    static boolean editarPokemon(String nombre, String apodo, String genero, Integer id, String habilidad,
            String region, String tipo1, String tipo2, String[] movimientos, String[] oldValues) {
            Conexion c = new Conexion();
            Connection con = c.makeConnection();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT idRegion FROM region WHERE nombre = ?");
                ps.setString(1, region);
                ResultSet rs = ps.executeQuery();
                rs.next();
                region = rs.getString("idRegion");

                ps = con.prepareStatement("SELECT idHabilidad FROM habilidad WHERE nombre = ?");
                ps.setString(1, habilidad);
                rs = ps.executeQuery();
                rs.next();
                habilidad = rs.getString("idHabilidad");

                ps = con.prepareStatement("SELECT idTipo FROM tipo WHERE nombre = ?");
                ps.setString(1, tipo1);
                rs = ps.executeQuery();
                rs.next();
                tipo1 = rs.getString("idTipo");

                ps = con.prepareStatement("SELECT idTipo FROM tipo WHERE nombre = ?");
                ps.setString(1, tipo2);
                rs = ps.executeQuery();
                rs.next();
                tipo2 = rs.getString("idTipo");

                for(int i = 0; i < movimientos.length; i++){
                    ps = con.prepareStatement("SELECT idMovimiento FROM movimiento WHERE nombre = ?");
                    ps.setString(1, movimientos[i]);
                    rs = ps.executeQuery();
                    rs.next();
                    movimientos[i] = rs.getString("idMovimiento");
                }
                
                ps = con.prepareStatement("SELECT idPokemon FROM pokemon "
                        + "WHERE nombre = ? AND apodo = ? AND Entrenador_idEntrenador = ?");
                ps.setString(1, oldValues[0]);
                ps.setString(2, oldValues[1]);
                ps.setString(3, id.toString());
                rs = ps.executeQuery();
                rs.next();
                String pokemonId = rs.getString("idPokemon");
                
                ps = con.prepareStatement("UPDATE pokemon SET nombre = ?,apodo = ?,genero = ?,"
                        + "Habilidad_idHabilidad = ?,Region_idRegion = ?"
                        + "WHERE idPokemon = ?");
                ps.setString(1, nombre);
                ps.setString(2, apodo);
                ps.setString(3, genero);
                ps.setString(4, habilidad);
                ps.setString(5, region);
                ps.setString(6, pokemonId);
                ps.execute();
                
                ps = con.prepareStatement("DELETE FROM pokemon_has_tipo WHERE Pokemon_idPokemon = ?");
                ps.setString(1, pokemonId);
                ps.execute();
            
                ps = con.prepareStatement("DELETE FROM pokemon_has_movimiento WHERE Pokemon_idPokemon = ?");
                ps.setString(1, pokemonId);
                ps.execute();
                
                for(int i = 0; i < movimientos.length; i++){
                    ps = con.prepareStatement("INSERT INTO pokemon_has_movimiento(Pokemon_idPokemon,Movimiento_idMovimiento) "
                        + "VALUES(?,?)");
                    ps.setString(1, pokemonId);
                    ps.setString(2, movimientos[i]);
                    ps.execute();
                }
                
                ps = con.prepareStatement("INSERT INTO pokemon_has_tipo(Pokemon_idPokemon,Tipo_idTipo) "
                        + "VALUES(?,?),(?,?)");
                ps.setString(1, pokemonId);
                ps.setString(2, tipo1);
                ps.setString(3, pokemonId);
                ps.setString(4, tipo2);
                ps.execute();
                
                return true;
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }

    public static String getInfoDeHabilidad(String hab) {
        String text = "";
        PreparedStatement ps;
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            ps = con.prepareStatement("SELECT descripcion FROM habilidad WHERE nombre = ?");
            ps.setString(1, hab);
            ResultSet rs = ps.executeQuery();
            rs.next();
            text = hab.toUpperCase() + "\n" + rs.getString("descripcion");
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return text;
    }

    static String getInfoDeMov(String mov) {
        String text = "";
        PreparedStatement ps;
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM movimiento WHERE nombre = ?");
            ps.setString(1, mov);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String usos = rs.getString("usos");
            String descripcion = rs.getString("descripcion");
            String prioridad = rs.getString("prioridad");
            String tipo = rs.getString("Tipo_idTipo");
            String categoria = rs.getString("Categoria_idCategoria");
            System.out.println(prioridad);
            
            ps = con.prepareStatement("SELECT nombre FROM tipo WHERE idTipo = ?");
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            rs.next();
            tipo = rs.getString("nombre");
            
            ps = con.prepareStatement("SELECT nombre FROM categoria WHERE idCategoria = ?");
            ps.setString(1, categoria);
            rs = ps.executeQuery();
            rs.next();
            categoria = rs.getString("nombre");
            
            return mov.toUpperCase() + "\nUSOS: " + usos + "\nDESCRIPCIÓN: " + descripcion
                    + "\nTIPO: " + tipo + "\nCATEGORIA: " + categoria + "\nPRIORIDAD: "
                    + (prioridad.equals("0") ? "No" : "Sí");
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return text;
    }

    public static String[] getInfoUsuario(Integer id) {
        PreparedStatement ps;
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM usuario WHERE entrenador_identrenador = ?");
            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            String contrasena = rs.getString("contrasena");
            String nombreUsuario = rs.getString("nombre");
            
            ps = con.prepareStatement("SELECT * FROM entrenador WHERE identrenador = ?");
            ps.setString(1, id.toString());
            rs = ps.executeQuery();
            rs.next();
            String nombre = rs.getString("nombreEntrenador");
            
            String[] info = {nombre, nombreUsuario, contrasena, rs.getString("genero")};
            return info;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean editarUsuario(Integer id, String nombre, String usuario,
            String contrasena, String genero, String oldUsuario) {
        PreparedStatement ps;
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            ps = con.prepareStatement("UPDATE entrenador SET nombreEntrenador = ?, genero = ? WHERE idEntrenador = ?");
            ps.setString(1, nombre);
            ps.setString(2, genero);
            ps.setString(3, id.toString());
            ps.execute();
            
            ps = con.prepareStatement("DELETE FROM usuario WHERE nombre = ?");
            ps.setString(1, oldUsuario);
            ps.execute();
            
            ps = con.prepareStatement("INSERT INTO usuario(nombre,contrasena,entrenador_identrenador) "
                    + "VALUES(?,?,?)");
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ps.setString(3, id.toString());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    public static boolean eliminarUsuario(Integer id) {
        PreparedStatement ps;
        Conexion c = new Conexion();
        Connection con = c.makeConnection();
        try {
            ps = con.prepareStatement("DELETE FROM usuario WHERE Entrenador_idEntrenador = ?");
            ps.setString(1,id.toString());
            ps.execute();
            
            ps = con.prepareStatement("SELECT idPokemon FROM pokemon WHERE Entrenador_idEntrenador = ?");
            ps.setString(1,id.toString());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                PreparedStatement ps2 = con.prepareStatement("DELETE FROM pokemon_has_movimiento WHERE pokemon_idpokemon = ?");
                ps2.setString(1, rs.getString("idPokemon"));
                ps2.execute();
                
                ps2 = con.prepareStatement("DELETE FROM pokemon_has_tipo WHERE pokemon_idpokemon = ?");
                ps2.setString(1, rs.getString("idPokemon"));
                ps2.execute();
            }
            ps = con.prepareStatement("DELETE FROM pokemon WHERE Entrenador_idEntrenador = ?");
            ps.setString(1,id.toString());
            ps.execute();
            
            ps = con.prepareStatement("DELETE FROM entrenador WHERE idEntrenador = ?");
            ps.setString(1,id.toString());
            ps.execute();
            
            return true;            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

      