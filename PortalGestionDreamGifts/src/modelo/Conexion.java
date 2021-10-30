/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;

/**
 *
 * @author Starlog 1v1 gil
 */
public class Conexion{
    
    Connection conectar=null; 
    
    public Connection conexion(){
        String address = "localhost";
        String database = "dreamgifts_db";
        String user = "root";
        String pass = "";
        
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://" + address + "/"+ database,user,pass);
            System.out.println("me conecte de pana paaa. Nashe!!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conectar;
    }
    
    public ResultSet select(String query){
        try{
            Statement sentencia = conectar.createStatement();
        
            ResultSet resultado = sentencia.executeQuery(query);
        
            return resultado;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
