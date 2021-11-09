/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import bd.Log;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
/**
 *
 * @author luvar
 */
public class ClienteManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void agregarClienteSQL(String RUT, String nombre, String fechaNacimiento, String celular, String email){
        PreparedStatement comando = null;
        try{
            comando = conexion.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?)");
            comando.setString(1, RUT);
            comando.setString(2, nombre);
            comando.setString(3, fechaNacimiento);
            comando.setString(4, celular);
            comando.setString(5, email);
            
            comando.execute();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
    }

    
    public ArrayList<ArrayList<Object>> clientesSelectAllSQL(){
        
        PreparedStatement comando = null;
        ResultSet resultado = null;
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        ArrayList<Object> lista = new ArrayList<>();
        
        try{
            comando = conexion.prepareStatement("SELECT * FROM Cliente"); 
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                String RUT = resultado.getString("RUT");
                String nombre = resultado.getString("Nombre");
                String fecha = resultado.getString("Fecha Nacimiento");
                String celular = resultado.getString("Celular");
                String email = resultado.getString("Email");
                
                lista.add(RUT);
                lista.add(nombre);
                lista.add(fecha);
                lista.add(celular);
                lista.add(email);
                
                matriz.add(lista);
                }
            
                
            
        } catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
        }
        
        return matriz;
    }
    
    // Funcion debug
    public void InfoClientes(ResultSet cliente){
        
        try{
            while(cliente.next()){
                System.out.println("RUT: " + cliente.getString("RUT"));
                System.out.println("nombre: " + cliente.getString("Nombre"));
                System.out.println("fechaNacimiento: " + cliente.getString("Fecha Nacimiento"));
                System.out.println("celular: " + cliente.getString("Celular"));
                System.out.println("email: " + cliente.getString("Email"));
                System.out.println("direccion: " + cliente.getString("Direccion"));
                System.out.println("\n");
            }
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
//    public static void main(String[] args) {
//        ClienteManager clientemngr = new ClienteManager();
//        ResultSet cliente = clientemngr.SeleccionarClientes();
//        clientemngr.InfoClientes(cliente);
//        clientemngr.AgregarCliente("4.432.654-4", "Bernardo", "1920/10/09", "2312321", "mimail@mail.com", "Calle Nueva 1234");
//    }
}
