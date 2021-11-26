/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author luvar
 */
public class ConfirmacionManager {
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void confirmarVentaSQL(int idVenta, int idBanco, int codigo, String fecha){
        try {
            PreparedStatement comando = conexion.prepareStatement("UPDATE Venta SET idStatus = 2, FechaAprobada = ?, idBanco = ?, CodigoTransf = ? WHERE idVenta = ?");
            comando.setString(1, fecha);
            comando.setInt(2, idBanco);
            comando.setInt(3,codigo);
            comando.setInt(4, idVenta);
            
            comando.executeUpdate();
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        
    }
}
