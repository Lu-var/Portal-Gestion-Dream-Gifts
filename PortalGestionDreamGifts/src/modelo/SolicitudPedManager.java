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

/**
 *
 * @author Longares
 */
public class SolicitudPedManager {
    
    public static ArrayList<ArrayList<Object>> pedidosEnabledSelectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarPedidoSQL(String fPedido){

        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO OrdenCompra (FechaOrden) VALUES (?)");
            comando.setString(1, fPedido);
            comando.execute();
            
            } catch (Exception ex) {
                Log.seguir(ex.getCause().getMessage() +"|||||" + ex.getMessage());
            }
    }
    
    public void agregarDetallePSQL(ArrayList<ArrayList<Integer>> idArticulo){
        int idOrdenCompra = 0;
        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO DetalleOrden (idOrdenCompra) SELECT MAX(idOrdenCompra) FROM OrdenCompra");
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                idOrdenCompra = resultado.getInt(1);
            }
            
            comando = conexion.prepareStatement("INSERT INTO DetalleOrden (idArticulo, Cantidad) VALUES (?, ?)");
        int cantidad = 0;
        int id = 0;
            for (int i = 0; i < detalleP.size(); i++) {
                comando.setInt(1, id);
                comando.setInt(2, cantidad);


                comando.execute();
            }              
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }


   

    public void BuscarPedidoSQL(ArrayList<ArrayList<Integer>> pedidoNum){
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT OrdenCompra.idOrdenCompra, OrdenCompra.FechaOrden, DetalleOrden.Cantidad FROM (OrdenCompra INNER JOIN DetalleOrden ON OrdenCompra.idOrdenCompra = DetalleOrden.idOrdenCompra)");       
            ResultSet resultado = comando.executeQuery();

            int idOrdenCompra;
            String FechaOrden;
            int cantidad;
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                idOrdenCompra = resultado.getInt(1);
                FechaOrden = resultado.getString(2);
                cantidad = resultado.getInt(3);
           
                lista.add(idOrdenCompra);
                lista.add(FechaOrden);
                lista.add(cantidad);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }


    
}
