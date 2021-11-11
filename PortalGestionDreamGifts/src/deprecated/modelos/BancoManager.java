/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;
import bd.Consulta;
import bd.Log;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class BancoManager {
    
    public boolean agregarBanco(String nombre){
        //try{
        Consulta con = new Consulta();
            
        String query = "INSERT INTO `banco`(`Nombre`) VALUES ('"+nombre+"')";
        Log.seguir(query);
        return con.ejecutar(query);
            //ResultSet rs = con.insert(query);
        //}catch(Exception e){
        //    System.out.println(e.getMessage());
        //}
        //return false;
    }
    
    public boolean actualizarBanco(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = String.format("UPDATE `banco` SET =`Nombre`='"+nombre+"' WHERE 1");
        Log.seguir("estoy en update"+query);
        return con.ejecutar(query);
    }
    
    public boolean borrarBanco(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = String.format("Delete from 'banco' "
                           + "where nombre= '%s'"
                              ,nombre);
        Log.seguir("estoy en delete"+query);
        return con.ejecutar(query);
    }
}
