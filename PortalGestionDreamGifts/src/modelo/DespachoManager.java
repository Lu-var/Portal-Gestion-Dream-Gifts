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
public class DespachoManager {
    
    ConexionRequest conexionRequest = new ConexionRequest();
    Connection conexion = conexionRequest.conectar();
    
    public void updateEstado(int idVenta, int idEstado){
        try {
            PreparedStatement comando = conexion.prepareStatement("UPDATE Venta SET idStatusDespacho = ? WHERE idVenta = ?");
            comando.setInt(1, idEstado);
            comando.setInt(2, idVenta);
            
            comando.executeUpdate();
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }
    
}
