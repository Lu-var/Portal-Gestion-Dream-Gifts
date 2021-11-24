/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nmoli
 */
public class ComprasManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    public void agregarSolicitud(String FechaOrden, String RutProveedor) {

        PreparedStatement comando = null;
        try {
            comando = conexion.prepareStatement("INSERT INTO OrdenCompra VALUES (?,?)");
            comando.setString(1, FechaOrden);
            comando.setString(2, RutProveedor);

            comando.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ArrayList<ArrayList<Object>> ingresoSelectAllSQL(){
        
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        
        try{
            comando = conexion.prepareStatement("SELECT * FROM OrdenCompra"); 
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                String FechaOrden = resultado.getString("FechaOrden");
                String RutProveedor = resultado.getString("RutProveedor");
                                
                lista.add(FechaOrden);
                lista.add(RutProveedor);
                matriz.add(lista);
                }
            
                
            
        } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
        }
        
        return matriz;
    
        
        
    }public void InfoClientes(ResultSet Compras){
        
        try{
            while(Compras.next()){
                System.out.println("FechaOrden: " + Compras.getString("FechaOrden"));
                System.out.println("RutProveedor: " + Compras.getString("RutProveedor"));
                System.out.println("\n");
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    
}

    public void agregarRegistro(int Cantidad, int Precio, String fechaStr) {
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
}
