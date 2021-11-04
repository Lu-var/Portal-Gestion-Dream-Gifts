/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import bd.Consulta;
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

    public Banco(int idBanco, String nombre, int enabled) {
        this.idBanco = idBanco;
        this.nombre = nombre;
        this.enabled = enabled;
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
    
    public void agregarBanco(){
        try{
            Consulta con = new Consulta();
            
            
            String query = "INSERT INTO `banco`(`Nombre`) VALUES ('"+nombre+"'";
            
            ResultSet rs = con.insert(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
