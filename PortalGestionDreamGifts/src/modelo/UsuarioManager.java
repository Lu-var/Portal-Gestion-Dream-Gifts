/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
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
            comando = conexion.prepareStatement("SELECT Nombre FROM Usuarios WHERE Nombre = ?");
            comando.setString(1, usuario);
            resultadoSet = comando.executeQuery();
            
            if(!resultadoSet.isBeforeFirst()){
                throw new Exception("No existe ese usuario.");
            }
            
            comando = conexion.prepareStatement("SELECT Password FROM Usuarios WHERE Password = ?");
            comando.setString(1, clave);
            resultadoSet = comando.executeQuery();
            
            if(!resultadoSet.isBeforeFirst()){
                throw new Exception("Contraseña Incorrecta");
            } else{
                return true;
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return false;
    }
    
}
