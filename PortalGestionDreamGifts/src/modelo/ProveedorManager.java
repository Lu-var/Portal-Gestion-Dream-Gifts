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
public class ProveedorManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    
    public void agregarProvSQL(String rut, String razonSocial, String nombre, String telefono, String direccion, String email){
        try{
            
            comando = conexion.prepareStatement("INSERT INTO Proveedor VALUES (?,?,?,?,?,?,1)");
            comando.setString(1, rut);
            comando.setString(2, razonSocial);
            comando.setString(3, nombre);
            comando.setString(4, telefono);
            comando.setString(5, direccion);
            comando.setString(6, email);
            
            comando.execute();
            
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
    }
    
    public ArrayList<ArrayList<Object>> proveedorSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        
            String rut;
            String razon;
            String nombre;
            String telefono;
            String direccion;
            String email;
            int status;
        
        try{
            comando = conexion.prepareStatement("SELECT * FROM Proveedor");
            resultadoSet = comando.executeQuery();

            
            ArrayList<Object> fila = new ArrayList<>();
            
            while(resultadoSet.next()){
                
                rut = resultadoSet.getString("RUT");
                razon = resultadoSet.getString("RazonSocial");
                nombre = resultadoSet.getString("Nombre");
                telefono = resultadoSet.getString("Telefono");
                direccion = resultadoSet.getString("Direccion");
                email = resultadoSet.getString("Email");
                status = resultadoSet.getInt("Enabled");
                
                switch(status){
                    case 0:
                        resultadoBool = false;
                    case 1:
                        resultadoBool = true;

                    default:
                        break;
                }
            
                fila.add(rut);
                fila.add(razon);
                fila.add(nombre);
                fila.add(telefono);
                fila.add(direccion);
                fila.add(email);
                fila.add(resultadoBool);

                matriz.add(fila);
            }
        } catch(Exception ex){
            Log.seguir(ex.getMessage());
        }
        
        return matriz;
    }
    
    public static void main(String[] args) {
        ProveedorManager manager = new ProveedorManager();
        ArrayList<ArrayList<Object>> lista = manager.proveedorSelectAll();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
}
