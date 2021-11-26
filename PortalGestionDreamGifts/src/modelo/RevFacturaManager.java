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
import modelo.ConexionRequest;

/**
 *
 * @author longares
 */
public class RevFacturaManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public ArrayList<ArrayList<Object>> BuscarFacturaSQL(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();

        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT DetalleFactura.idFactura, Facturas.Fecha, Proveedor.RazonSocial, DetalleFactura.Total FROM (((DetalleFactura INNER JOIN Facturas ON DetalleFactura.idFactura = Facturas.idOrdenCompra) INNER JOIN OrdenCompra ON Facturas.idOrdenCompra = OrdenCompra.idOrdenCompra) INNER JOIN Proveedor ON OrdenCompra.RutProveedor = Proveedor.RUT)");       
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
            PreparedStatement comando = conexion.prepareStatement("SELECT DetalleFactura.idArticulo, Articulo.Nombre, DetalleFactura.Cantidad, DetalleFactura.Total FROM (DetalleFactura INNER JOIN Articulo ON DetalleFactura.idFactura = Articulo.idArticulo)");    
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
