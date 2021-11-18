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
 * @author nmoli
 */
public class VentaManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarVenta(String RUT, int Status, int idRRSS, int idBanco, int idPack, String TextoPack,
            int ValorTotal, int CodigoTransf,  String FechaIngreso, String FechaAprobada, String FechaDespacho, String NombreTarget, String CelularTarget,
            String DireccionTarget, int idComunaTarget, String FechaEntrega, String HoraDespachoIni, String HoraDespachoFin, int idStatusDespacho){
        
        PreparedStatement comando = null;
        try{
            comando = conexion.prepareStatement("INSERT INTO Venta VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setString(1, RUT);
            comando.setInt(2, Status);
            comando.setInt(3, idRRSS);
            comando.setInt(4, idBanco);
            comando.setInt(5, idPack);
            comando.setString(6, TextoPack);
            comando.setInt(7,ValorTotal);
            comando.setInt(8,CodigoTransf);
            comando.setString(9,FechaIngreso);
            comando.setString(10, FechaAprobada);
            comando.setString(11, FechaDespacho);
            comando.setString(12,NombreTarget);
            comando.setString(13, CelularTarget);
            comando.setString(14, DireccionTarget);
            comando.setInt(15, idComunaTarget);
            comando.setString(16, FechaEntrega);
            comando.setString(17,HoraDespachoIni);
            comando.setString(18,HoraDespachoFin);
            comando.setInt(19, idStatusDespacho);
            
            comando.execute();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
        
        
        
    }

    
}
