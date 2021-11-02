/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;
import java.sql.*;

/**
 *
 * @author StarxCrow
 */
public class Conexion{
    
    private static Connection conexion=null; 
    private static String servidor = "localhost";
    private static String baseDatos = "dreamgifts_db";
    private static String usuario = "root";
    private static String contrasena = "";
    
    
    public static Connection abrir() throws SQLException{
        if(conexion == null ){
            try{
                conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + "/"+ baseDatos,usuario,contrasena);
                Log.seguir("Conexion abierta");
            }catch(SQLException e){
                Log.seguir("Error metodo abrir conexion, clase conexion"+ e.getMessage());
            }
        }
            return conexion;
    }
    
    public static void cerrar() throws SQLException{
        if(conexion != null){
            conexion.close();
            Log.seguir("Conexion cerrada");
        }
    }
    
    
    
    
    
    
    
    
}
