/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.*;
import java.lang.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author luvar
 */
public class PruebaConexion{
    
    Connection conectar=null; 
    
    public Connection conexion(){
        String address = null;
        String database = null;
        String user = null;
        String pass = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            address = JOptionPane.showInputDialog(null,"IP Base de Datos","localhost");
            if(address.isEmpty()|| address == null) throw new Exception("Dirección Incorrecta");
            
            database = JOptionPane.showInputDialog("Nombre Base de Datos");
            if(database.isEmpty()|| database == null) throw new Exception("Base de Datos Incorrecta");
            
            user = JOptionPane.showInputDialog("Usuario");
            if(user.isEmpty()|| user == null) throw new Exception("Usuario Incorrecto");
            
            JPasswordField pwd = new JPasswordField(20);
            pass = "";
            int action = JOptionPane.showConfirmDialog(null, pwd,"Introducir Contraseña",JOptionPane.OK_CANCEL_OPTION);
            if(action < 0| action == 2) throw new Exception("Contraseña Incorrecta");
            else pass = new String(pwd.getPassword());
        } catch(Exception e){
        JOptionPane.showMessageDialog(null,"Whoops! Error: " + e.getMessage());}
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://" + address + "/"+ database,user,pass);
            JOptionPane.showMessageDialog(null,"Conexion Establecida OK.");
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Error Conexion: \n"+e.getMessage());  
        }
        return conectar;
    }
    public static void main(String [] arg){
        PruebaConexion con = new PruebaConexion();
        con.conexion();
    }
}
