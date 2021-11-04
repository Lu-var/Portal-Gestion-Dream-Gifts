/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;
        
/**
 *
 * @author luvar
 */
public class ClienteManager {
    
    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();
    
    public void AgregarCliente(String RUT, String nombre, String fechaNacimiento, String celular, String email, String direccion){
        PreparedStatement comando = null;
        boolean resultado;
        try{
            comando = conexion.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?)");
            comando.setString(1, RUT);
            comando.setString(2, nombre);
            comando.setString(3, fechaNacimiento);
            comando.setString(4, celular);
            comando.setString(5, email);
            comando.setString(6, direccion);
            
            resultado = comando.execute();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
    }

    
    public ResultSet SeleccionarClientes(){
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            comando = conexion.prepareStatement("SELECT * FROM Cliente"); 
            resultado = comando.executeQuery();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
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
