/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
        
/**
 *
 * @author luvar
 */
public class ClienteManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void AgregarCliente(String RUT, String nombre, String fechaNacimiento, String celular, String email, String direccion){
        PreparedStatement stm = null;
        boolean resultado;
        try{
            stm = conexion.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?)");
            stm.setString(1, RUT);
            stm.setString(2, nombre);
            stm.setString(3, fechaNacimiento);
            stm.setString(4, celular);
            stm.setString(5, email);
            stm.setString(6, direccion);
            
            resultado = stm.execute();
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }  
    }

    
    public ResultSet SeleccionarClientes(){
        Statement stm = null;
        ResultSet resultado = null;
        try{
            stm = conexion.createStatement();
            
            resultado = stm.executeQuery("SELECT * FROM Cliente");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return resultado;
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
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ClienteManager clientemngr = new ClienteManager();
        ResultSet cliente = clientemngr.SeleccionarClientes();
        clientemngr.InfoClientes(cliente);
        clientemngr.AgregarCliente("4.432.654-4", "Bernardo", "1920/10/09", "2312321", "mimail@mail.com", "Calle Nueva 1234");
    }
}
