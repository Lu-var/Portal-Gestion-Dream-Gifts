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
import java.util.Vector;

/**
 *
 * @author luvar
 */
public class PackManager {
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarPackSQL(String nombre, int precio, int stock, int idCategoria){
        int idPack = 0;
        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO Pack (Nombre, Precio, Stock, idCategoriaPack) VALUES (?, ?, ?, ?)");
            comando.setString(1, nombre);
            comando.setInt(2, precio);
            comando.setInt(3, stock);
            comando.setInt(4, idCategoria);
            comando.execute();
            
            
            
            } catch (Exception ex) {
                Log.seguir(ex.getCause().getMessage() +"|||||" + ex.getMessage());
            }
    }
    
    public void agregarContenidosSQL(ArrayList<ArrayList<Integer>> contenido){
        int idPack = -1;
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT MAX(idPack) FROM Pack");
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                idPack = resultado.getInt(1);
            }
            
            comando = conexion.prepareStatement("INSERT INTO Contenidos (idPack, idArticulo, Cantidad) VALUES (?, ?, ?)");

            for (int i = 0; i < contenido.size(); i++) {
                comando.setInt(1, idPack);
                comando.setInt(2, contenido.get(i).get(0));
                comando.setInt(3, contenido.get(i).get(1));

                comando.execute();
            }              
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }
    
    public ArrayList<ArrayList<Object>> selectAllPackSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Pack");       
            ResultSet resultado = comando.executeQuery();

            int id;
            String nombre;
            int precio;
            int stock;
            int idCat;
            int status = 1;
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                id = resultado.getInt(1);
                nombre = resultado.getString(2);
                precio = resultado.getInt(3);
                stock = resultado.getInt(4);
                idCat = resultado.getInt(5);
                status = resultado.getInt(6);
                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(id);
                lista.add(nombre);
                lista.add(precio);
                lista.add(stock);
                lista.add(idCat);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }
    
    public ArrayList<ArrayList<Object>> selectAllPackEnabled(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Pack WHERE Enabled = 1");       
            ResultSet resultado = comando.executeQuery();

            int id;
            String nombre;
            int precio;
            int stock;
            int idCat;
            int status = 1;
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                id = resultado.getInt(1);
                nombre = resultado.getString(2);
                precio = resultado.getInt(3);
                stock = resultado.getInt(4);
                idCat = resultado.getInt(5);
                status = resultado.getInt(6);
                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(id);
                lista.add(nombre);
                lista.add(precio);
                lista.add(stock);
                lista.add(idCat);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }
    
    public ArrayList<ArrayList<Object>> selectContenidos(int idPack){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        try{
            PreparedStatement comando = conexion.prepareStatement("SELECT Contenidos.idArticulo, Contenidos.Cantidad, Articulo.Nombre FROM Contenidos INNER JOIN Articulo ON Contenidos.idPack = ? AND Contenidos.idArticulo = Articulo.idArticulo");
            comando.setInt(1, idPack);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                lista.add(resultado.getInt(1));
                lista.add(resultado.getInt(2));
                lista.add(resultado.getString(3));
                matriz.add(lista);
            }
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }
    
    public void editPack(int idPack, String nombre, int precio, int stock, int idCategoria, int enabled){
        try {
            PreparedStatement comando = conexion.prepareStatement("UPDATE Pack SET Nombre = ?, Precio = ?, Stock = ?, idCategoriaPack = ?, Enabled = ? WHERE idPack = ?");
            
            comando.setString(1, nombre);
            comando.setInt(2, precio);
            comando.setInt(3, stock);
            comando.setInt(4, idCategoria);
            comando.setInt(5, enabled);
            comando.setInt(6, idPack);
            
            comando.executeUpdate();
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }
    
    public void editContenidos(int idPack, ArrayList<ArrayList<Integer>> contenido){
        try {
            PreparedStatement comando = conexion.prepareStatement("DELETE FROM Contenidos WHERE idPack = ?");
            comando.setInt(1, idPack);
            comando.executeUpdate();
            
            comando = conexion.prepareStatement("INSERT INTO Contenidos (idPack, idArticulo, Cantidad) VALUES (?, ?, ?)");

            for (int i = 0; i < contenido.size(); i++) {
                comando.setInt(1, idPack);
                comando.setInt(2, contenido.get(i).get(0));
                comando.setInt(3, contenido.get(i).get(1));

                comando.executeUpdate();
            }             
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }
}
