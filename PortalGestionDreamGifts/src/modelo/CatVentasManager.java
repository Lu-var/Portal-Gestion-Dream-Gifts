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
public class CatVentasManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    

    public ArrayList<ArrayList<Object>> categoriaSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM Status");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String desc;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idStatus");
                status = resultadoSet.getInt("Enabled");
                desc = resultadoSet.getString("DescripcionEstado");
                
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

    public void agregarCategoriaSQL(String descripcion){
        PreparedStatement comando = null;
        
        try{
            comando = conexion.prepareStatement("INSERT INTO Status (DescripcionEstado) VALUES (?)");
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