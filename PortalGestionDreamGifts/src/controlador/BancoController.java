/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Banco;
import bd.Consulta;
import vista.Maestro;
import java.sql.ResultSet;
import bd.Log;

/**
 *
 * @author PC
 */
public class BancoController {
    
    public void agregar(String nombre){
        
        try{
            Consulta con = new Consulta();
            Banco agregar = new Banco();
            
            ResultSet rs = agregar.agregarBanco(nombre);
            Log.seguir("adsadsad");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
}
