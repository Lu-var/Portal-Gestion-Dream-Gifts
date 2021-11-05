/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import bd.Consulta;
import bd.Log;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class Banco {
    
    private int idBanco;
    private String nombre;
    private int enabled;

    public Banco() {
    }
    public Banco(String nombre) {
       
        this.nombre = nombre;
        
    }

    @Override
    public String toString() {
        return "Banco{" + "idBanco=" + idBanco + ", nombre=" + nombre + ", enabled=" + enabled + '}';
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

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
