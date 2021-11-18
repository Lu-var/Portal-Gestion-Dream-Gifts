/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class CatArticuloManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    

    public ArrayList<ArrayList<Object>> categoriaSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM CategoriaArticulo");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String desc;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idCategoriaArticulo");
                status = resultadoSet.getInt("Enabled");
                desc = resultadoSet.getString("Descripcion");

                if(status==0) resultadoBool=false; else resultadoBool = true;

                fila.add(id);
                fila.add(desc);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }
    
    public ArrayList<ArrayList<Object>> categoriasEnabledSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM CategoriaArticulo WHERE Enabled = 1");
            resultadoSet = comando.executeQuery();

            int id;
            String desc;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idCategoriaArticulo");
                desc = resultadoSet.getString("Descripcion");


                fila.add(id);
                fila.add(desc);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }    

    public void agregarCategoriaSQL(String descripcion){
        PreparedStatement comando = null;

        try{
            comando = conexion.prepareStatement("INSERT INTO CategoriaArticulo (Descripcion) VALUES (?)");
            comando.setString(1, descripcion);
            comando.execute();
            

        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
    }
    
    public int selectCatByStr(String categoria){
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT idCategoriaArticulo FROM CategoriaArticulo WHERE Descripcion = ?");
            
            comando.setString(1, categoria);
            ResultSet resultado = comando.executeQuery();
            resultado.next();
            return resultado.getInt(1);
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return 1;
    }
    
    
    public void update(int idTarget, String nombre, boolean flag){
        
        int status;
        if(flag){status = 1;} else{status = 0;}
        
        try{
            comando = conexion.prepareStatement("UPDATE CategoriaArticulo SET Descripcion = (?), Enabled = (?) WHERE idCategoriaArticulo = (?)");
            
            comando.setString(1, nombre);
            comando.setInt(2,status);
            comando.setInt(3, idTarget);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        
    }
}