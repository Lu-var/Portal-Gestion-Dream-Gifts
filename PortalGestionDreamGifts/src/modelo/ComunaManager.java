/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import bd.Consulta;
import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ComunaManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
     
    public boolean agregarComunaSQL(String nombre){
        try{
            comando = conexion.prepareStatement("INSERT INTO Comuna (Nombre) VALUES (?)");
            comando.setString(1, nombre);
            comando.execute();
            
        } catch(Exception ex) { Log.seguir(ex.getMessage());}
        
        return false;        
    }
    
    public ArrayList<ArrayList<Object>> comunaSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Comuna");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String nombre;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idComuna");
                status = resultadoSet.getInt("Enabled");
                nombre = resultadoSet.getString("Nombre");

                if(status==0) resultadoBool=false; else resultadoBool = true;

                fila.add(id);
                fila.add(nombre);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }
    
    public ArrayList<ArrayList<Object>> comunaSelectAllEnabled(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Comuna WHERE Enabled = 1");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String nombre;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idComuna");
                status = resultadoSet.getInt("Enabled");
                nombre = resultadoSet.getString("Nombre");

                if(status==0) resultadoBool=false; else resultadoBool = true;

                fila.add(id);
                fila.add(nombre);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }
    
    public ArrayList<Object> comunaSelectByName(String nombre){
        ArrayList<Object> fila = new ArrayList<Object>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Comuna WHERE Nombre = ?");
            comando.setString(1, nombre);
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            while(resultadoSet.next()){

                id = resultadoSet.getInt("idComuna");
                status = resultadoSet.getInt("Enabled");
                nombre = resultadoSet.getString("Nombre");

                if(status==0) resultadoBool=false; else resultadoBool = true;

                fila.add(id);
                fila.add(nombre);
                fila.add(resultadoBool);
            }
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        return fila;
    }
    
    public void update(int idTarget, int id, String nombre, boolean flag){
        
        int status;
        if(flag){status = 1;} else{status = 0;}
        
        try{
            comando = conexion.prepareStatement("UPDATE Comuna SET idComuna = (?), Nombre = (?), Enabled = (?) WHERE idComuna = (?)");
            
            comando.setInt(1, id);
            comando.setString(2, nombre);
            comando.setInt(3,status);
            comando.setInt(4, idTarget);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        
    }    
    
}
