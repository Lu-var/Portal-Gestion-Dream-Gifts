/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luvar
 */
public class ArticuloManager { 
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public String selectCatArticuloSQL(int idCategoria){
        String categoria = new String();
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT distinct CategoriaArticulo.Descripcion"
                    + " FROM CategoriaArticulo"
                    + " INNER JOIN Articulo ON CategoriaArticulo.idCategoriaArticulo = (?)");
            
            comando.setInt(1, idCategoria);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                categoria = resultado.getString("Descripcion");
            }
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return categoria;
    }
    
    public int selectIDArticuloSQL(String categoria){
        int idCategoria = 0;
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT distinct CategoriaArticulo.idCategoriaArticulo"
                    + " FROM CategoriaArticulo "
                    + "INNER JOIN Articulo ON CategoriaArticulo.Descripcion = (?)");
            
            comando.setString(1, categoria);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                idCategoria = resultado.getInt("idCategoriaArticulo");
            }
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return idCategoria;
    }

    public int selectArticuloSQL(String nombre){
        int id = 0;
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT idArticulo FROM Articulo WHERE Nombre = ?");
            
            comando.setString(1,nombre);
            
            ResultSet resultado =  comando.executeQuery();
            
            resultado.next();
            id = resultado.getInt(1);
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return id;
    }    
    
    public void agregarArticuloSQL(String nombre, String fecha, int stock, int idCat){
        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO Articulo (Nombre,FechaVencimiento,Stock,idCategoriaArticulo) VALUES (?,?,?,?)");
            comando.setString(1, nombre);
            comando.setString(2, fecha);
            comando.setInt(3, stock);
            comando.setInt(4, idCat);
            
            comando.execute();
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        
    }
    
        public ArrayList<ArrayList<Object>> articuloSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Articulo");
            ResultSet resultado = comando.executeQuery();

            int id;
            int status;
            int idCat;
            int stock;
            String nombre;
            String fecha;
            
            while(resultado.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultado.getInt("idArticulo");
                status = resultado.getInt("Enabled");
                nombre = resultado.getString("Nombre");
                idCat = resultado.getInt("idCategoriaArticulo");
                fecha = resultado.getString("FechaVencimiento");
                stock = resultado.getInt("Stock");
                
                boolean flag = true;

                switch(status){
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        flag = true;
                        break;

                    default:
                        break;
                }

                fila.add(id);
                fila.add(nombre);
                fila.add(selectCatArticuloSQL(idCat));
                fila.add(stock);
                fila.add(fecha);
                fila.add(flag);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Errordsads: "+ex);
        }
        
        return matriz;
    }
        
    public ArrayList<ArrayList<Object>> articulosEnabledSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Articulo WHERE Enabled = 1");
            ResultSet resultado = comando.executeQuery();

            int id;
            int idCat;
            int stock;
            String nombre;
            String fecha;
            
            while(resultado.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultado.getInt("idArticulo");
                nombre = resultado.getString("Nombre");
                idCat = resultado.getInt("idCategoriaArticulo");
                fecha = resultado.getString("FechaVencimiento");
                stock = resultado.getInt("Stock");
                
                fila.add(id);
                fila.add(nombre);
                fila.add(selectCatArticuloSQL(idCat));
                fila.add(stock);
                fila.add(fecha);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            Log.seguir("Error: "+ex.getMessage());
        }
        
        return matriz;
    }


    public void update(int idTarget, String nombre, int idCatArt, int stock, String fecha, boolean flag){
        
        int status;
        if(flag){status = 1;} else{status = 0;}
        
        try{
            PreparedStatement comando = conexion.prepareStatement("UPDATE Articulo SET Nombre = (?), FechaVencimiento = (?), Stock = (?), idCategoriaArticulo = (?), Enabled = (?) WHERE idArticulo = (?)");
            
            comando.setString(1, nombre);
            comando.setString(2,fecha);
            comando.setInt(3, stock);
            comando.setInt(4, idCatArt);
            comando.setInt(5,status);
            comando.setInt(6, idTarget);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage()+"holi");
        }
        
        
    }    
        
//    public ArrayList<Integer> selectIDArticulo(){
//        ArrayList<Integer> matriz = new ArrayList<>();
//        try{
//            PreparedStatement comando = conexion.prepareStatement("SELECT idArticulo,Enabled FROM Articulo");
//            ResultSet resultado = comando.executeQuery();
//
//            int id = 0;
//            int status;
//            
//            while(resultado.next()){
//                status = resultado.getInt("Enabled");
//                if(status==1){
//                    id = resultado.getInt("idArticulo");
//                }
//                if(id == 0){
//                   matriz.add(id); 
//                }
//                
//                id = 0;
//            }
//            
//        } catch(Exception ex){
//            Log.seguir("Error: "+ex.getMessage());
//        }
//        
//        return matriz;
//    }
}
