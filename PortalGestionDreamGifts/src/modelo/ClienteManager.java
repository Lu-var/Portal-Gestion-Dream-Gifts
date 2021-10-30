/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
        
/**
 *
 * @author luvar
 */
public class ClienteManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void AgregarCliente(String RUT, String nombre, String fechaNacimiento, String celular, String email, String direccion){
        Statement stm = null;
        int resultado = -1;
        try{
            stm = conexion.createStatement();
            
            resultado = stm.executeUpdate("INSERT INTO Cliente VALUES " + String.format("%s,%s,%s,%s,%s,%s",RUT,nombre,fechaNacimiento,celular,email,direccion));
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    
    
}
