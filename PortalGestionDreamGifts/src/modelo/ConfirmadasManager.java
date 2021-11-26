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
 * @author luvar
 */
public class ConfirmadasManager {
    
    ConexionRequest intentoConexionRequest = new ConexionRequest();
    Connection conexion = intentoConexionRequest.conectar();
    
    public ArrayList<ArrayList<Object>> selectVentasConfirmadas(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Venta WHERE idStatus = 2");
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                ArrayList<Object> lista = new ArrayList<>();
                
                int idVenta = resultado.getInt(1);
                String RUT = resultado.getString(2);
                int idStatus = resultado.getInt(3);
                int idRRSS = resultado.getInt(4);
                int idBanco = resultado.getInt(5);
                int idPack = resultado.getInt(6);
                String msg = resultado.getString(7);
                int valor = resultado.getInt(8);
                int codigo = resultado.getInt(9);
                String fechaIngreso = resultado.getString(10);
                String fechaAprovada = resultado.getString(11);
                String fechaDespacho = resultado.getString(12);
                String nombreTarget = resultado.getString(13);
                String celularTarget = resultado.getString(14);
                String direccionTarget = resultado.getString(15);
                int idComunaTarget = resultado.getInt(16);
                String horaDespIni = resultado.getString(17);
                String horaDespFin = resultado.getString(18);
                int idStatusDespacho = resultado.getInt(19);
                
                lista.add(idVenta); lista.add(RUT); lista.add(idStatus); lista.add(idRRSS); lista.add(idBanco);
                lista.add(idPack); lista.add(msg); lista.add(valor); lista.add(codigo); lista.add(fechaIngreso);
                lista.add(fechaAprovada); lista.add(fechaDespacho); lista.add(nombreTarget); lista.add(celularTarget);
                lista.add(direccionTarget); lista.add(idComunaTarget); lista.add(horaDespIni); lista.add(horaDespFin);
                lista.add(idStatusDespacho);
                
                matriz.add(lista);
                }
            
                
            
        } catch(Exception ex){
                Log.seguir(ex.getMessage());
        }
        
        return matriz;
    }
    
}
