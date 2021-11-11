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
                    case 1:
                        flag = true;

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
}
