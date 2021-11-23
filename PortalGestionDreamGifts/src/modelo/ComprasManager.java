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
public class ComprasManager {

    public static ArrayList<ArrayList<Object>> PedidosEnabledSelectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarPedidoSQL(String nombre, int precio, int stock, int idCategoria){

        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO OrdenCompra (FechaOrden) VALUES (?)");
            comando.setInt(1, FPedido);
            comando.execute();
            
            
            
            } catch (Exception ex) {
                Log.seguir(ex.getCause().getMessage() +"|||||" + ex.getMessage());
            }
    }
    
    public void agregarDetallePSQL(ArrayList<ArrayList<Integer>> idArticulo){
        int idOrdenCompra = -1;
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT MAX(idOrdenCompra) FROM OrdenCompra");
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                idOrdenCompra = resultado.getInt(1);
            }
            
            comando = conexion.prepareStatement("INSERT INTO DetalleOrden (idArticulo, Cantidad) VALUES (?, ?)");

            for (int i = 0; i < DetalleP.size(); i++) {
                comando.setInt(1, id);
                comando.setInt(2, DetalleP.get(i).get(0));
                comando.setInt(3, DetalleP.get(i).get(1));

                comando.execute();
            }              
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }


    public ArrayList<ArrayList<Object>> BuscarPedidoSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT (idOrdenCompra, FechaOrden) FROM OrdenCompra");       
            ResultSet resultado = comando.executeQuery();

            int idOrdenCompra;
            String FechaOrden;
            int status = 1;
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                idOrdenCompra = resultado.getInt(1);
                FechaOrden = resultado.getString(3);
                status = resultado.getInt(5);
                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(idOrdenCompra);
                lista.add(FechaOrden);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }

    public ArrayList<ArrayList<Object>> BuscarDetallePSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT (idArticulo, Cantidad) FROM DetalleOrden");       
            ResultSet resultado = comando.executeQuery();

            int id;
            int stock;

            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                id = resultado.getInt(2);
                stock = resultado.getInt(4);
                status = resultado.getInt(5);
                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(id);
                lista.add(stock);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }

    public ArrayList<ArrayList<Object>> BuscarFacturaSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT (idFactura, Fecha) FROM Facturas");       
            ResultSet resultado = comando.executeQuery();

            int id;
            String Fecha;

            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                id = resultado.getInt(1);
                Fecha = resultado.getString(2);

                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(id);
                lista.add(Fecha);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }

    public ArrayList<ArrayList<Object>> BuscarDetalleFSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT DetalleFactura.idFactura, Facturas.Fecha, Proveedor.RazonSocial, DetalleFactura.Total FROM (((DetalleFactura INNER JOIN Facturas ON DetalleFactura.idFactura = Facturas.idOrdenCompra) INNER JOIN OrdenCompra ON Facturas.idOrdenCompra = OrdenCompra.idOrdenCompra) INNER JOIN Proveedor ON OrdenCompra.RutProveedor = Proveedor.RUT)");    
            ResultSet resultado = comando.executeQuery();
                                                                  
                                                                                




            int total;

            int status = 1;
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                id = resultado.getInt(2);
                stock = resultado.getInt(4);
                status = resultado.getInt(5);
                
                                
                boolean flag = true;
                if(status==0){
                    flag = false;
                }
                
                lista.add(id);
                lista.add(stock);
                lista.add(flag);
                
                matriz.add(lista);
            }

            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
        return matriz;
    }




}
