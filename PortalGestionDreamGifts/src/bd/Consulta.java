/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Consulta {
    public ResultSet select(String query) throws SQLException{
        try{
            Statement sentencia = Conexion.abrir().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            return resultado;
        }catch(SQLException e){
            Log.seguir("Error en consultar select " + e.getMessage());
        }
        return null;
    }
    
    /*public ResultSet insert(String query) throws SQLException{
        try{
            Statement sentencia = Conexion.abrir().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            return resultado;
        }catch(SQLException e){
            Log.seguir("error al agregar " + e.getMessage());
        }
       return null; 
    }    
    /*
        insert
        update
        delete
    */
     public boolean ejecutar(String query)
    {
        Log.seguir("PASE POR insert");
        try {
            Statement sentencia = Conexion.abrir().createStatement();
            sentencia.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Log.seguir("me cai ejecutar"+ex.getMessage());
        }
        return false;
    }
    
}
