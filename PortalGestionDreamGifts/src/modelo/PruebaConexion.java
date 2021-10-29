package modelo;
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
    
    public void conexion(){
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
        try{
            Statement request = conectar.createStatement();
            int resultado;
            resultado = request.executeUpdate("INSERT INTO `DreamGifts_db`.`Cliente` (`RUT`, `Nombre`, `Fecha Nacimiento`, `Celular`, `Email`, `Direccion`) VALUES ('19.892.711-K', 'Lucas Vargas', '1998/06/20', '+56 9 95897686', 'mail.com', 'La Llaveria Norte 5404');");
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: \n"+e.getMessage());
        }
        
    }
    public static void main(String [] arg){
        PruebaConexion con = new PruebaConexion();
        con.conexion();
    }
}