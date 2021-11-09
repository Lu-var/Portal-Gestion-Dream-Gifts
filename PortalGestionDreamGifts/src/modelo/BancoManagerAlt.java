/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luvar
 */
public class BancoManagerAlt {
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
     
    public boolean agregarBancoSQL(String nombre){
        try{
            comando = conexion.prepareStatement("INSERT INTO Banco (Nombre) VALUES (?)");
            comando.setString(1, nombre);
            comando.execute();
            
        } catch(Exception ex) { Log.seguir(ex.getMessage());}
        
        return false;        
    }
    
    public ArrayList<ArrayList<Object>> bancoSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Banco");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String nombre;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idBanco");
                status = resultadoSet.getInt("Enabled");
                nombre = resultadoSet.getString("Nombre");

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
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    } 
}
