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
        Statement stm = null;
        int resultado = -1;
        try{
            stm = conexion.createStatement();
            
            resultado = stm.executeUpdate("INSERT INTO Cliente (`RUT`, `Nombre`, `Fecha Nacimiento`, `Celular`, `Email`, `Direccion`) VALUES " + String.format("(%s,%s,%s,%s,%s,%s)",RUT,nombre,fechaNacimiento,celular,email,direccion));
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
    
//    public static void main(String[] args) {
//        ClienteManager clientemngr = new ClienteManager();
//        ResultSet cliente = clientemngr.SeleccionarClientes();
//        clientemngr.InfoClientes(cliente);
//        clientemngr.AgregarCliente("21.432.654-4", "Lolardo", "1920/10/23", "2312321", "mimail@mail.com", "Calle Nueva 123");
//    }
}
