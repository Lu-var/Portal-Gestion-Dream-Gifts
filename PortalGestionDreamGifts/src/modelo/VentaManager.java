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
import modelo.ClienteManager;

/**
 *
 * @author luvar
 */
public class VentaManager {
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    ClienteManager clienteManager = new ClienteManager();
    
    public void agregarVentaSQL(String RUT, String nombre, String fechaNacimiento, String celular, String email, int status, int idRRSS, int idPack, String msg, int valor, String fechaStart, String fechaEntrega, String despachoIni, String despachoFin, String nombreTarget, String celularTarget, String direccionTarget, int idComuna){
        try {
            clienteManager.agregarClienteSQL(RUT, nombre, fechaNacimiento, celular, email);
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
            return;
        }

        try {
            PreparedStatement comando = conexion.prepareStatement("INSERT INTO Venta (rutCliente,idStatus,idRRSS,idPack,TextoPack,ValorTotal,FechaIngreso,FechaDespacho,NombreTarget,CelularTarget,DireccionTarget,idComunaTarget,HoraDespachoIni,HoraDespachoFin,idStatusDespacho,idBanco) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setString(1, RUT);
            comando.setInt(2, status);
            comando.setInt(3, idRRSS);
            comando.setInt(4, idPack);
            comando.setString(5, msg);
            comando.setInt(6, valor);
            comando.setString(7, fechaStart);
            comando.setString(8, fechaEntrega);
            comando.setString(9, nombreTarget);
            comando.setString(10, celularTarget);
            comando.setString(11, direccionTarget);
            comando.setInt(12, idComuna);
            comando.setString(13, despachoIni);
            comando.setString(14, despachoFin);
            comando.setInt(15, 1);
            comando.setObject(16, null);
            
            int resultado = comando.executeUpdate();
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
        }
    }
    
    public ArrayList<ArrayList<Object>> selectVentas(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        try {
            PreparedStatement comando = conexion.prepareStatement("SELECT * FROM Venta");
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
