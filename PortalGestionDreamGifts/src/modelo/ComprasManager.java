/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nmoli
 */
public class ComprasManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    public void agregarSolicitud(int idOrdenCompra, int idArticulo, int Cantidad, int PrecioUnitario) {

        PreparedStatement comando = null;
        try {
            comando = conexion.prepareStatement("INSERT INTO DetalleOrden VALUES (?,?,?,?)");
            comando.setInt(1, idOrdenCompra);
            comando.setInt(2, idArticulo);
            comando.setInt(3, Cantidad);
            comando.setInt(4, PrecioUnitario);

            comando.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void registrarCompra (int idFactura, int idArticulo, int Cantidad, int Total, String FechaVencimiento){
        
        PreparedStatement comando = null;
        try {
            comando = conexion.prepareStatement("INSERT INTO DetalleFactura VALUES (?,?,?,?,?)");
            comando.setInt(1, idFactura);
            comando.setInt(2, idArticulo);
            comando.setInt(3, Cantidad);
            comando.setInt(4, Total);
            comando.setString(5, FechaVencimiento);
            
            comando.execute();           
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
    }
    
    
    
}
