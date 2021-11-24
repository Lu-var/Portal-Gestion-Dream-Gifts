/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author nmoli
 */
public class RegistroCompraManager {
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarRegistroSQL(int Cantidad, int Precio, Date fechaVencimiento){
        PreparedStatement comando = null;
        try{
            comando = conexion.prepareStatement("INSERT INTO DetalleFactura VALUES (?,?,?)");
            comando.setInt(1, Cantidad);
            comando.setInt(2, Precio);
            comando.setDate(3, (java.sql.Date) fechaVencimiento);
                        
            comando.execute();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
    }

}


