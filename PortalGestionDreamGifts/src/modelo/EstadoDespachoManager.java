/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class EstadoDespachoManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    

    public ArrayList<ArrayList<Object>> estadoSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM StatusDespacho");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String desc;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idStatusDespacho");
                status = resultadoSet.getInt("Enabled");
                desc = resultadoSet.getString("DescripcionStatus");
                
                switch(status){
                    case 0:
                        resultadoBool = false;
                    case 1:
                        resultadoBool = true;

                    default:
                        break;
                }

                fila.add(id);
                fila.add(desc);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        return matriz;
    }

    public void agregarEstadoSQL(String descripcion){
        PreparedStatement comando = null;
        
        try{
            comando = conexion.prepareStatement("INSERT INTO StatusDespacho (DescripcionStatus) VALUES (?)");
            comando.setString(1, descripcion);
            comando.execute();
            

        } catch(SQLException ex){
            Log.seguir(ex.getMessage());
        }  
    }
    
//    public static void main(String[] args) {
//       CatArticuloManager catArt = new CatArticuloManager();
//       catArt.categoriaSelectAll();
//       catArt.agregarCategoriaSQL();
//       catArt.categoriaSelectAll();
//    }
}