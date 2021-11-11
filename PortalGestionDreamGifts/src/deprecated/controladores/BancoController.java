/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.controladores;
import deprecated.modelos.BancoManager;
import bd.Consulta;
import vista.Maestro;
import java.sql.ResultSet;
import bd.Log;

/**
 *
 * @author PC
 */
public class BancoController {
    
    public boolean agregar(String nombre){
        
        try{
            BancoManager banco = new BancoManager();
            //banco.agregarBanco(nombre);
            return banco.agregarBanco(nombre);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false; 

    }
}
