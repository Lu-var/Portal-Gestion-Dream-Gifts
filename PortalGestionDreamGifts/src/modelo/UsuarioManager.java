/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import bd.Log;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luvar
 */
public class UsuarioManager { 
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    
    
    public boolean loginCheck(String usuario, String clave){
        try{
            comando = conexion.prepareStatement("SELECT Nombre,Password FROM Usuario WHERE Nombre = ? AND Password = ?");
            comando.setString(1, usuario);
            comando.setString(2, clave);
            resultadoSet = comando.executeQuery();
            
            if(!resultadoSet.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,resultadoSet + "JaJaJa! Credenciales incorrectas.");
                
            } else{return true;}
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return false;
    }
    
        public ArrayList<ArrayList<Object>> usuarioSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Usuario");
            resultadoSet = comando.executeQuery();

            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                int id = resultadoSet.getInt("idUsuario");
                String nombre = resultadoSet.getString("Nombre");
                String pass = resultadoSet.getString("Password");
                int status = resultadoSet.getInt("Enabled");

                switch(status){
                    case 0:
                        resultadoBool = false;
                    case 1:
                        resultadoBool = true;

                    default:
                        break;
                }

                fila.add(id);
                fila.add(nombre);
                fila.add(pass);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }

    public boolean agregarUsuarioSQL(String nombre, String pass){
        PreparedStatement comando = null;
        if(nombre.equals("")){
            return false;
        }
        
        if(pass.equals("")){
            return false;
        }

        try{
            comando = conexion.prepareStatement("INSERT INTO Usuario (Nombre,Password) VALUES (?,?)");
            comando.setString(1, nombre);
            comando.setString(2, pass);
            comando.execute();
            

        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return true;
    }

    public void update(int id, String nombre, String clave, boolean flag){
        
        int status;
        if(flag){status = 1;} else{status = 0;}
        
        try{
            comando = conexion.prepareStatement("UPDATE Usuario SET Nombre = (?), Password = (?), Enabled = (?) WHERE idUsuario = (?)");
            
            comando.setString(1, nombre);
            comando.setString(2,clave);
            comando.setInt(3,status);
            comando.setInt(4, id);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        
    }    
    
}
