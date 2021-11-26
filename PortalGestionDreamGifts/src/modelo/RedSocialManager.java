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
 * @author PC
 */
public class RedSocialManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
     
    public boolean agregarRRSSSQL(String nombre){
        try{
            comando = conexion.prepareStatement("INSERT INTO RRSS (Nombre) VALUES (?)");
            comando.setString(1, nombre);
            comando.execute();
            
        } catch(Exception ex) { Log.seguir(ex.getMessage());}
        
        return false;        
    }
    
    public ArrayList<ArrayList<Object>> rrssSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM RRSS");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String nombre;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idRRSS");
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
    
    public ArrayList<ArrayList<Object>> rrssSelectAllEnabled(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM RRSS WHERE Enabled = 1");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String nombre;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idRRSS");
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
    
    public void update(int idTarget, String nombre, boolean flag){
        
        int status;
        if(flag){status = 1;} else{status = 0;}
        
        try{
            comando = conexion.prepareStatement("UPDATE RRSS SET Nombre = (?), Enabled = (?) WHERE idRRSS = (?)");
            
            comando.setString(1, nombre);
            comando.setInt(2,status);
            comando.setInt(3, idTarget);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        
    }
    
}
